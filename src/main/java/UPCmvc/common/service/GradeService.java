package UPCmvc.common.service;

import UPCmvc.common.model.Grade;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.GradeRepository;
import UPCmvc.common.repository.StudyGradeRepository;
import UPCmvc.common.score.GetScoreCredits;
import UPCmvc.development.service.DevelopScoreService;
import UPCmvc.documentary.service.ComputerService;
import UPCmvc.evaluation.service.GroupEvaGradeService;
import UPCmvc.evaluation.service.StudentEvaGradeService;
import UPCmvc.evaluations.model.EvaGrade;
import UPCmvc.evaluations.service.EvaGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    /*
    @Autowired
    private GroupEvaGradeService groupEvaGradeService;
    @Autowired
    private StudentEvaGradeService studentEvaGradeService;
    */
    @Autowired
    private EvaGradeService evaGradeService;
    @Autowired
    private ComputerService computerService;
    @Autowired
    private DevelopScoreService developScoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GetScoreCredits getScoreCredits;
    @Autowired
    private StudyGradeRepository studyGradeRepository;

    public Object findAllGrade() {
        getAllGrade();
        return gradeRepository.findAll();
    }

    public Grade findOneGrade(int stuId) {
        getOneGrade(stuId);
        return gradeRepository.findByStuNum(stuId);
    }

    public Object findByClassId(int classId) {
        Iterable<Student> studentIterable = studentService.findByClassId(classId);
        Iterator<Student> studentIterator = studentIterable.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            getOneGrade(student.getStuNumber());
        }
        return gradeRepository.findByClassIdOrderByStuNum(classId);
    }

    private void getAllGrade() {
        Iterable<Grade> grades = gradeRepository.findAll();
        Iterator<Grade> gradeIterator = grades.iterator();
        while (gradeIterator.hasNext()) {
            Grade grade = gradeIterator.next();
            if(grade.getStuEva()==-1||grade.getGroupEva()==-1)
            getOneGrade(grade.getStuNum());
        }
    }

    private void getOneGrade(int stuId) {
        Grade grade = new Grade();
        Student student = new Student();

        double basis5;
        double develop5;
        double study5;
        grade = gradeRepository.findByStuNum(stuId);
        student = studentService.findByStuId(stuId);

        if (grade == null) {
            grade = new Grade(stuId, student.getClassId(), student.getStuName(), 0, 0, 0, 0, 0, 0, 0, 0);
            gradeRepository.save(grade);
        }
        if(studyGradeRepository.findFirstByStuNum(stuId)!=null) {
            study5 = studyGradeRepository.findFirstByStuNum(stuId).getGrade();
        }
        else {study5=0;}//防止成绩未导入同学
        //double study=90;
        /*
        double group = groupEvaGradeService.findByStuId(stuId).getAvgGrade();
        double studentEva = studentEvaGradeService.findGrade(stuId).getAvgGrade();
        */

        double group = evaGradeService.getGEva(Integer.toString(stuId));

        double studentEva = evaGradeService.getSEva(Integer.toString(stuId));
        if(group==-1||studentEva==-1)return;

        double documentary = computerService.findOneGrade(stuId).getGrade();
        double develop = developScoreService.getDScore(stuId);

        grade.setStuEva(studentEva);
        grade.setGroupEva(group);
        grade.setEvaluate(group * 0.4 + 0.6 * studentEva);
        double basis = grade.getEvaluate() * 0.4 + documentary * 0.6;
        grade.setDocumentary(documentary);
        grade.setBasis(basis);
        grade.setDevelopment(develop);
        grade.setStudy(study5);


            basis5=basis / 10 - 5;
            if(basis5<0)basis5=0;

            develop5=develop / 10 - 5;
            if(develop5<0)develop5=0;

        double sum = study5 * 0.8 + basis5* 0.1 + develop5 * 0.1;


        grade.setSum(sum);
        gradeRepository.save(grade);
    }
}
