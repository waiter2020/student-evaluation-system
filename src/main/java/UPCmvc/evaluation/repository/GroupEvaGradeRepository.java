package UPCmvc.evaluation.repository;

import UPCmvc.evaluation.model.GroupEvaGrade;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/5/1.
 */
public interface GroupEvaGradeRepository extends CrudRepository<GroupEvaGrade,Integer>{
    public GroupEvaGrade findFirstByStudentId(int stuId);

}
