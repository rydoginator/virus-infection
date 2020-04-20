package infected;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent; 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    Stage window;
    TextField nameInput;
    Label countryLabel, symptomLabel, countryInfo, virusName;
    ComboBox symptomBox;
    ComboBox<Country>countryBox;
    ArrayList<Country> countries;
    Button startButton;
    
	@Override
	public void start(Stage primaryStage) {
		try {
	        window = primaryStage;
	        window.setTitle("Virus Infection Game");
			TilePane root = new TilePane();
			countries = readCountries();
			// Title
			startButton = new Button("Start Game");
			// create action for start button
			startButton.setOnAction(e -> {
				CountryView view = new CountryView(countries);
				window.setHeight(420);
				window.setWidth(850);
			    primaryStage.getScene().setRoot(view.getRootPane());
			});
			
			virusName = new Label("Enter virus name");
			// name input
			nameInput = new TextField();
			nameInput.setPromptText("Name");
			
			symptomLabel = new Label("Symptoms");
			symptomBox = new ComboBox();
			
			countryLabel = new Label("Choose the country");
			countryBox = new ComboBox<Country>(FXCollections.observableArrayList(countries));
			countryBox.setOnAction(updateInfo);
			countryInfo = new Label("Country info:");
			
			VBox vBox = new VBox(virusName, nameInput, symptomLabel, symptomBox, countryLabel, countryBox, countryInfo, startButton);
			vBox.setAlignment(Pos.CENTER);
			VBox.setMargin(nameInput, new Insets(10, 30, 10, 30));
			Scene scene = new Scene(vBox,300,400);
			// load the styling sheet
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setScene(scene);
			window.show();
			// update the combobox to the first element in the arraylist in order to show the country info label
			countryBox.setValue(countries.get(0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	EventHandler<ActionEvent> updateInfo = 
            new EventHandler<ActionEvent>() { 
      public void handle(ActionEvent e) 
      { 
    	  countryInfo.setText("Country info:\n" + countryBox.getValue().getInfo()); 
      } 
  }; 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*
	 * Helper method to read all strings from a text file and return the strings from the list as a arraylist
	 */
	private static ArrayList<String> readNames(String fname)
	{
		ArrayList<String> names = new ArrayList<String>();
        try (Scanner fileReader = new Scanner(new File(fname))){
            while (fileReader.hasNextLine()) // loop through the entire file
            {
                names.add(fileReader.nextLine());
            }
        }catch (FileNotFoundException e){
                e.printStackTrace();
        }
        return names;
	}
	
	/*
	 * Helper method to create country objects using readNames helper method
	 */
	private static ArrayList<Country> readCountries() 
	{
		ArrayList<Country> countries = new ArrayList<Country>();
		ArrayList<String> names = readNames("countries.txt");
		for (String s : names)
		{
			String name = s.substring(0, s.indexOf(','));
			s = s.substring(s.indexOf(',') + 1, s.length());
			int population = Integer.parseInt(s.substring(0, s.indexOf(',') - 1));
			s = s.substring(s.indexOf(',') + 1, s.length());
			Boolean hot = s.substring(0, s.indexOf(',')).equals("Hot");
			s = s.substring(s.indexOf(',') + 1, s.length());
			int wealth = Integer.parseInt(s);
			countries.add(new Country(name, population, hot, wealth));
		}
		return countries;
	}
}