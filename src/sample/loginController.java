package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    public JFXTextField staffField;
    public JFXPasswordField pwdField;
    public Label errMessage;
    private Stage window;

    public void handleStaffLogin(ActionEvent actionEvent) {
        try {
            String pwd = staffField.getText();
            String user = staffField.getText();

            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT  Lecturer_ID, Pwd FROM results.lecturer WHERE Lecturer_ID = '"+user+"'");
            rs.next();

            if (!pwd.equals(rs.getString("Pwd"))&& !user.equals(rs.getString("Lecturer_ID"))) {
                errMessage.setText("Username / Password is incorrect");
                pwdField.requestFocus();
                pwdField.setStyle("-jfx-focus-color: red;");
            }
            else {
                Parent staffLog = FXMLLoader.load(getClass().getResource("main.fxml"));
                window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

                window.setScene(new Scene(staffLog));
            }




        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
