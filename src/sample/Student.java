package sample;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty admissionNumber, firstName, secondName, courseName;

    Student(String admissionNumber, String firstName, String secondName, String courseName) {
        this.admissionNumber = new SimpleStringProperty(admissionNumber);
        this.firstName = new SimpleStringProperty(firstName);
        this.secondName = new SimpleStringProperty(secondName);
        this.courseName = new SimpleStringProperty(courseName);
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

    public String getFirstName() {
        return firstName.get();
    }

//    public SimpleStringProperty firstNameProperty() {
//        return firstName;
//    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return secondName.get();
    }

//    public SimpleStringProperty lastNameProperty() {
//        return secondName;
//    }

    public void setLastName(String lastName) {
        this.secondName.set(lastName);
    }

    public String getCourseName() {
        return courseName.get();
    }

//    public SimpleStringProperty courseNameProperty() {
//        return courseName;
//    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }
}
