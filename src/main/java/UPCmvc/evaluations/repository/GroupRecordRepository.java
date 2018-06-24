package UPCmvc.evaluations.repository;

import UPCmvc.evaluations.model.GroupRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by waiter on 18-4-17.
 */
public interface GroupRecordRepository extends CrudRepository<GroupRecord,Integer>{
    public Iterable<GroupRecord> findAllByEvaluatorIdOrderByGrade(String evaluator);
    public Iterable<GroupRecord> findAllByClassIdAndEvaluatorIdOrderByGrade(int classId,String evaluator);
    public List<GroupRecord> findAllByBeEvaluatedIdOrderByGrade(String stuNum);
    public void removeAllByEvaluatorIdAndClassId(String evaluator,int classId);
}
