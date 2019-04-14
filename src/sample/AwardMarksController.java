package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AwardMarksController implements Initializable {
    @FXML
    private Label feedback;
    @FXML
    private TableView<Results> resultsTable;
    @FXML
    private TableColumn<Results, String> admNumberCol;
    @FXML
    private TableColumn<Results, Integer> cat1Col;
    @FXML
    private TableColumn<Results, Integer> cat2Col;
    @FXML
    private TableColumn<Results, Integer> finalExamCol;
    @FXML
    private TableColumn<Results, Integer> totalMarksCol;
    @FXML
    private TableColumn<Results, String> gradeCol;
    @FXML
    private JFXTextField cat1_textFiled;
    @FXML
    private JFXTextField cat2_textFiled;
    @FXML
    private JFXTextField final_textFiled;
    @FXML
    private JFXComboBox yearComboBox;
    @FXML
    private JFXComboBox unitComboBox;
    @FXML
    private JFXComboBox admNumberComboBox;
    @FXML
    private JFXButton save;

    private ObservableList<Results> resultsData = FXCollections.observableArrayList();
    OptionsInflator optionsInflator;
    private String adm;
    private String unit;
    private Integer cat1 = 0;
    private Integer cat2 = 0;
    private Integer finalExam = 0;
    private Integer total = 0;
    private String grade = "";

    @FXML
    private void saveMarks(ActionEvent actionEvent) {

        try {
            adm = (String) optionsInflator.getComboBox3().getValue();
            unit = (String) optionsInflator.getComboBox2().getValue();
            cat1 = (Integer) Integer.valueOf(cat1_textFiled.getText());
            cat2 = (Integer) Integer.valueOf(cat2_textFiled.getText());
            finalExam = (Integer) Integer.valueOf(final_textFiled.getText());
            total = cat1 + cat2 + finalExam;
            grade = gradePolicy(total);
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }

        try {
            Connection con = DBConnector.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO results.results VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, adm);
            statement.setString(2, unit);
            statement.setInt(3, cat1);
            statement.setInt(4, cat2);
            statement.setInt(5, finalExam);
            statement.setInt(6, total);
            statement.setString(7, grade);

            int i = statement.executeUpdate();
            feedback.setText("Saved successfully");
            System.out.println(i + " records inserted");

            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM results.results WHERE Unit_code = '"+unit+"'");

            while (rs.next()) {
                resultsData.add(new Results(rs.getString("Admission_number"), rs.getString("Unit_code"), rs.getInt("Cat1"), rs.getInt("Cat2"), rs.getInt("Final_exam"), rs.getInt("Total_marks"), rs.getString("Grade")));
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        admNumberCol.setCellValueFactory(new PropertyValueFactory<>("admissionNumber"));
        cat1Col.setCellValueFactory(new PropertyValueFactory<>("cat1"));
        cat2Col.setCellValueFactory(new PropertyValueFactory<>("cat2"));
        finalExamCol.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        totalMarksCol.setCellValueFactory(new PropertyValueFactory<>("totalMarks"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

        resultsTable.setItems(resultsData);
        clearFields();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        optionsInflator = new OptionsInflator(yearComboBox, unitComboBox, admNumberComboBox);
    }

    private String gradePolicy(Integer total) {
        String grade;

        if (total >= 75) {
            grade = "A";
        } else if (total >= 60 && total < 75) {
            grade = "B";
        } else if (total >= 50 && total < 60) {
            grade = "C";
        } else if (total >= 40 && total < 50) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    private void clearFields() {
        cat1_textFiled.clear();
        cat2_textFiled.clear();
        final_textFiled.clear();
        optionsInflator.clearComboBox3();
        optionsInflator.clearComboBox2();
        optionsInflator.clearComboBox1();
    }
}