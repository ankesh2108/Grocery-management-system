package com.dbmsproject.controller;

import com.dbmsproject.connection.ManageConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccount implements Initializable {
	@FXML
	private Label label_show_error;
	@FXML
	private TextField tf_username_ca;
	@FXML
	private TextField tf_mobile_no_ca;
	@FXML
	private TextField tf_password_ca;
	@FXML
	private TextField tf_confirm_password_ca;

	private ManageConnection manageConnection;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		label_show_error.setText("");
		manageConnection = ManageConnection.createInstance();
	}

	public void createAccountBtn(ActionEvent actionEvent) throws IOException {

		String password = tf_password_ca.getText().trim();
		String confirmPassword = tf_confirm_password_ca.getText().trim();

		if(areFieldsEmpty()) {
			label_show_error.setText("Text fields cannot be empty");
		}
		else {
			if(password.equals(confirmPassword)) {
				String query = "INSERT INTO admin(admin_username, mobile_no, a_password, confirm_password) VALUES('"+tf_username_ca.getText().trim()+"','"
						+tf_mobile_no_ca.getText().trim()+"','"
						+tf_password_ca.getText().trim()+"','"
						+tf_confirm_password_ca.getText().trim()+"')";
				manageConnection.executeUpdateQuery(query);

				Parent main_window = FXMLLoader.load(getClass().getClassLoader().getResource("com/dbmsproject/fxml/login_screen.fxml"));
				Scene main_window_scene = new Scene(main_window,1200,800);
				Stage app_stage =  (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
				app_stage.setScene(main_window_scene);
				app_stage.setResizable(false);
				app_stage.show();
			}
			else {
				label_show_error.setText("Passwords doesn't match");
				tf_confirm_password_ca.setText("");
				tf_password_ca.setText("");
			}
		}



	}

	private boolean areFieldsEmpty() {

		if (tf_username_ca.getText().trim().isEmpty() || tf_mobile_no_ca.getText().trim().isEmpty() || tf_password_ca.getText().trim().isEmpty() || tf_confirm_password_ca.getText().trim().isEmpty())
			return true;
		else
			return false;
	}
}
