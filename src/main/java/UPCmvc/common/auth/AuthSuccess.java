package UPCmvc.common.auth;

import UPCmvc.common.dto.VerifyUserInfo;
import UPCmvc.common.dto.YibanBasicUserInfo;
import UPCmvc.common.model.Admin;
import UPCmvc.common.model.Class;
import UPCmvc.common.model.Profession;
import UPCmvc.common.model.Student;
import UPCmvc.common.repository.AdminRepository;
import UPCmvc.common.repository.ClassRepository;
import UPCmvc.common.repository.ProfessionRepository;
import UPCmvc.common.repository.StudentRository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by lylllcc on 2017/7/6.
 */
@Service
public class AuthSuccess {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRository studentRository;

    @Autowired
    private ProfessionRepository professionRepository;

    public UserInfor getUserInfor(){
        Admin admin =new Admin();
        UserInfor userInfor = new UserInfor();
        VerifyUserInfo verifyUserInfo = (VerifyUserInfo)httpSession.getAttribute("realuser");
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
        //判断学生身份
        if (!verifyUserInfo.info.yb_studentid.equals("")){
            Student student=new Student();
            admin = adminRepository.findFirstByStuNum(verifyUserInfo.info.yb_studentid);
            student = studentRository.findByStuNumber(Integer.valueOf(verifyUserInfo.info.yb_studentid));
            if (admin==null){
                userInfor.setIdentity(-1);
            }else {
                userInfor.setIdentity(admin.getIdentity());
            }

            userInfor.setProsessionId(student.getProfessionId());
            userInfor.setClassId(student.getClassId());
            userInfor.setYb_studentid(verifyUserInfo.info.yb_studentid);
        }
        //判断老师身份
        else if (!verifyUserInfo.info.yb_employid.equals("")){
            admin = adminRepository.findFirstByStuNum(String.valueOf(verifyUserInfo.info.yb_employid));
            userInfor.setClassId(admin.getClassId());
            userInfor.setIdentity(admin.getIdentity());
            userInfor.setProsessionId(0);
            userInfor.setYb_studentid(verifyUserInfo.info.yb_employid);
        }



        userInfor.setUserid(yibanBasicUserInfo.visit_user.userid);
        userInfor.setUsername(yibanBasicUserInfo.visit_user.username);
        userInfor.setUsernick(yibanBasicUserInfo.visit_user.usernick);
        userInfor.setUsersex(yibanBasicUserInfo.visit_user.usersex);
        userInfor.setYb_realname(verifyUserInfo.info.yb_realname);
        System.out.println("abc"+userInfor.getIdentity());

        return userInfor;
    }

    class UserInfor{
        private int userid;
        private String username;
        private String usernick;
        private char usersex;
        private String userhead;
        private String yb_realname;
        private String yb_studentid;
        private int identity;
        private int classId;
        private int prosessionId;

        public UserInfor() {
        }

        public void setProsessionId(int prosessionId) {
            this.prosessionId = prosessionId;
        }

        public int getProsessionId() {
            return prosessionId;
        }

        public int getIdentity() {
            return identity;
        }

        public void setIdentity(int identity) {
            this.identity = identity;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsernick() {
            return usernick;
        }

        public void setUsernick(String usernick) {
            this.usernick = usernick;
        }

        public char getUsersex() {
            return usersex;
        }

        public void setUsersex(char usersex) {
            this.usersex = usersex;
        }

        public String getUserhead() {
            return userhead;
        }

        public void setUserhead(String userhead) {
            this.userhead = userhead;
        }

        public String getYb_realname() {
            return yb_realname;
        }

        public void setYb_realname(String yb_realname) {
            this.yb_realname = yb_realname;
        }

        public String getYb_studentid() {
            return yb_studentid;
        }

        public void setYb_studentid(String yb_studentid) {
            this.yb_studentid = yb_studentid;
        }
    }



}
