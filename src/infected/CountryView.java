package infected;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class CountryView {
		private ArrayList<Country> countries;
		private World world;
		private final BorderPane rootPane;
	    TableView<Country> table;
	    private TableColumn<Country, String> colName;
	    private TableColumn<Country, Integer> colHealth, colInfected, colDeceased;
	    private Label dayLabel;
	    private boolean running;

	    
	    public CountryView(World world) {
	    	this.world = world;
	    	this.countries = world.getCountries();
	    	OnWorldListener mListener = new WorldUpdater();
	    	// create new table with values from the country objects
	        table = new TableView<Country>();
	        // name column
	        colName = new TableColumn<>("Country Name");
	        colName.setMinWidth(250);
	        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
	        
	        // healthy population column
	        colHealth = new TableColumn<>("Healthy");
	        colHealth.setMinWidth(200);
	        colHealth.setCellValueFactory(new PropertyValueFactory<>("healthy"));
	        
	        // infected population column
	        colInfected = new TableColumn<>("Infected");
	        colInfected.setMinWidth(200);
	        colInfected.setCellValueFactory(new PropertyValueFactory<>("infected"));
	        
	        // deceased population column
	        colDeceased = new TableColumn<>("Dead");
	        colDeceased.setMinWidth(200);
	        colDeceased.setCellValueFactory(new PropertyValueFactory<>("deceased"));
	        
	        // add all columns to the table
	        table.getColumns().addAll(colName, colHealth, colInfected, colDeceased);
	        
	        // add all the countries 
	        for (Country c: countries)
	        {
	        	table.getItems().add(c);
	        }
	      //Create a HBox for the table and set its position
	        HBox tableBox = new HBox(table);
	        tableBox.setAlignment(Pos.CENTER);
	                        
	        //Label to change the day
	        dayLabel = new Label("Day: " + world.getDay());
	        dayLabel.setPrefSize(70,70);
	                    
	        // Paste the table on the stage
	        rootPane = new BorderPane(tableBox);
	                        
	        //Create a button to update the info of each country by the # of days
	        Button nextDayButton = new Button("Next Day");
	        nextDayButton.setPrefSize(70, 70);
	                        
	        nextDayButton.setOnAction(e -> {
	                   
	        });
	                        
	        //Horizontal box to show the number of days and the button
	        HBox hbox = new HBox(dayLabel, nextDayButton);
	        hbox.setAlignment(Pos.CENTER);
	                        
	        //Place the HBox location at the bottom
	        rootPane.setBottom(hbox);
	        rootPane.setPrefSize(70, 70);
	    }

	    public Pane getRootPane() {
	        return rootPane;
	    }
}