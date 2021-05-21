package com.dbmsproject;

import com.dbmsproject.connection.ManageConnection;
import com.dbmsproject.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class Main extends Application {
	private ManageConnection manageConnection;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("fxml/on_boarding_screen.fxml"));
		primaryStage.setTitle("Household Grocery Manager");
		primaryStage.setScene(new Scene(root, 1200, 800));
		primaryStage.setResizable(false);
		primaryStage.show();

		manageConnection = ManageConnection.createInstance();

		if (doesCredentialsExist()) {
			Parent login_root = FXMLLoader.load(getClass().getResource("fxml/login_screen.fxml"));
			primaryStage.setTitle("Household Grocery Manager");
			primaryStage.setScene(new Scene(login_root, 1200, 800));
			primaryStage.setResizable(false);
			primaryStage.show();


		} else {
			Parent crt_acnt_root = FXMLLoader.load(getClass().getResource("fxml/create_account.fxml"));
			primaryStage.setTitle("Household Grocery Manager");
			primaryStage.setScene(new Scene(crt_acnt_root, 1200, 800));
			primaryStage.setResizable(false);
			primaryStage.show();
		}
	}

	public boolean doesCredentialsExist() {
		String query = "SELECT * FROM admin";
		ResultSet resultSet = manageConnection.executeQueryForResult(query);

		boolean value = false;
		try {
			value = resultSet.isBeforeFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}



	public static void main(String[] args) {
		launch(args);
	}
}
