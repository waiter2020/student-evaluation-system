package UPCmvc.documentary.dao;

import UPCmvc.documentary.model.Documentary;
import UPCmvc.documentary.model.DocumentaryGrade;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zfl on 2017/4/30.
 */
public interface DocumentaryGradeDao extends CrudRepository<DocumentaryGrade,Integer> {
    DocumentaryGrade findFirstByStudentNumber(int studentNumber);
}
