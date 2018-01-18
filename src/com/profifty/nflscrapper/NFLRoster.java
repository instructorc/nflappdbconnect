package com.profifty.nflscrapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class NFLRoster extends Application {
	
	public  void start(Stage stage) throws Exception{
		Parent parent = FXMLLoader.load(getClass().getResource("NFLRosterDisplay.fxml"));
		
		//Build the scene graph.
		Scene scene = new Scene(parent);
		
		//Display our window, using the scene graph.
		stage.setTitle("NFL Roster Look-up");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args){
		
		
		//Launch the application
		launch(args);
	}
	

}
