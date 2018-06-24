package UPCmvc.evaluations.repository;

import UPCmvc.evaluations.model.StudentRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by waiter on 18-4-16.
 */
public interface StudentRecordRepository extends CrudRepository<StudentRecord,Integer> {
    public Iterable<StudentRecord> findAllByEvaluatorIdOrderByGrade(String EvaluatorId);
    public List<StudentRecord> findAllByBeEvaluatedIdOrderByGrade(String stuNum);
    public void removeAllByEvaluatorId(String EvaluatorId);
}
