package sample;

import javafx.beans.property.SimpleStringProperty;

public class Lecturer {
    private SimpleStringProperty lecturerCode, lecturerName, unitCode;

    public Lecturer(String lecturerCode, String lecturerName, String unitCode) {
        this.lecturerCode = new SimpleStringProperty(lecturerCode);
        this.lecturerName = new SimpleStringProperty(lecturerName);
        this.unitCode = new SimpleStringProperty(unitCode);
    }

    public String getLecturerCode() {
        return lecturerCode.get();
    }

//    public SimpleStringProperty lecturerCodeProperty() {
//        return lecturerCode;
//    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode.set(lecturerCode);
    }

    public String getLecturerName() {
        return lecturerName.get();
    }

//    public SimpleStringProperty lecturerNameProperty() {
//        return lecturerName;
//    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName.set(lecturerName);
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
}
