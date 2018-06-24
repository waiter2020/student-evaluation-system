package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/7.
 * 管理员类
 * ybid 管理员的易班id
 * identity 管理员的身份
 0 辅导员
 1 班主任
 2 班长(团支书)
 3 测评小组成员
 * classId 班级编号

 */
@Entity
@Table(name = "com_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int identity;//管理员的身份
    private int classId; //班级id
    private String stuNum; //学号
    private String adminName; //管理员名字

    public Admin() {
    }

    public Admin(int identity, int classId, String stuNum,String adminName) {

        this.identity = identity;
        this.classId = classId;
        this.stuNum = stuNum;
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}

