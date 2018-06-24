package UPCmvc.common.repository;

import UPCmvc.common.model.Grade;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/6/14.
 */
public interface GradeRepository extends CrudRepository<Grade,Integer> {
    Grade findByStuNum(int stuId);
    Iterable<Grade> findByClassIdOrderByStuNum(int classId);
}
