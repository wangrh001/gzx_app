package com.bangnd.batch.jobs.hr;

import com.bangnd.gw.DingDingGWService;
import com.bangnd.hr.entity.Dept;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.DeptService;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Group;
import com.bangnd.sales.service.GroupService;
import com.bangnd.util.cfg.ConstantCfg;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiUserListbypageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SyncDDEmployeeAndDept {
    @Autowired
    private DingDingGWService dingDingGWService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupService groupService;

    //获取钉钉所有部门，和部门下所有用户
    public void process(){
        try {
            String accessToken =DingDingGWService.getAccessToken();
            OapiDepartmentListResponse deptList= dingDingGWService.getAllDept(accessToken);
            if(deptList!=null && deptList.isSuccess()&&deptList.getDepartment()!=null && deptList.getDepartment().size()>0){
                for(OapiDepartmentListResponse.Department department:deptList.getDepartment()){

                    //保存部门信息
                    Dept dept = deptService.getDeptByDdId(department.getId());
                    int deptId;
                    if(dept==null){
                        Dept dept1 = new Dept();
                        dept1.setDdId(department.getId());
                        dept1.setName(department.getName());
                        dept1.setState(ConstantCfg.STATE_1);
                        dept1.setCreator(0);
                        dept1.setCreateTime(new Date());
                        if(department.getParentid()!=null){
                            Dept dept2 = deptService.getDeptByDdId(department.getParentid());
                            if(dept2!=null){
                                dept1.setParentId(dept2.getId());
                            }
                            //即：如果父ID是销售部，那么下面的组织，要同步保存到销售组织 t_sales_group中
                            if(department.getParentid()==ConstantCfg.DD_RESPONSE_SALES_DEPT){
                                Group group = new Group();
                                group.setName(department.getName());
                                group.setState(ConstantCfg.STATE_1);
                                group.setCreateTime(new Date());
                                group.setCreator(0);
                                group.setUpdator(0);
                                group.setParentId(dept2.getId());
                                groupService.save(group);
                            }
                        }

                        deptService.save(dept1);
                        deptId=dept1.getId();
                    }else {
                        dept.setName(department.getName());
                        dept.setUpdateTime(new Date());
                        dept.setUpdator(0);
                        deptService.save(dept);
                        deptId = dept.getId();
                    }

                    //获取部门下所有雇员信息
                    OapiUserListbypageResponse userList=dingDingGWService.getAllEmployee(department.getId(),accessToken);
                    if(userList!=null && userList.isSuccess() && userList.getUserlist()!=null && userList.getUserlist().size()>0){
                        for(OapiUserListbypageResponse.Userlist dduser:userList.getUserlist()){
                            Employee employee = employeeService.getEmployeeByDdUserName(dduser.getUserid());
                            if(employee==null){
                                Employee employee1 = new Employee();
                                employee1.setDept(deptId);
                                employee1.setName(dduser.getName());
                                employee1.setDdUserName(dduser.getUserid());
                                employee1.setPhone(dduser.getMobile());
                                employee1.setCreator(0);
                                employee1.setCreateTime(new Date());
                                //employee1.setPosition(dduser.getPosition());
                                employeeService.save(employee1);
                            }
                        }
                    }

                    //如果部门有负责人，取出来，并查出对应的employeeid，写入t_sales_group表中
                    OapiDepartmentGetResponse response=dingDingGWService.getDeptDetail(accessToken,department.getId());
                    String managerUseridList=response.getDeptManagerUseridList();
                    if(!"".equals(managerUseridList)&&managerUseridList!=null){
                        //只支持一个负责人
                        String userName = managerUseridList.substring(0,managerUseridList.indexOf("|"));
                        Employee employee = employeeService.getEmployeeByDdUserName(userName);
                        if(employee!=null){
                            Long deptId1 = response.getId();
                            Group group1 = groupService.getGroupByDdId(deptId1);
                            if(group1!=null){
                                group1.setEmployeeId(Long.valueOf(employee.getId()).intValue());
                                groupService.save(group1);
                            }

                        }
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

