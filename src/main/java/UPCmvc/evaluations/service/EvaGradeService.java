package UPCmvc.evaluations.service;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.repository.StudentRository;
import UPCmvc.evaluations.model.EvaGrade;
import UPCmvc.evaluations.model.GroupRecord;
import UPCmvc.evaluations.model.StudentRecord;
import UPCmvc.evaluations.repository.EvaGradeRepository;
import UPCmvc.evaluations.repository.GroupRecordRepository;
import UPCmvc.evaluations.repository.StudentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by waiter on 18-4-17.
 */
@Service
public class EvaGradeService {
    @Autowired
    EvaGradeRepository evaGradeRepository;
    @Autowired
    StudentRecordRepository studentRecordRepository;
    @Autowired
    GroupRecordRepository groupRecordRepository;
    @Autowired
    StudentRository studentRository;

    private double getGroupEva(String stuNum){
        int ANum=0;
        int BNum=0;
        int CNum=0;
        int DNum=0;
        List<GroupRecord> groupRecords=groupRecordRepository.findAllByBeEvaluatedIdOrderByGrade(stuNum);
        EvaGrade evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        if(evaGrade==null)evaGrade=new EvaGrade(stuNum,studentRository.findFirstByStuNumber(Integer.valueOf(stuNum)).getStuName(),-1,-1);

        if(groupRecords.size()<3)return -1;

        //去除一个最高分和一个最低分
        groupRecords.remove(0);
        groupRecords.remove(groupRecords.size()-1);
        double sum=0;
        Iterator<GroupRecord> groupRecordIterator=groupRecords.iterator();
        while (groupRecordIterator.hasNext()){
            GroupRecord groupRecord = groupRecordIterator.next();
            if(!groupRecord.isIscommit())return -1;
            sum+=groupRecord.getGrade();
            switch (groupRecord.getRank()){
                case 'A':
                    ANum++;
                    break;
                case 'B':
                    BNum++;
                    break;
                case 'C':
                    CNum++;
                    break;
                case 'D':
                    DNum++;
                    break;
                default:
                    return -1;

            }
        }
        double groupAvg = sum/groupRecords.size();
        evaGrade.setGroupGrade(groupAvg);
        evaGrade.setGroupANum(ANum);
        evaGrade.setGroupBNum(BNum);
        evaGrade.setGroupCNum(CNum);
        evaGrade.setGroupDNum(DNum);
        evaGradeRepository.save(evaGrade);
        return groupAvg;
    }

    private double getStuEva(String stuNum){
        int ANum=0;
        int BNum=0;
        int CNum=0;
        int DNum=0;
        List<StudentRecord> studentRecords = studentRecordRepository.findAllByBeEvaluatedIdOrderByGrade(stuNum);

        EvaGrade evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        if(evaGrade==null)evaGrade=new EvaGrade(stuNum,studentRository.findFirstByStuNumber(Integer.valueOf(stuNum)).getStuName(),-1,-1);
        if(studentRecords.size()<3)return -1;
        //去除一个最高分和一个最低分
        studentRecords.remove(0);
        studentRecords.remove(studentRecords.size()-1);
        double sum=0;
        Iterator<StudentRecord> studentRecordIterator = studentRecords.iterator();
        while (studentRecordIterator.hasNext()){
            StudentRecord studentRecord = studentRecordIterator.next();
            if(!studentRecord.isIscommit())return -1;
            sum+=studentRecord.getGrade();
            switch (studentRecord.getRank()){
                case 'A':
                    ANum++;
                    break;
                case 'B':
                    BNum++;
                    break;
                case 'C':
                    CNum++;
                    break;
                case 'D':
                    DNum++;
                    break;
                default:
                    return -1;

            }
        }
        double stuAvg=0;
        stuAvg=sum/studentRecords.size();
        evaGrade.setStudentGrade(stuAvg);
        evaGrade.setStuANum(ANum);
        evaGrade.setStuBNum(BNum);
        evaGrade.setStuCNum(CNum);
        evaGrade.setStuDNum(DNum);

        evaGradeRepository.save(evaGrade);
        return stuAvg;
    }

    public double getGEva(String stuNum){
        EvaGrade evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        if(evaGrade==null||evaGrade.getGroupGrade()==-1)return getGroupEva(stuNum);
        return evaGrade.getGroupGrade();
    }

    public double getSEva(String stuNum){
        EvaGrade evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        if (evaGrade==null||evaGrade.getStudentGrade()==-1)return getStuEva(stuNum);
        return evaGrade.getStudentGrade();
    }
    public Object getEva(String stuNum){
        EvaGrade evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        if(evaGrade==null){
            getStuEva(stuNum);
            getGroupEva(stuNum);
            evaGrade = evaGradeRepository.findEvaGradeByStuNum(stuNum);
        }
        if(evaGrade==null){
            return new JsonMes(-1,"评价未完成");
        }
        return evaGrade;
    }
}
