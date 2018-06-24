package UPCmvc.documentary.controller;

import UPCmvc.documentary.dao.DocumentaryDao;
import UPCmvc.documentary.dao.DocumentaryGradeDao;
import UPCmvc.documentary.model.DocumentaryGrade;
import UPCmvc.documentary.service.ComputerService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfl on 2017/4/30.
 */

@RestController
@RequestMapping("/documentary")
public class DoDocumentaryGrade {
    @Autowired
    private DocumentaryGradeDao documentaryGradeDao;
    @Autowired
    private ComputerService computerService;

    @RequestMapping("/getDocumentaryGrade")
    @JsonIgnore
    public Object getGrade(){
        return documentaryGradeDao.findAll();
    }

    @RequestMapping("/getDocumentaryGradeByNumber")
    public Object getByNumber(int studentNumber){
        computerService.computerGrade(studentNumber);
        return documentaryGradeDao.findFirstByStudentNumber(studentNumber);
    }
}
