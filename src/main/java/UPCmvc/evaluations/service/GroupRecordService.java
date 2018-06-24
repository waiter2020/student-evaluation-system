package UPCmvc.evaluations.service;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.model.Admin;
import UPCmvc.common.model.Class;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.AdminRepository;
import UPCmvc.common.repository.ClassRepository;
import UPCmvc.common.repository.StudentRository;
import UPCmvc.evaluations.model.GroupRecord;
import UPCmvc.evaluations.model.StudentRecord;
import UPCmvc.evaluations.repository.GroupRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by waiter on 18-4-17.
 */
@Service
public class GroupRecordService {
    @Autowired
    GroupRecordRepository groupRecordRepository;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentRository studentRository;

    public Object getGropRecord(String stuNum,String class_id){
        Iterable<GroupRecord> groupRecords;
        int classId=classRepository.findClassById(Integer.valueOf(class_id.trim())).getId();
        Admin admin=adminRepository.findFirstByStuNum(stuNum);
        if(admin==null)return new JsonMes(-1,"您没有访问权限");
        int identity = admin.getIdentity();
        if(identity==0){
            groupRecords = groupRecordRepository.findAllByClassIdAndEvaluatorIdOrderByGrade(classId,stuNum);
            if(!groupRecords.iterator().hasNext()){
                Iterator<Student> studentIterator=studentRository.findAllByClassId(classId).iterator();
                List<GroupRecord> groupRecordList = new LinkedList<GroupRecord>();
                while (studentIterator.hasNext()){
                    Student student = studentIterator.next();
                    groupRecordList.add(new GroupRecord(stuNum,student.getClassId(),Integer.toString(student.getStuNumber()),
                            student.getStuName(),new Date(),-1,false));
                }
                groupRecords=groupRecordList;
            }else if(groupRecords.iterator().next().isIscommit())return new JsonMes(0,"本班级评价已完成");
        }else {
            if(admin.getClassId()!=classId)return new JsonMes(-1,"您没有访问权限");
            groupRecords = groupRecordRepository.findAllByEvaluatorIdOrderByGrade(stuNum);
            if(!groupRecords.iterator().hasNext()){
                Iterator<Student> studentIterator=studentRository.findAllByClassId(classId).iterator();
                List<GroupRecord> groupRecordList = new LinkedList<GroupRecord>();
                while (studentIterator.hasNext()){
                    Student student = studentIterator.next();
                    if(student.getStuNumber()==Integer.valueOf(stuNum.trim()))continue;
                    groupRecordList.add(new GroupRecord(stuNum,student.getClassId(),Integer.toString(student.getStuNumber()),
                            student.getStuName(),new Date(),-1,false));
                }
                groupRecords=groupRecordList;
            }else if(groupRecords.iterator().next().isIscommit())return new JsonMes(0,"本班级评价已完成");
        }
        return groupRecords;
    }

    public Object save(Iterable<GroupRecord> groupRecords,boolean b){
        String message="保存成功";
//        String eId = groupRecords.iterator().next().getEvaluatorId();
//        int id = groupRecords.iterator().next().getClassId();
        int code=0;
        if(!b){
            //groupRecordRepository.removeAllByEvaluatorIdAndClassId(eId,id);
            groupRecordRepository.save(groupRecords);
        }else {
            int Anum = 0,i=0;
            Iterator<GroupRecord> groupRecordIterator = groupRecords.iterator();
            while (groupRecordIterator.hasNext()){
                i++;
                GroupRecord groupRecord = groupRecordIterator.next();
                if(String.valueOf(groupRecord.getRank()).equals("")){
                    code=-1;
                    message="请完成所有评价！";
                    break;
                }
                if(groupRecord.getRank()=='A')Anum++;
                switch (groupRecord.getRank()){
                    case 'A':
                        groupRecord.setGrade(90);
                        break;
                    case 'B':
                        groupRecord.setGrade(80);
                        break;
                    case 'C':
                        groupRecord.setGrade(70);
                        break;
                    case 'D':
                        groupRecord.setGrade(60);
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
                Iterator<GroupRecord> groupRecordIterator1 = groupRecords.iterator();
                while (groupRecordIterator1.hasNext()){
                    GroupRecord groupRecord=groupRecordIterator1.next();
                    groupRecord.setIscommit(b);
                    groupRecord.setEvaluationDate(new Date());
                }
                //groupRecordRepository.removeAllByEvaluatorIdAndClassId(eId,id);
                groupRecordRepository.save(groupRecords);
                message="提交成功";
            }
        }
        return new JsonMes(code,message);
    }
}
