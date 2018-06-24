package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/4/6.
 * 班级类
 * classname 班级名称
 * professionid 专业编号
 * studentNumber 学生数目
 */
@Entity
@Table(name = "com_class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String className;
    private int professionId;
    private int studenNumber;
    private String adminId;
    public Class() {
    }

    public Class(String className, int professionId) {
        this.className = className;
        this.professionId = professionId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public int getStudenNumber() {
        return studenNumber;
    }

    public void setStudenNumber(int studenNumber) {
        this.studenNumber = studenNumber;
    }

}
