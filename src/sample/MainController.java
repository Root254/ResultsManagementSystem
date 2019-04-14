package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    public JFXButton marks;
    public JFXButton view;
    public BorderPane borderPane;

    public void awardMarks(ActionEvent actionEvent) {
        loadCenterLayout("award_marks");
        view.setStyle("-fx-background-color: transparent");
        styleActiveSidebarTab(actionEvent);
    }

    public void viewStudent(ActionEvent actionEvent) {
        loadCenterLayout("view_students");
        marks.setStyle("-fx-background-color: transparent");
        styleActiveSidebarTab(actionEvent);
    }

    private void loadCenterLayout(String fileName) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(root);
    }

    private void styleActiveSidebarTab(ActionEvent actionEvent) {
        JFXButton activeBtn = (JFXButton) actionEvent.getSource();
        activeBtn.setStyle("-fx-background-color: #03000a; -fx-background-radius: 20px;");
    }
}
