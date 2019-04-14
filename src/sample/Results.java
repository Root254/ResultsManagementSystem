package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Results {
    private SimpleStringProperty admissionNumber, unitCode, grade;
    private SimpleIntegerProperty cat1, cat2, finalExam, totalMarks;

    Results(String admissionNumber, String unitCode, Integer cat1, Integer cat2, Integer finalExam, Integer totalMarks, String grade) {
        this.admissionNumber = new SimpleStringProperty(admissionNumber);
        this.unitCode = new SimpleStringProperty(unitCode);
        this.cat1 = new SimpleIntegerProperty(cat1);
        this.cat2 =  new SimpleIntegerProperty(cat2);
        this.finalExam =  new SimpleIntegerProperty(finalExam);
        this.totalMarks =  new SimpleIntegerProperty(totalMarks);
        this.grade = new SimpleStringProperty(grade);
    }

    public String getAdmissionNumber() {
        return admissionNumber.get();
    }

//    public SimpleStringProperty admissionNumberProperty() {
//        return admissionNumber;
//    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber.set(admissionNumber);
    }

    public String getUnitCode() {
        return unitCode.get();
    }

//    public SimpleStringProperty unitCodeProperty() {
//        return unitCode;
//    }

    public void setUnitCode(String unitCode) {
        this.unitCode.set(unitCode);
    }

    public int getCat1() {
        return cat1.get();
    }

//    public SimpleIntegerProperty cat1Property() {
//        return cat1;
//    }

    public void setCat1(int cat1) {
        this.cat1.set(cat1);
    }

    public int getCat2() {
        return cat2.get();
    }

//    public SimpleIntegerProperty cat2Property() {
//        return cat2;
//    }

    public void setCat2(int cat2) {
        this.cat2.set(cat2);
    }

    public int getFinalExam() {
        return finalExam.get();
    }

//    public SimpleIntegerProperty finalExamProperty() {
//        return finalExam;
//    }

    public void setFinalExam(int finalExam) {
        this.finalExam.set(finalExam);
    }

    public int getTotalMarks() {
        return totalMarks.get();
    }

//    public SimpleIntegerProperty totalMarksProperty() {
//        return totalMarks;
//    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks.set(totalMarks);
    }

    public String getGrade() {
        return grade.get();
    }

//    public SimpleStringProperty gradeProperty() {
//        return grade;
//    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }
}
