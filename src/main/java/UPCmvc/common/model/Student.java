package UPCmvc.common.model;



import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by wanghaojun on 2017/4/6.
 * 学生类
 * classId 班级编号 -1代表暂时没有
 * professionId 专业编号
 * stunumber 学号
 * grade 年级
 * yibanid 学生易班id
 * stuname 学生姓名
 * srusex 学生性别
 */
@Entity
@Table(name = "com_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int classId;
    private int professionId;
    private int stuNumber;
    private int grade;
    private int yibanId;

    private String stuName;
    private String stuSex;

    public Student(int classId, int professionId, int stuNumber, int grade, int yibanId, String stuName, String stuSex) {
        this.classId = classId;
        this.professionId = professionId;
        this.stuNumber = stuNumber;
        this.grade = grade;
        this.yibanId = yibanId;
        this.stuName = stuName;
        this.stuSex = stuSex;
    }

    public int getYibanId() {
        return yibanId;
    }

    public void setYibanId(int yibanId) {
        this.yibanId = yibanId;
    }

    public Student() {
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }
}
