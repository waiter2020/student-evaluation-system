package UPCmvc.development.service;

import UPCmvc.common.model.Student;
import UPCmvc.common.service.StudentService;
import UPCmvc.development.dao.DevReportDao;
import UPCmvc.development.model.DevReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by chenzifeng on 2017/6/11.
 */
@Service
public class DevelopScoreService {
    @Autowired
    DevReportDao devReportDao;

    @Autowired
    StudentService studentService;

    /**
     * 发展性成绩得分
     * @param studentNo
     * @return
     */
    public double getDScore(int studentNo) {

////        if(devReportDao.findByStudentNo(studentNo)==null)
////            return 60;
        double sumScore=0; //所得分
        Iterable<DevReport> devReportIterable = devReportDao.findByStudentNo(studentNo);
        Iterator <DevReport> devReportIterator = devReportIterable.iterator();
        while (devReportIterator.hasNext()) {
            DevReport devReport = devReportIterator.next();
            if (devReport.getApprove()==1) {
                sumScore = sumScore + devReport.getNum();
            }
        }
        //发展性素质测评成绩计算公式：（80+(所得分-平均分)）/10-5
        double result = (80+ sumScore - getAverageScore())/10 -5;
        if (result>5.0) {
            result =5.0;
        }
        return result;
    }

    public Object setFeedback(int id,String feedback){
        DevReport devReport=devReportDao.findOne(id);
        devReport.setFeedback(feedback);
        return devReportDao.save(devReport);
    }

    public double getAverageScore(){
       //获取总分
        double sumScore=0;
        Iterable<DevReport> devIters = devReportDao.findAll();
       Iterator<DevReport> devReportIterator = devIters.iterator();
        while (devReportIterator.hasNext()){
            DevReport devReport = devReportIterator.next();
            if (devReport.getApprove()==1) {
                sumScore += devReport.getNum();
            }
        }
        //获取总人数
        int sumStudentNum = 0;
        Iterable<Student>  studentIterators =  studentService.listAllStudent();
        Iterator<Student> studentIterator = studentIterators.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            sumStudentNum+=1;
        }
        if (sumStudentNum==0) {
            return 80;
        }
        return sumScore/sumStudentNum;
    }

}
