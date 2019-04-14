package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewStudentsController implements Initializable {
    @FXML private JFXComboBox unit;
    @FXML private JFXComboBox year;
    @FXML private TableView<Student> studentsTable;
    @FXML private TableColumn<Student, String> admCol;
    @FXML private TableColumn<Student, String> firstNameCol;
    @FXML private TableColumn<Student, String> secondNameCol;
    @FXML private TableColumn<Student, String> courseCol;

    private ObservableList<Student> studentsData = FXCollections.observableArrayList();
    OptionsInflator optionsInflator;
    private String unitCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        optionsInflator = new OptionsInflator(year, unit);
        unitCode = (String) optionsInflator.getComboBox2().getValue();


        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM results.student");

            while (rs.next()) {
                studentsData.add(new Student(rs.getString("Admission_number"), rs.getString("First_name"), rs.getString("Second_name"), rs.getString("Course")));
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        admCol.setCellValueFactory(new PropertyValueFactory<>("admissionNumber"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        courseCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));

        studentsTable.setItems(studentsData);
    }
}
