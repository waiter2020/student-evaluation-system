package UPCmvc.development.dao;

import UPCmvc.development.model.DevReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * Created by chenzifeng on 2017/4/30.
 */
@Repository
public interface DevReportDao extends JpaRepository<DevReport,Integer> {
    Iterable<DevReport> findByStudentNo(Integer studentNo);
    Iterable<DevReport> findByDrIdAndStudentNoOrderByCreateAt(Integer drId,String studentNo);
    Iterable<DevReport> findByClassId(Integer classId);
}
