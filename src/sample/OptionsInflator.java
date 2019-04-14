package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OptionsInflator {
    private ObservableList<String> yearData = FXCollections.observableArrayList("Year_1", "Year_2", "Year_3", "Year_4");
    private ObservableList<String> unitCombo = FXCollections.observableArrayList();
    private ObservableList<String> enrollmentCombo = FXCollections.observableArrayList();
    private ObservableList<Unit> unitsData = FXCollections.observableArrayList();
    private JFXComboBox comboBox1;
    private JFXComboBox comboBox2;
    private JFXComboBox comboBox3;

    OptionsInflator(JFXComboBox comboBox1, JFXComboBox comboBox2) {
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;

        setComboBox1(this.comboBox1);

        comboBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clearComboBox2();
            try {
                Connection con = DBConnector.getConnection();
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM results.units WHERE Year = '"+newValue+"'");

                while (rs.next()) {
                    this.unitsData.add(new Unit(rs.getString("Unit_code"), rs.getString("Unit_name"), rs.getString("Year"), rs.getString("Lecturer_ID")));
                    this.unitCombo.add(rs.getString("Unit_code"));
                }
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        setComboBox2(this.comboBox2);
    }

    OptionsInflator(JFXComboBox comboBox1, JFXComboBox comboBox2, JFXComboBox comboBox3) {
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
        this.comboBox3 = comboBox3;

        setComboBox1(this.comboBox1);

        comboBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clearComboBox2();
            try {
                Connection con = DBConnector.getConnection();
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM results.units WHERE Year = '"+newValue+"'");

                while (rs.next()) {
                    this.unitsData.add(new Unit(rs.getString("Unit_code"), rs.getString("Unit_name"), rs.getString("Year"), rs.getString("Lecturer_ID")));
                    this.unitCombo.add(rs.getString("Unit_code"));
                }
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        setComboBox2(this.comboBox2);

        comboBox2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clearComboBox3();
            try {
                Connection con = DBConnector.getConnection();
                ResultSet rs = con.createStatement().executeQuery("SELECT Admission_number FROM results.unit_enrollment WHERE Unit_code = '"+newValue+"'");

                while (rs.next()) {
                    this.enrollmentCombo.add(rs.getString("Admission_number"));
                }
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        setComboBox3(this.comboBox3);

    }

    public JFXComboBox getComboBox1() {
        return comboBox1;
    }

    protected void setComboBox1(JFXComboBox comboBox1) {
        comboBox1.setItems(yearData);
    }

    public JFXComboBox getComboBox2() {
        return comboBox2;
    }

    protected void setComboBox2(JFXComboBox comboBox2) {
        comboBox2.setItems(unitCombo);
    }

    public JFXComboBox getComboBox3() {
        return comboBox3;
    }

    protected void setComboBox3(JFXComboBox comboBox3) {
        comboBox3.setItems(enrollmentCombo);
    }

    protected void clearComboBox1() {
        comboBox1.getSelectionModel().clearSelection();
        comboBox1.setValue(null);
        yearData.clear();
    }

    protected void clearComboBox2() {
        comboBox2.getSelectionModel().clearSelection();
        comboBox2.setValue(null);
        unitCombo.clear();
    }

    protected void clearComboBox3 () {
        comboBox3.getSelectionModel().clearSelection();
        comboBox3.setValue(null);
        enrollmentCombo.clear();
    }
}
