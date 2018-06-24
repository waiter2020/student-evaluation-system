package UPCmvc.evaluation.model;

import com.sun.javafx.beans.IDProperty;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Created by wanghaojun on 2017/4/28.
 */
@Entity
@Table(name = "eva_student")
public class StudentEvaGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private int studentId;
    private int gradeANum = 0;
    private int gradeBNum = 0;
    private int gradeCNum = 0;
    private int gradeDNum = 0;
    private double avgGrade = 0;
    private int evaTimes = 0;


    public StudentEvaGrade() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public StudentEvaGrade(int studentId, int gradeANum, int gradeBNum, int gradeCNum, int gradeDNum, int avgGrade, int evaTimes) {
        this.studentId = studentId;
        this.gradeANum = gradeANum;
        this.gradeBNum = gradeBNum;
        this.gradeCNum = gradeCNum;
        this.gradeDNum = gradeDNum;
        this.avgGrade = avgGrade;
        this.evaTimes = evaTimes;
    }

    public StudentEvaGrade(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGradeANum() {
        return gradeANum;
    }

    public void setGradeANum(int gradeANum) {
        this.gradeANum = gradeANum;
    }

    public int getGradeBNum() {
        return gradeBNum;
    }

    public void setGradeBNum(int gradeBNum) {
        this.gradeBNum = gradeBNum;
    }

    public int getGradeCNum() {
        return gradeCNum;
    }

    public void setGradeCNum(int gradeCNum) {
        this.gradeCNum = gradeCNum;
    }

    public int getGradeDNum() {
        return gradeDNum;
    }

    public void setGradeDNum(int gradeDNum) {
        this.gradeDNum = gradeDNum;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setEvaGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getEvaTimes() {
        return evaTimes;
    }

    public void setEvaTimes(int evaTimes) {
        this.evaTimes = evaTimes;
    }

}
