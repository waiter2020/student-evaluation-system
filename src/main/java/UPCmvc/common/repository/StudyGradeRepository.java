package UPCmvc.common.repository;

import UPCmvc.common.model.StudyGrade;
import org.springframework.data.repository.CrudRepository;

public interface StudyGradeRepository extends CrudRepository<StudyGrade,Integer> {
    StudyGrade findFirstByStuNum(int stuNum);
}
