package UPCmvc.documentary.service;

import UPCmvc.common.service.GradeService;
import UPCmvc.documentary.dao.DocumentaryDao;
import UPCmvc.documentary.dao.DocumentaryGradeDao;
import UPCmvc.documentary.model.Documentary;
import UPCmvc.documentary.model.DocumentaryGrade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Iterator;

/**
 * Created by zfl on 2017/4/30.
 */
@Service
public class ComputerService {
    @Autowired
    private DocumentaryDao documentaryDao;

    @Autowired
    private DocumentaryGradeDao documentaryGradeDao;

    @Autowired
    private GradeService gradeService;
    public void computerGrade(int studentNumber){
        double nowgrade;
        Iterable<Documentary> record = documentaryDao.findByStudentNumber(studentNumber);
        Iterator<Documentary> studentrecord = record.iterator();
        DocumentaryGrade documentaryGrade=documentaryGradeDao.findFirstByStudentNumber(studentNumber);
        if (documentaryGrade==null){
            documentaryGrade=new DocumentaryGrade();
            documentaryGrade.setGrade(50.00);
            documentaryGrade.setStudentNumber(studentNumber);
        }
            nowgrade = 50.00;
            while (studentrecord.hasNext()){
                Documentary documentary = studentrecord.next();
                if(documentary.isAgree()){
                    nowgrade = nowgrade + documentary.getScore();
                }
            }
            if (nowgrade>=60){
                nowgrade=60;
            }
            documentaryGrade.setGrade(nowgrade);
            documentaryGradeDao.save(documentaryGrade);
            gradeService.findOneGrade(studentNumber);
    }

    public DocumentaryGrade findOneGrade(int stuId){
        computerGrade(stuId);
        return documentaryGradeDao.findFirstByStudentNumber(stuId);
    }
}
