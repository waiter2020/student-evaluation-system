package UPCmvc.common.model;

import javax.persistence.*;

/**
 * Created by wanghaojun on 2017/6/14.
 */
@Entity
@Table(name = "com_grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int stuNum;
    private int classId;
    private String stuName;
    private double study;
    private double evaluate;


    private double stuEva;
    private double groupEva;
    private double documentary;
    private double basis;
    private double development;
    private double sum;


    public Grade() {
    }


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Grade(int stuNum, int classId, String stuName, double study, double evaluate, double
            stuEva, double groupEva, double documentary, double basis, double development, double
                         sum) {
        this.stuNum = stuNum;
        this.classId = classId;
        this.stuName = stuName;
        this.study = study;
        this.evaluate = evaluate;
        this.stuEva = stuEva;
        this.groupEva = groupEva;
        this.documentary = documentary;
        this.basis = basis;
        this.development = development;
        this.sum = sum;
    }

    public double getStuEva() {
        return stuEva;
    }

    public void setStuEva(double stuEva) {
        this.stuEva = stuEva;
    }

    public double getGroupEva() {
        return groupEva;
    }

    public void setGroupEva(double groupEva) {
        this.groupEva = groupEva;
    }

    public double getBasis() {
        return basis;
    }

    public void setBasis(double basis) {
        this.basis = basis;
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

    public double getStudy() {
        return study;
    }

    public void setStudy(double study) {
        this.study = study;
    }

    public double getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(double evaluate) {
        this.evaluate = evaluate;
    }

    public double getDocumentary() {
        return documentary;
    }

    public void setDocumentary(double documentary) {
        this.documentary = documentary;
    }

    public double getDevelopment() {
        return development;
    }

    public void setDevelopment(double development) {
        this.development = development;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
