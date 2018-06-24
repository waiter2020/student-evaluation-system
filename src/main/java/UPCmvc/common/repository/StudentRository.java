package UPCmvc.common.repository;

import UPCmvc.common.model.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/4/6.
 */
public interface StudentRository extends CrudRepository<Student,Integer> {

    public Student findFirstByYibanId(int yibanId);
    public Iterable<Student> findAllByClassId(int classId);
    public Student findByStuNumber(int stuId);
    public Student findFirstByStuNumber(int stuId);
    public Iterable<Student> findByProfessionId(int professionId);
    public Student findByClassIdAndStuNumber(int classId,int stuNum);
}
