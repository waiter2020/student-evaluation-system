package UPCmvc.common.service;

import UPCmvc.common.model.Admin;
import UPCmvc.common.model.Class;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.ClassRepository;
import UPCmvc.common.repository.StudentRository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghaojun on 2017/4/24.
 */
@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentRository studentRository;


    public Class createClass(String className, int professionId) {
        Class aClass = new Class(className, professionId);
        return classRepository.save(aClass);
    }

    public void deleteClass(int classId) {
        classRepository.delete(classId);
    }

    /***
     *  获取管理员名下所有班级
     * @param adminId 管理员Id
     * @return Iterable
     */
    public Iterable<Class> listClass(String adminId) {
        return classRepository.findByAdminId(adminId);
    }

    public Iterable<Class> findByProfessionId(int professionId) {
        return classRepository.findByProfessionId(professionId);
    }

    /***
     * 获取管理员名下某专业所有班级
     * @param professionId 专业编号
     * @param adminId 管理员Id
     * @return Iterable
     */
    public Iterable<Class> findByProfessionIdAndAdminId(int professionId,String adminId){
        return classRepository.findByProfessionIdAndAdminId(professionId,adminId);
    }

    /***
     * @javadoc 通过班级id获取班级
     * @param id 班级id
     * @return
     */
    public Class findOne(int id) {
        return classRepository.findOne(id);
    }

    public int addStudent(int id) {
        Class class1 = new Class();
        class1 = classRepository.findOne(id);
        class1.setStudenNumber(class1.getStudenNumber() + 1);
        classRepository.save(class1);
        return class1.getStudenNumber();
    }

    public int findStudentNumber(int classid) {
        return classRepository.findOne(classid).getStudenNumber();
    }

    public boolean isThisClass(int classId, int stuId) {
        Student student = studentRository.findByClassIdAndStuNumber(classId, stuId);
        if (student == null) {
            return false;
        } else return true;
    }

    //判断是否为管理员
    public boolean isClassAdmin(int classId, String stuNum) {
        Admin admin = adminService.findByStuNum(stuNum);
        Class c=classRepository.findOne(classId);
        if (admin == null) {
            return false;
        } else if (admin.getIdentity() == 0 && c.getAdminId().equals(stuNum)) {
            return true;
        } else {
            return classId == admin.getClassId();
        }
    }


    public void addStu(int classId, int stuNumber) {
        Student student = studentRository.findByStuNumber(stuNumber);
        student.setClassId(classId);
        studentRository.save(student);
    }

    public void deStu(int classId, int stuNumber) {
        Student student = studentRository.findByClassIdAndStuNumber(classId,stuNumber);
        student.setClassId(-1);
        studentRository.save(student);
    }

    public int findStuNumByStuId(int stuId){
        Student student=studentRository.findByStuNumber(stuId);
        return classRepository.findOne(student.getClassId()).getStudenNumber();
    }

    public int getClassId(String className){
        return classRepository.findClassByClassNameLike("%"+className.trim()+"%").getId();
    }
}
