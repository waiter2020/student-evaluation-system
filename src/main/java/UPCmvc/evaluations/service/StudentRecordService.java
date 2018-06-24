package UPCmvc.evaluations.service;


import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.StudentRository;
import UPCmvc.evaluations.model.StudentRecord;
import UPCmvc.evaluations.repository.StudentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by waiter on 18-4-16.
 */
@Service
public class StudentRecordService {

    @Autowired
    private StudentRecordRepository studentRecordRepository;

    @Autowired
    private StudentRository studentRository;

    /***
     * 获取评价列表
     * @param stuId 学生学号
     * @return 列表
     */
    public Object getRecord(String stuId){
        Iterable<StudentRecord> studentRecords = studentRecordRepository.findAllByEvaluatorIdOrderByGrade(stuId.trim());

        if(!studentRecords.iterator().hasNext()){
            Iterable<Student> students=studentRository.findAllByClassId(studentRository.findByStuNumber(Integer.valueOf(stuId.trim())).getClassId());
            Iterator<Student> studentIterator = students.iterator();
            List<StudentRecord> studentRecordList = new LinkedList<StudentRecord>();
            while (studentIterator.hasNext()){
                Student student = studentIterator.next();
                if(student.getStuNumber()==Integer.valueOf(stuId.trim()))continue;
                StudentRecord studentRecord = new StudentRecord(stuId,Integer.toString(student.getStuNumber()),
                        student.getStuName(),new Date(),-1,false);
                studentRecordList.add(studentRecord);
            }
            studentRecords=studentRecordList;
        }else if(studentRecords.iterator().next().isIscommit()){
            return new JsonMes(-2,"已经评价过了");
        }
        return studentRecords;
    }

    /***
     * 保存或提交评价
     * @param studentRecords 评价列表
     * @param b 保存或提交
     * @return 结果消息
     */
    public Object save(Iterable<StudentRecord> studentRecords,boolean b){
        String message="保存成功";
        int code=0;
        if(!b){
            studentRecordRepository.save(studentRecords);
        }else {
            int Anum = 0,i=0;
            Iterator<StudentRecord> studentRecordIterator = studentRecords.iterator();
            while (studentRecordIterator.hasNext()){
                i++;
                StudentRecord studentRecord = studentRecordIterator.next();
                if(String.valueOf(studentRecord.getRank()).equals("")){
                    code=-1;
                    message="请完成所有评价！";
                    break;
                }
                if(studentRecord.getRank()=='A')Anum++;
                if(studentRecord.getRank()=='A')Anum++;
                switch (studentRecord.getRank()){
                    case 'A':
                        studentRecord.setGrade(90);
                        break;
                    case 'B':
                        studentRecord.setGrade(80);
                        break;
                    case 'C':
                        studentRecord.setGrade(70);
                        break;
                    case 'D':
                        studentRecord.setGrade(60);
                        break;
                    default:
                        return -1;

                }
            }
            if(Anum>i/2){
                code=-2;
                message="A等级原则上不超过50%，请修改";
            }
            if (code==0){
                Iterator<StudentRecord> studentRecordIterato = studentRecords.iterator();
                while (studentRecordIterato.hasNext()){
                    StudentRecord studentRecord=studentRecordIterato.next();
                    studentRecord.setIscommit(b);
                    studentRecord.setEvaluationDate(new Date());
                }
                studentRecordRepository.save(studentRecords);
                message="提交成功";
            }
        }
        return new JsonMes(code,message);
    }
}













