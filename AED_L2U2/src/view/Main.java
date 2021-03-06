package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Fornite;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	private static Fornite fortnite;
	
	
	
	public Fornite getFornite()
	{
		return fortnite;
	}
	
	public static String[] showWeaponsNames()
	{
		String[] names = fortnite.showWeaponsNames();
		return names;
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException, InterruptedException, ClassNotFoundException {
		
		fortnite = new Fornite(this);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Fornite Improvements");
		showMainView();
	    showChargingView();
		
	}
	
	
	public static void showMainView() throws IOException
	{
		
		FXMLLoader loader = new  FXMLLoader();
		loader.setLocation(Main.class.getResource("Main.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void showMainMenu() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainMenu.fxml"));
		AnchorPane menu = loader.load();
		mainLayout.setCenter(menu);
	}
	

	public static void showWaitingView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("WaitingView.fxml"));
		AnchorPane menu = loader.load();
		mainLayout.setCenter(menu);
		}
		
	public static void showHashTableView() throws IOException
	{
		

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("HashTableView.fxml"));
		AnchorPane menu = loader.load();
		mainLayout.setCenter(menu);
		fortnite.newGame();
	}
	
	
	public static void showWeaponsView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("WeaponsView.fxml"));
		AnchorPane weaponsView = loader.load();
		mainLayout.setCenter(weaponsView);
		fortnite.createWeaponStack();
	}
	
	public void showChargingView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("ChargingView2.fxml"));
		AnchorPane chargingView = loader.load();
		mainLayout.setCenter(chargingView);
	}
	
	public static String getNextWeapon(int q)
	{
		String urlImage = fortnite.getNextWeapon(q);
		return urlImage;
	}

	
	public static String catchWeapon()
	{
		String weaponCatched = fortnite.catchWeapon();
		return weaponCatched;
	}
	
	
	public static void saveHashTable() throws FileNotFoundException, IOException
	{
		fortnite.save();
	}
	
	
	public static ArrayList<String> getScores(int slot)
	{
		return fortnite.getScores(slot);
	}
	
	public static String[] useWeapon()
	{
		return fortnite.useWeapon();
	}
	
	public static void main(String[] args) {
		launch(args);
		Main m = new Main();
	}
}

