package sample;

import javafx.beans.property.SimpleStringProperty;

public class Unit {
    private SimpleStringProperty unitCode, unitName, lecturerCode, year;

    public Unit(String unitCode, String unitName, String year, String lecturerCode) {
        this.unitCode = new SimpleStringProperty(unitCode);
        this.unitName = new SimpleStringProperty(unitName);
        this.lecturerCode = new SimpleStringProperty(lecturerCode);
        this.year = new SimpleStringProperty(year);
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

    public String getUnitName() {
        return unitName.get();
    }

//    public SimpleStringProperty unitNameProperty() {
//        return unitName;
//    }

    public void setUnitName(String unitName) {
        this.unitName.set(unitName);
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

    public String getYear() {
        return year.get();
    }

//    public SimpleStringProperty yearProperty() {
//        return year;
//    }

    public void setYear(String year) {
        this.year.set(year);
    }
}
