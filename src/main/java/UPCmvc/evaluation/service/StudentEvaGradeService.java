package UPCmvc.evaluation.service;

import UPCmvc.common.model.Student;
import UPCmvc.common.service.ClassService;
import UPCmvc.common.service.StudentService;
import UPCmvc.evaluation.model.EvaluationRecord;
import UPCmvc.evaluation.model.StudentEvaGrade;
import UPCmvc.evaluation.repository.EvaRecordRepository;
import UPCmvc.evaluation.repository.StudentEvaGradeRepository;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jay on 4/30/2017.
 */
@Service
public class StudentEvaGradeService {
    java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0000");

    @Autowired
    private StudentEvaGradeRepository studentEvaGradeRepository;
    @Autowired
    private EvaRecordRepository evaRecordRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    public StudentEvaGrade findGrade(int studentId) {
        if (studentEvaGradeRepository.findByStudentId(studentId)==null)
        {
            StudentEvaGrade studentEvaGrade=new StudentEvaGrade(studentId,00,0,0,0,0,0);
            studentEvaGradeRepository.save(studentEvaGrade);

        }
        return studentEvaGradeRepository.findByStudentId(studentId);
    }
    public void addGrade(int studentId, char gradeKind) {

        StudentEvaGrade studentEvaGrade = findGrade(studentId);

        switch (gradeKind) {
            case 'A':
                int A = studentEvaGrade.getGradeANum();
                studentEvaGrade.setGradeANum(A + 1);
                break;
            case 'B':
                int B = studentEvaGrade.getGradeBNum();
                studentEvaGrade.setGradeBNum(B + 1);
                break;
            case 'C':
                int C = studentEvaGrade.getGradeCNum();
                studentEvaGrade.setGradeCNum(C + 1);
                break;
            case 'D':
                int D = studentEvaGrade.getGradeDNum();
                studentEvaGrade.setGradeDNum(D + 1);
                break;
        }
        studentEvaGradeRepository.save(studentEvaGrade);
//        System.out.println(calAvgGrade(studentId));
        studentEvaGrade.setAvgGrade(calAvgGrade(studentId));
        System.out.println(studentEvaGrade.getGradeANum());
        studentEvaGradeRepository.save(studentEvaGrade);
    }

    public int findEvaTimes(int studentId) {
        StudentEvaGrade studentEvaGrade = studentEvaGradeRepository.findByStudentId(studentId);
        return studentEvaGrade.getEvaTimes();
    }

    public void addEvaTimes(int studentId) {
        StudentEvaGrade studentEvaGrade = findGrade(studentId);
        int times = studentEvaGrade.getEvaTimes() + 1;
        studentEvaGrade.setEvaTimes(times);
        studentEvaGradeRepository.save(studentEvaGrade);
    }

    public double calAvgGrade(int studentId) {
        StudentEvaGrade studentEvaGrade = findGrade(studentId);
        int classStuNum=classService.findStuNumByStuId(studentId);
        double num = studentEvaGrade.getGradeANum() + studentEvaGrade.getGradeBNum() + studentEvaGrade.getGradeCNum() + studentEvaGrade.getGradeDNum();
        //num为该学生被评的所有等级总个数  当评价数=班级人数时  计算成绩
        StudentEvaGrade studentEvaGrade1=new StudentEvaGrade();
        studentEvaGrade1.setStudentId(studentEvaGrade.getStudentId());
        studentEvaGrade1.setGradeANum(studentEvaGrade.getGradeANum());
        studentEvaGrade1.setGradeBNum(studentEvaGrade.getGradeBNum());
        studentEvaGrade1.setGradeCNum(studentEvaGrade.getGradeCNum());
        studentEvaGrade1.setGradeDNum(studentEvaGrade.getGradeDNum());
        if (num>4){
             studentEvaGrade1=remove(studentEvaGrade1);
//           A为优秀计95分，B为良好计85分，C为及格计70分，D为不及格计55分
//            System.out.println(studentEvaGrade1.getGradeANum());
//            System.out.println(studentEvaGrade1.getGradeBNum());
//            System.out.println(studentEvaGrade1.getGradeCNum());
//            System.out.println(studentEvaGrade1.getGradeDNum());
            double avgGrade = (studentEvaGrade1.getGradeANum() * 95 + studentEvaGrade1.getGradeBNum() * 85 + studentEvaGrade1.getGradeCNum() * 70 + studentEvaGrade1.getGradeDNum() * 55) / (num-2);
            System.out.println(avgGrade);
            avgGrade=Double.valueOf(df.format(avgGrade));

            studentEvaGrade.setEvaGrade(avgGrade);
       //     System.out.println(studentEvaGrade.getAvgGrade());
        }
        return studentEvaGrade.getAvgGrade();

    }

    public StudentEvaGrade remove(StudentEvaGrade studentEvaGrade){
        List<EvaluationRecord> evaluationRecords=evaRecordRepository.findByBeEvaluatedNumOrderByGradeDesc(studentEvaGrade.getStudentId());
        int num=evaluationRecords.size();
        System.out.println(num);
        System.out.println(evaluationRecords.get(0).getId());
        EvaluationRecord records=evaluationRecords.get(0);
        studentEvaGrade=subtraction(studentEvaGrade,records.getGrade());
        records=evaluationRecords.get(num-1);
        studentEvaGrade=subtraction(studentEvaGrade,records.getGrade());
//        System.out.println(studentEvaGrade.getGradeANum());
//        System.out.println(studentEvaGrade.getGradeBNum());
        return studentEvaGrade;
    }
      //减掉某条记录
    private StudentEvaGrade subtraction(StudentEvaGrade studentEvaGrade,char grade){
        if (grade=='A'){
            studentEvaGrade.setGradeANum(studentEvaGrade.getGradeANum()-1);

        }else if (grade=='B'){
            studentEvaGrade.setGradeBNum(studentEvaGrade.getGradeBNum()-1);

        }else if (grade=='C'){
            studentEvaGrade.setGradeCNum(studentEvaGrade.getGradeCNum()-1);

        }else if (grade=='D'){
            studentEvaGrade.setGradeDNum(studentEvaGrade.getGradeDNum()-1);

        }
        return studentEvaGrade;
    }
}