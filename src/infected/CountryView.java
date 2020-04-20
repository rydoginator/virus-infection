package infected;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CountryView {
	    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

	    public CountryView() {

	        rootPane = new BorderPane();
	        // build UI, register event handlers, etc etc
	    }

	    public Pane getRootPane() {
	        return rootPane ;
	    }
}