package UPCmvc.evaluations.repository;

import UPCmvc.evaluations.model.EvaGrade;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by waiter on 18-4-17.
 */
public interface EvaGradeRepository extends CrudRepository<EvaGrade,Integer>{
    EvaGrade findEvaGradeByStuNum(String stuNum);
}
