package UPCmvc.evaluation.repository;

import UPCmvc.evaluation.model.EvaluationRecord;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * Created by wanghaojun on 2017/4/30.
 */
public interface EvaRecordRepository extends CrudRepository<EvaluationRecord,Integer>{
    Iterable<EvaluationRecord> findByEvaluatorNum(String id);
    Iterable<EvaluationRecord> findByBeEvaluatedNum(int id);
    EvaluationRecord findFirstByEvaluatorNumAndBeEvaluatedNum(String evaluator,int beEvaluated);
    List<EvaluationRecord> findByBeEvaluatedNumOrderByGradeDesc(int id);
    Iterable<EvaluationRecord> findByBeEvaluatedNumOrderByGradeAsc(int id);

}
