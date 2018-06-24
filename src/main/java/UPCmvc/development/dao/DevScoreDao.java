package UPCmvc.development.dao;

import UPCmvc.development.model.DevScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chenzifeng on 2017/6/14.
 */
@Repository
public interface DevScoreDao extends CrudRepository<DevScore,Integer> {
    Iterable<DevScore> findByStudentid(int studentId);
}
