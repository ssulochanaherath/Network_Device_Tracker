package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label txtDate;
    public Label txtTime;
    public Label txtNetworkAddress;
    public TableColumn colStatus;
    public TableView tblDevices;
    public TableColumn colMacAddress;
    public TableColumn colName;
    public TableColumn colIPAddress;
    public TableColumn colActiveHours;
    public TableColumn colAction;
    public Label txtOnlineCount;
    public TextField txtSearchDevice;
    public TextArea txtDeviceInformations;
    public TableView tableUnknownDevices;
    public TableColumn colUnknownMac;
    public TableColumn colUnknownIP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDate();
        setTime();
    }

    public void setDate() {
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    public void setTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txtTime.setText(LocalTime.now().format(formatter));
    }

    public void btnSearchDeviceOnAction(MouseEvent mouseEvent) {
    }

    public void btnLogOutOnAction(MouseEvent mouseEvent) throws Exception {
        Node source = (Node) mouseEvent.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Login Form");
        newStage.setScene(scene);
        newStage.show();

        oldStage.close();
    }

    public void btnAddNewDeviceOnAction(ActionEvent event) throws Exception{
        Node source = (Node) event.getSource();
        Stage oldStage = (Stage) source.getScene().getWindow();
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/add_device_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage newStage = new Stage();
        newStage.setTitle("Add New Device");
        newStage.setScene(scene);
        newStage.initModality(Modality.WINDOW_MODAL);
        newStage.initOwner(oldStage);
        BoxBlur blur = new BoxBlur(3, 0, 3);
        oldStage.getScene().getRoot().setEffect(blur);
        newStage.setOnHidden(e -> oldStage.getScene().getRoot().setEffect(null));
        newStage.show();
    }
}
