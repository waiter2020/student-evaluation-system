package UPCmvc.common.controller;

import UPCmvc.common.service.GradeService;
import UPCmvc.common.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@RestController
@RequestMapping("/common")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("/findallgrade")
    public Object findAllGrade(){
        return gradeService.findAllGrade();
    }
    @RequestMapping("/findonegrade")
    public Object findOneGrade(int stuId){
        return gradeService.findOneGrade(stuId);
    }

    @RequestMapping("/findbyclassid")
    public Object findByClassId(int classId){

     return gradeService.findByClassId(classId);
    }

}
