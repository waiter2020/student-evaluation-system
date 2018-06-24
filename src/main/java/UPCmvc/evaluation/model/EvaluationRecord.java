package UPCmvc.evaluation.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wanghaojun on 2017/4/28.
 */
@Entity
@Table(name = "eva_record")
public class EvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String evaluatorNum;
    private int beEvaluatedNum;

    private Date evaluationDate;
    private char grade;

    public EvaluationRecord() {
    }

    public EvaluationRecord(String evaluatorNum, int beEvaluatedNum, Date evaluationDate, char
            grade) {
        this.evaluatorNum = evaluatorNum;
        this.beEvaluatedNum = beEvaluatedNum;
        this.evaluationDate = evaluationDate;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluatorNum() {
        return evaluatorNum;
    }

    public void setEvaluatorNum(String evaluatorNum) {
        this.evaluatorNum = evaluatorNum;
    }

    public int getBeEvaluatedNum() {
        return beEvaluatedNum;
    }

    public void setBeEvaluatedNum(int beEvaluatedNum) {
        this.beEvaluatedNum = beEvaluatedNum;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
