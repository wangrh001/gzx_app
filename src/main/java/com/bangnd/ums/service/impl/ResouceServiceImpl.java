package com.bangnd.ums.service.impl;

import com.bangnd.ums.entity.RolePrivilege;
import com.bangnd.ums.entity.UserRole;
import com.bangnd.ums.repository.ResourceRepository;
import com.bangnd.ums.repository.RolePrivilegeRepository;
import com.bangnd.ums.repository.UserRoleRepository;
import com.bangnd.ums.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bangnd.ums.entity.Resource;

import java.util.List;

@Service
public class ResouceServiceImpl implements ResourceService {

    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RolePrivilegeRepository rolePrivilegeRepository;
    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public String getMenuTreeString(long id) {
        String menuTree = "";
        List<Resource> sonResources;
        //获取该用户下的所有角色，用户和角色是多对多关系
        List<UserRole> userRoles = userRoleRepository.findAllByUserId(id);
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                //获取这个角色下所有角色权限对象，角色和权限是多对多关系
                List<RolePrivilege> rolePrivileges = rolePrivilegeRepository.findAllByRole(userRole.getRoleId());
                if (rolePrivileges != null) {
                    int countParentMenu = 0;
                    for (RolePrivilege rolePrivilege : rolePrivileges) {
                        //获取所有资源
                        Resource resouce = resourceRepository.findOne(rolePrivilege.getResId());
                        //1是菜单；2是按钮
                        if (resouce.getType() == 1 && resouce.getParentId() == 0) {
                            countParentMenu++;
                            if (countParentMenu == 1) {
                                menuTree = menuTree + "{id:" + resouce.getId() + ",text:" + resouce.getName() + ",url:'" + resouce.getResUrl() + "'";
                            } else {
                                menuTree = menuTree + ",{id:" + resouce.getId() + ",text:" + resouce.getName() + ",url:'" + resouce.getResUrl() + "'";
                            }
                            sonResources = resourceRepository.findAllByParentId(resouce.getId());
                            if (sonResources != null) {
                                menuTree = menuTree + ",menus:[";
                                int countSonMenu = 0;
                                for (Resource resource : sonResources) {
                                    countSonMenu++;
                                    if (countSonMenu < sonResources.size()) {
                                        menuTree = menuTree + "{id:" + resource.getId() + ",text:" + resource.getName() + ",url:'" + resource.getResUrl() + "'},";
                                        //最后一个子菜单末尾要加上 "]}"
                                    } else {
                                        menuTree = menuTree + "{id:" + resource.getId() + ",text:" + resource.getName() + ",url:'" + resource.getResUrl() + "'}]}";
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(menuTree);
        return "[" + menuTree + "]";
    }


    /**
     * 测试用户获取将资源list拼成菜单树型的字符串
     * {id: '1',
     * text: '核心业务系统',
     * url: '',
     * menus: [{
     * id: '11',
     * text: '订单管理',
     * url: '/order'}]}
     */
    public static void main(String[] args) {
        ResouceServiceImpl resouceService = new ResouceServiceImpl();
        System.out.println(resouceService.getMenuTreeString(1));

    }
}
