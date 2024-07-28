package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class NewDeviceFormController {
    public JFXTextField txtNewName;
    public JFXTextField txtMacAddress;

    public void btnRegisterOnAction(ActionEvent event) {
    }

    public void btnCancelOnAction(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.close();
    }
}
