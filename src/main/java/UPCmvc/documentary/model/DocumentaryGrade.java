package UPCmvc.documentary.model;

import javax.persistence.*;

/**
 * Created by zfl on 2017/4/30.
 */
@Entity
@Table(name = "doc_grade")
public class DocumentaryGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private int studentNumber;
    private double grade;  //百分制 精确到小数点后两位

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocumentaryGrade(int studentNumber, double grade) {
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public DocumentaryGrade() {
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
