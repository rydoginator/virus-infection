package infected;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CountryView {
		private ArrayList<Country> countries;
		private final BorderPane rootPane;
	    TableView<Country> table;
	    private TableColumn<Country, String> colName;
	    private TableColumn<Country, Integer> colHealth, colInfected, colDeceased;

	    
	    public CountryView(ArrayList<Country> countries) {
	    	this.countries = countries;
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
	        // update the rootpane for the stage
	        rootPane = new BorderPane(table);
	    }

	    public Pane getRootPane() {
	        return rootPane;
	    }
}