package UPCmvc.common.controller;

import UPCmvc.common.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@RestController
@RequestMapping("/common")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "/listclassStudent",method = RequestMethod.GET)
    public Object listClassStudent(int classId){
        return studentService.findByClassId(classId);
    }

    @RequestMapping(value = "/findonebystuid",method = RequestMethod.GET)
    public  Object findOneByStuId(int stuId){
        return studentService.findByStuId(stuId);
    }

    @RequestMapping(value = "/findonebyybid",method = RequestMethod.GET)
    public  Object findOneByStuYbid(int ybid){
        return studentService.findByYibanId(ybid);
    }

    @RequestMapping(value = "/getmessage",method = RequestMethod.GET)
    public Object getAuthMessage(){
        return httpSession.getAttribute("realuser");
    }

    @RequestMapping(value = "/createstudent",method = RequestMethod.POST)
    public Object createStudent(int classId, int professionId, int stuNumber,
                                int grade, String stuName, String stuSex){
        return studentService.createStudent(classId,professionId,stuNumber,grade,stuName,stuSex);
    }

}
