package UPCmvc.evaluation.service;

import UPCmvc.common.dto.JsonMes;
import UPCmvc.common.model.Admin;
import UPCmvc.common.model.Student;
import UPCmvc.common.service.AdminService;
import UPCmvc.common.service.ClassService;
import UPCmvc.common.service.StudentService;
import UPCmvc.evaluation.model.EvaluationRecord;
import UPCmvc.evaluation.model.GroupEvaGrade;
import UPCmvc.evaluation.repository.EvaRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanghaojun on 2017/4/30.
 */
@Service
public class EvaRecordService {
    @Autowired
    private EvaRecordRepository evaRecordRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentEvaGradeService studentEvaGradeService;



    @Autowired
    private AdminService adminService;

    @Autowired
    private ClassService classService;

    @Autowired
    private GroupEvaGradeService groupEvaGradeService;

    public Object createEvaRecord(String evaluatorNum, int beEvaluatedNum, char grade,int identity) {
        if (isRepeat(evaluatorNum,beEvaluatedNum)==-1)
        {
            return new JsonMes(-2,"已经评价过了");
        }
        Date evaluationDate=new Date();
        EvaluationRecord evaluationRecord=new EvaluationRecord(evaluatorNum,beEvaluatedNum,evaluationDate,grade);
        EvaluationRecord evaluationRecord1=evaRecordRepository.save(evaluationRecord);
        Student student1=studentService.findByStuId(beEvaluatedNum);
        if (identity==0){
            groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum,grade);
        }//导员身份 直接存入
        else if (identity==1) {
            Admin admin = adminService.findByStuNum(String.valueOf(evaluatorNum));
            if (admin.getClassId() == student1.getClassId()) {
                groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum, grade);
            }
            return new JsonMes(-1,"没有权限");//班级不一致
        }//班主任身份 检查班级是否一致
        else {
            Student student=studentService.findByStuId(Integer.valueOf(evaluatorNum));//

            System.out.println(student.getStuName()+student1.getStuName());
            if (student1.getClassId()==student.getClassId()){
                studentEvaGradeService.addGrade(beEvaluatedNum,grade);
                studentEvaGradeService.addEvaTimes(Integer.valueOf(evaluatorNum));
            }
            if (classService.isClassAdmin(student1.getClassId(),String.valueOf(student.getStuNumber()))){
                groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum,grade);
            }
        }//

        //else return new JsonMes(-1,"没有权限");
        return evaluationRecord1;
    }

    public Object updateEvaRecord(String evaluatorNum, int beEvaluatedNum, char grade,int identity) {
        if (isRepeat(evaluatorNum,beEvaluatedNum)==0)
        {
            return new JsonMes(-2,"未被评价");
        }
        Date evaluationDate=new Date();

        EvaluationRecord evaluationRecord=evaRecordRepository.findFirstByEvaluatorNumAndBeEvaluatedNum(evaluatorNum,beEvaluatedNum);
        evaRecordRepository.delete(evaluationRecord);
        evaluationRecord=new EvaluationRecord(evaluatorNum,beEvaluatedNum,evaluationDate,grade);
        EvaluationRecord evaluationRecord1=evaRecordRepository.save(evaluationRecord);
        Student student1=studentService.findByStuId(beEvaluatedNum);
        if (identity==0){
            groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum,grade);
        }//导员身份 直接存入
        else if (identity==1) {
            Admin admin = adminService.findByStuNum(String.valueOf(evaluatorNum));
            if (admin.getClassId() == student1.getClassId()) {
                groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum, grade);
            }
            return new JsonMes(-1,"没有权限");//班级不一致
        }//班主任身份 检查班级是否一致
        else {
            Student student=studentService.findByStuId(Integer.valueOf(evaluatorNum));//

            System.out.println(student.getStuName()+student1.getStuName());
            if (student1.getClassId()==student.getClassId()){
                studentEvaGradeService.addGrade(beEvaluatedNum,grade);
                studentEvaGradeService.addEvaTimes(Integer.valueOf(evaluatorNum));
            }
            if (classService.isClassAdmin(student1.getClassId(),String.valueOf(student.getStuNumber()))){
                groupEvaGradeService.addGroupEvaGrade(beEvaluatedNum,grade);
            }
        }//

        //else return new JsonMes(-1,"没有权限");
        return evaluationRecord1;
    }

    public Iterable<EvaluationRecord> findByBeEvaluatedNum(int id){
        return evaRecordRepository.findByBeEvaluatedNum(id);
    }

    public int isRepeat(String evaluatorNum,int beEvaluatedNum){
        EvaluationRecord evaluationRecord=evaRecordRepository.findFirstByEvaluatorNumAndBeEvaluatedNum(evaluatorNum, beEvaluatedNum);
        if (evaluationRecord==null)
            return 0;  // 没有评价
        else return -1; // 已经评价
    }
    public Iterable<EvaluationRecord> findByEvaluatorNum(String id){
        return evaRecordRepository.findByEvaluatorNum(id);
    }

    public Iterable<EvaluationRecord> listEvaluatorNum(){
        return evaRecordRepository.findAll();
    }

    public void deleteEvaRecord(int id){
        evaRecordRepository.delete(id);
    }


    public Object getNotEvaluated(String stuId,int classId){
        Iterable<Student> studentIterable=studentService.findByClassId(classId);
        Iterator<Student> studentIterator=studentIterable.iterator();
        List<Student> students=new ArrayList<Student>();
        while (studentIterator.hasNext())
        {
            Student student=studentIterator.next();
            System.out.println(student.getStuNumber());
            if (isRepeat(stuId,student.getStuNumber())==0){
                students.add(student);
                //System.out.println(student.getStuNumber());
            }
        }
        System.out.println(students.size());
        return students;
    }

    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
