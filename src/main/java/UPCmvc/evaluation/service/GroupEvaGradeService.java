package UPCmvc.evaluation.service;

import UPCmvc.evaluation.model.GroupEvaGrade;
import UPCmvc.evaluation.repository.GroupEvaGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * Created by wanghaojun on 2017/5/1.
 */
@Service
public class GroupEvaGradeService {
    java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0000");

    @Autowired
    private GroupEvaGradeRepository groupEvaGradeRepository;

    public GroupEvaGrade findByStuId(int stuId){
        System.out.println(stuId);
        if (groupEvaGradeRepository.findFirstByStudentId(stuId)==null)
        {
            GroupEvaGrade groupEvaGrade=new GroupEvaGrade(stuId,0,0,0,0,0);
             groupEvaGradeRepository.save(groupEvaGrade);
        }
        return groupEvaGradeRepository.findFirstByStudentId(stuId);
    }
    public void addGroupEvaGrade(int stuId,char grade) {
        GroupEvaGrade groupEvaGrade=findByStuId(stuId);
        if (grade=='A'){
            groupEvaGrade.setGradeANum(groupEvaGrade.getGradeANum()+1);
        }
        else if (grade=='B'){
            groupEvaGrade.setGradeBNum(groupEvaGrade.getGradeBNum()+1);
        }
        else if (grade=='C'){
            groupEvaGrade.setGradeCNum(groupEvaGrade.getGradeCNum()+1);
        }
        else if (grade=='D'){
            groupEvaGrade.setGradeDNum(groupEvaGrade.getGradeDNum()+1);
        }
        groupEvaGradeRepository.save(groupEvaGrade);
        groupEvaGrade.setAvgGrade(computerGroupEvaGrade(stuId));
        groupEvaGradeRepository.save(groupEvaGrade);
    }

    public double  computerGroupEvaGrade(int stuId){
        GroupEvaGrade groupEvaGrade=findByStuId(stuId);
        double num=groupEvaGrade.getGradeANum()+groupEvaGrade.getGradeBNum()+groupEvaGrade.getGradeCNum()+groupEvaGrade.getGradeDNum();
        System.out.println(num);
        double sum=groupEvaGrade.getGradeANum()*95+groupEvaGrade.getGradeBNum()*85+groupEvaGrade.getGradeCNum()*70+groupEvaGrade.getGradeDNum()*55;
        System.out.println(sum);
        if (num!=0){
            double avg=sum/num;
            avg=Double.valueOf(df.format(avg));
            System.out.println(avg);
            groupEvaGrade.setAvgGrade(avg);
        }

        return groupEvaGrade.getAvgGrade();
    }

    public Iterable<GroupEvaGrade> listAllGroupEvaGrade(){
        return groupEvaGradeRepository.findAll();
    }



}
