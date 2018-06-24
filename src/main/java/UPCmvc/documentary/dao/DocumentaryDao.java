package UPCmvc.documentary.dao;


import UPCmvc.documentary.model.Documentary;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zfl on 2017/4/30.
 */
public interface DocumentaryDao extends CrudRepository<Documentary,Integer> {
    Iterable<Documentary> findByStudentNumber(int studentNumber);
}
