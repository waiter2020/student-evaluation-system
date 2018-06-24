package UPCmvc.common.service;

import UPCmvc.common.model.Class;
import UPCmvc.common.model.Profession;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.ClassRepository;
import UPCmvc.common.repository.ProfessionRepository;
import UPCmvc.common.repository.StudentRository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghaojun on 2017/4/24.
 */
@Service
public class StudentService {
    @Autowired

    private StudentRository studentRository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ProfessionRepository professionRepository;


    @Autowired
    private ClassService classService;

    public Iterable<Student> listAllStudent() {
        return studentRository.findAll();
    }

    public void deleteStudent(int id) {
        studentRository.delete(id);
    }

    public Student createStudent(int classId, int professionId, int stuNumber,
                                 int grade, String stuName, String stuSex) {
        int yibanId = 123;
        Student student = new Student(classId, professionId, stuNumber, grade, yibanId, stuName, stuSex);
        classService.addStudent(classId);
        return studentRository.save(student);
    }

    public Iterable<Student> findByClassId(int classId) {
        return studentRository.findAllByClassId(classId);
    }

    public Student findByYibanId(int yibanId) {
        return studentRository.findFirstByYibanId(yibanId);
    }

    public Iterable<Student> findByProfessionId(int professionId) {
        return studentRository.findByProfessionId(professionId);
    }

    public Student findByStuId(int stuNumber) {
        //return studentRository.findByStuNumber(stuNumber);
        return studentRository.findFirstByStuNumber(stuNumber);
    }

    public Student findOne(int id) {
        return studentRository.findOne(id);
    }

}
