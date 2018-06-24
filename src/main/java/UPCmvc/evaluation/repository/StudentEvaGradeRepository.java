package UPCmvc.evaluation.repository;

import UPCmvc.evaluation.model.StudentEvaGrade;
import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jay on 4/30/2017.
 */

public interface StudentEvaGradeRepository extends CrudRepository<StudentEvaGrade, Integer> {
    public StudentEvaGrade findByStudentId(int studentId);

}