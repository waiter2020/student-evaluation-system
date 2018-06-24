package UPCmvc.evaluations.model;

import javax.persistence.*;

/**
 * Created by waiter on 18-4-17.
 */
@Entity
@Table(name = "e_grade")
public class EvaGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String stuNum;//学号S
    private String stuName;
    private double groupGrade;//测评小组得分
    private double studentGrade;//同学评分
    private int stuANum;
    private int stuBNum;
    private int stuCNum;
    private int stuDNum;
    private int groupANum;
    private int groupBNum;
    private int groupCNum;
    private int groupDNum;


    public EvaGrade(){}

    public EvaGrade(String stuNum,String stuName, double groupGrade, double studentGrade) {
        this.stuNum = stuNum;
        this.groupGrade = groupGrade;
        this.studentGrade = studentGrade;
        this.stuName=stuName;
    }

    public int getId() {
        return id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public double getGroupGrade() {
        return groupGrade;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setGroupGrade(double groupGrade) {
        this.groupGrade = groupGrade;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuANum() {
        return stuANum;
    }

    public int getStuBNum() {
        return stuBNum;
    }

    public int getStuCNum() {
        return stuCNum;
    }

    public int getStuDNum() {
        return stuDNum;
    }

    public int getGroupANum() {
        return groupANum;
    }

    public int getGroupBNum() {
        return groupBNum;
    }

    public int getGroupCNum() {
        return groupCNum;
    }

    public int getGroupDNum() {
        return groupDNum;
    }

    public void setStuANum(int stuANum) {
        this.stuANum = stuANum;
    }

    public void setStuBNum(int stuBNum) {
        this.stuBNum = stuBNum;
    }

    public void setStuCNum(int stuCNum) {
        this.stuCNum = stuCNum;
    }

    public void setStuDNum(int stuDNum) {
        this.stuDNum = stuDNum;
    }

    public void setGroupANum(int groupANum) {
        this.groupANum = groupANum;
    }

    public void setGroupBNum(int groupBNum) {
        this.groupBNum = groupBNum;
    }

    public void setGroupCNum(int groupCNum) {
        this.groupCNum = groupCNum;
    }

    public void setGroupDNum(int groupDNum) {
        this.groupDNum = groupDNum;
    }
}
