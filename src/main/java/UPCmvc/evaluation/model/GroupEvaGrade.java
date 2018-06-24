package UPCmvc.evaluation.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/5/1.
 */
@Entity
@Table(name = "eva_group")
public class GroupEvaGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int studentId;
    private int gradeANum = 0;
    private int gradeBNum = 0;
    private int gradeCNum = 0;
    private int gradeDNum = 0;
    private double avgGrade = 0;

    public GroupEvaGrade() {
    }

    public GroupEvaGrade(int studentId) {
        this.studentId = studentId;
    }

    public GroupEvaGrade(int studentId, int gradeANum, int gradeBNum, int gradeCNum, int
            gradeDNum, int avgGrade) {
        this.studentId = studentId;
        this.gradeANum = gradeANum;
        this.gradeBNum = gradeBNum;
        this.gradeCNum = gradeCNum;
        this.gradeDNum = gradeDNum;
        this.avgGrade = avgGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
