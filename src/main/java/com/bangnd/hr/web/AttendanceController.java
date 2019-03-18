package com.bangnd.hr.web;

import com.bangnd.hr.entity.Attendance;
import com.bangnd.hr.form.AttendanceSearchForm;
import com.bangnd.hr.service.AttendanceAskTypeService;
import com.bangnd.hr.service.AttendanceService;
import com.bangnd.hr.vo.AttendanceVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;
    @Resource
    AttendanceAskTypeService attendanceAskTypeService;

    @RequestMapping("/hr/attendance")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, AttendanceSearchForm attendanceSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<Attendance> pages = attendanceService.getAttendanceList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,attendanceSearchForm);
        model.addAttribute("askTypes", attendanceAskTypeService.getAll());
        List<AttendanceVO> attendanceVOs = new ArrayList<>();
        if (pages != null) {
            for (Attendance attendance : pages) {
                AttendanceVO attendanceVO = new AttendanceVO();
                attendanceVO.setId(attendance.getId());
                attendanceVO.setEmpName(attendance.getEmpName());
                attendanceVO.setWorkDay(attendance.getWorkDay());
                attendanceVO.setAskTypeName((attendanceAskTypeService.getAttendanceAskTypeById(attendance.getAskType())).getName());
                attendanceVOs.add(attendanceVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
        model.addAttribute("attendanceVOs", attendanceVOs);
        return "/hr/attendanceList";
    }

    @RequestMapping("/hr/attendance/toAdd")
    public String toAdd(Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        model.addAttribute("askTypes", attendanceAskTypeService.getAll());
        return "/hr/attendanceAdd";
    }

    @RequestMapping("/hr/attendance/add")
    public String add(Attendance attendance) {
        attendance.setState(ConstantCfg.ORDER_STATE_INITIAL);
        attendance.setCreator(0);
        attendance.setCreateTime(new Date());
        attendanceService.save(attendance);
        return "redirect:/hr/attendance";
    }

    @RequestMapping("/hr/attendance/toModify")
    public String toModify(Model model, Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        model.addAttribute("attendance", attendance);
        model.addAttribute("askTypes", attendanceAskTypeService.getAll());
        return "/hr/attendanceAdd";
    }

    @RequestMapping("/hr/attendance/modify")
    public String modify(Attendance attendance, Long id) {
        Attendance oldAttendance = attendanceService.getAttendanceById(id);
        oldAttendance.setEmpName(attendance.getEmpName());
        oldAttendance.setMonth(attendance.getMonth());
        oldAttendance.setWorkDay(attendance.getWorkDay());
        oldAttendance.setCheckTime(attendance.getCheckTime());
        oldAttendance.setAskType(attendance.getAskType());
        oldAttendance.setAskBeginTime(attendance.getAskBeginTime());
        oldAttendance.setAskEndTime(attendance.getAskEndTime());
        oldAttendance.setUpdator(0);
        oldAttendance.setUpdateTime(new Date());
        attendanceService.merge(oldAttendance);
        return "redirect:/hr/attendance/toModify?id=" + id;
    }

    @RequestMapping("/hr/attendance/delete")
    public String delete(Long id) {
        Attendance oldAttendance = attendanceService.getAttendanceById(id);
        oldAttendance.setState(100);
        oldAttendance.setUpdator(0);
        oldAttendance.setUpdateTime(new Date());
        attendanceService.merge(oldAttendance);
        return "redirect:/hr/attendance";
    }
}