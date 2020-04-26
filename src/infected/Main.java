package infected;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent; 
import javafx.application.Application;
import javafx.collections.FXCollections;
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
	// Initialize objects / variables 
    Stage window;
    TextField nameInput;
    Label countryLabel, symptomLabel, countryInfo, virusName;
    ComboBox<Symptom> symptomBox;
    ComboBox<Country>countryBox;
    ArrayList<Country> countries;
    ArrayList<Symptom> symptoms;
    Button startButton;
    
	@Override
	public void start(Stage primaryStage) {
		try {
	        window = primaryStage;
	        // set title
	        window.setTitle("Virus Infection Game");
			TilePane root = new TilePane();
			// load the arraylists for the symptom and country objects
			countries = readCountries();
			symptoms = readSymptoms();
			// start button
			startButton = new Button("Start Game");
			// create action for start button
			startButton.setOnAction(e -> {
				// load the second stage
				Virus virus = new Virus(nameInput.getText(), symptomBox.getValue());
				countryBox.getValue().addSick(1);
				CountryView view = new CountryView(new World(countries, virus));
				window.setHeight(820);
				window.setWidth(850);
			    primaryStage.getScene().setRoot(view.getRootPane());
			});
			
			virusName = new Label("Enter virus name");
			// name input
			nameInput = new TextField();
			nameInput.setPromptText("Name");
			
			// symptoms combo box
			symptomLabel = new Label("Choose the starting symptom");
			symptomBox = new ComboBox<Symptom>(FXCollections.observableArrayList(symptoms));
			symptomBox.setValue(symptoms.get(0));
			
			countryLabel = new Label("Choose the starting country");
			countryBox = new ComboBox<Country>(FXCollections.observableArrayList(countries));
			// when the user changes the combo box, it will update the info on the country
			countryBox.setOnAction(updateInfo);
			countryInfo = new Label("Country info:");
			// update the comboboxes to the first element in the arraylist in order to show the country info label
			countryBox.setValue(countries.get(0));
			
			// create a vbox to align all the items vertically
			VBox vBox = new VBox(virusName, nameInput, symptomLabel, symptomBox, countryLabel, countryBox, countryInfo, startButton);
			vBox.setAlignment(Pos.CENTER);
			VBox.setMargin(nameInput, new Insets(10, 30, 10, 30));
			Scene scene = new Scene(vBox,300,400);
			// load the styling sheet
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setScene(scene);
			window.show();
			
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
		// create arraylist object, which will be returned later
		ArrayList<Country> countries = new ArrayList<Country>();
		ArrayList<String> names = readNames("countries.txt");
		/*
		 * this loop will loop through the names arraylist and will strip the string s by separating the commas 
		 * and then create a country object
		 */
		for (String s : names)
		{
			String name = s.substring(0, s.indexOf(','));
			s = s.substring(s.indexOf(',') + 1, s.length());
			int population = Integer.parseInt(s.substring(0, s.indexOf(',')));
			s = s.substring(s.indexOf(',') + 1, s.length());
			Boolean hot = s.substring(0, s.indexOf(',')).equals("Hot");
			s = s.substring(s.indexOf(',') + 1, s.length());
			int wealth = Integer.parseInt(s);
			if (hot)
			{
				countries.add(new HotCountry(name, population, wealth));
			}
			else
			{
				countries.add(new ColdCountry(name, population, wealth));
			}
		}
		return countries;
	}
	
	private static ArrayList<Symptom> readSymptoms() 
	{
		ArrayList<Symptom> symptoms = new ArrayList<Symptom>();
		ArrayList<String> names = readNames("symptoms.txt");
		/*
		 * this loop will loop through the names arraylist and will strip the string s by separating the commas
		 * and then create a symptom object
		 */
		for (String s : names)
		{
			String name = s.substring(0, s.indexOf(','));
			s = s.substring(s.indexOf(',') + 1, s.length());
			int infectivity = Integer.parseInt(s.substring(0, s.indexOf(',')));
			s = s.substring(s.indexOf(',') + 1, s.length());
			int lethality = Integer.parseInt(s);
			symptoms.add(new Symptom(name, infectivity, lethality));
		}
		return symptoms;
	}
}