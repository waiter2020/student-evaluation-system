package UPCmvc.common.model;

import javax.persistence.*;

/*
学生学习成绩，直接将数据导入数据库
 */
@Entity
@Table(name = "study_grade")
public class StudyGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int stuNum;
    private String stuName;
    private double grade;

    public StudyGrade() {
    }

    public StudyGrade(int stuNum, String stuName, double grade) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
