package UPCmvc.common.service;

import UPCmvc.common.model.Admin;
import UPCmvc.common.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

/**
 * Created by wanghaojun on 2017/4/7.
 */
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(int identity,int classid,String stuNum,String adminName){
        Admin admin=new Admin(identity,classid,stuNum,adminName);
        return adminRepository.save(admin);
    }

    public void deleteAdmin(String stuId){
        Admin admin=adminRepository.findFirstByStuNum(stuId);
        adminRepository.delete(admin.getId());
    }

    public Iterable<Admin> listAdmin(){
        return adminRepository.findAll();
    }

    public Admin findByAdminId(int id){
        return adminRepository.findOne(id);
    }

    public Iterable<Admin> listClassAdmin(int classId){return adminRepository.findAllByClassId(classId);}


    public Admin findByStuNum(String id){return adminRepository.findFirstByStuNum(id);}

}