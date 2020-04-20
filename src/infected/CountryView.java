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
	        table = new TableView<Country>();
	        colName = new TableColumn<>("Country Name");
	        colName.setMinWidth(250);
	        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
	        
	        colHealth = new TableColumn<>("Healthy");
	        colHealth.setMinWidth(200);
	        colHealth.setCellValueFactory(new PropertyValueFactory<>("healthy"));
	        
	        colInfected = new TableColumn<>("Infected");
	        colInfected.setMinWidth(200);
	        colInfected.setCellValueFactory(new PropertyValueFactory<>("infected"));
	        
	        colDeceased = new TableColumn<>("Dead");
	        colDeceased.setMinWidth(200);
	        colDeceased.setCellValueFactory(new PropertyValueFactory<>("deceased"));
	        
	        table.getColumns().addAll(colName, colHealth, colInfected, colDeceased);
	        
	        for (Country c: countries)
	        {
	        	table.getItems().add(c);
	        }
	        rootPane = new BorderPane(table);
	    }

	    public Pane getRootPane() {
	        return rootPane;
	    }
}