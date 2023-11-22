package Sudoku.controller;

import java.awt.Toolkit;

import Sudoku.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainAppController {

	private MainApp mainApp;

	

	@FXML
	private Text raumbeschreibung;

	@FXML
	private Text infos;
	
	@FXML
	private Label hpanzeige;
	
	@FXML
	private ProgressBar hpAnzeige;
	
	@FXML
	private Label schildanzeige;
	
	@FXML
	private ProgressBar schildAnzeige;
	
	@FXML
	private ProgressBar gegnerHpAnzeige;
	
	@FXML
	private ComboBox<String> itemsimraum;
	
	@FXML
	private Text inventarLeer;
	
	@FXML
	private ImageView mapImage;
	
	@FXML
	private ImageView roomImage;
	
	@FXML
	private ImageView gegnerGif;
	
	@FXML
	private ImageView truheImage;
	
	@FXML
	private ImageView hebelImage;
	
	@FXML
	private HBox buttonbereich;
	
	@FXML
	private MenuBar menubar;
	
	@FXML
	private AnchorPane steuerungsbereich;
	
	@FXML
	private Tab inventar;
	
	@FXML
	private HBox topHBox;

	@FXML
	private HBox mainHBox;

	@FXML
	private HBox bottomHBox;

	@FXML
	private GridPane gridpane;

	@FXML
	private void initialize() {




	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		

	}	
	
	
    /**
     * setzt alle Informationen die Angezeigt werden sollen (Raumbeschreibung, Infotext, Spieler-Lebenspunkte und Lebensanzeige, Bild der Mapp für die Räume, Bild des Raums
     */
	public void startwerteSetzen() {
		
		AnchorPane.setTopAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.03);
		AnchorPane.setBottomAnchor(topHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8);

		AnchorPane.setTopAnchor(mainHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.176);
		AnchorPane.setBottomAnchor(mainHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.175);

		AnchorPane.setTopAnchor(bottomHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8);
		AnchorPane.setBottomAnchor(bottomHBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		this.gridpane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
		this.gridpane.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);	
		
	
			for(int row=1; row<10; row++) {
				
				for(int column=0; column<9; column++) {
				
					TextField t= new TextField();
					t.setAlignment(Pos.CENTER);
					t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062,Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062 );
					t.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
					t.setFont(Font.font("System", FontWeight.BOLD,Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02) );
					
					t.textProperty().addListener(new ChangeListener<String>() {
				        @Override
				        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
				        	
				        	
				            if (t.getText().length() > 1) {
				                String s = t.getText().substring(0, 1);
				                t.setText(s);
				                
				            }
				     
				            if(!t.getText().isEmpty()) {
				     
				            	try {
				            	int zahl=Integer.parseInt(t.getText());
				            	if(zahl==0) {
				            		t.setText("");
				            	}
				            	
				            }
				            	catch(Exception e) {
				            	
				            	t.setText("");
				            }
				            	          
				            }
				  
				        }
				    });
					
					
					HBox h = new HBox();
					h.setAlignment(Pos.CENTER);
					h.getChildren().add(t);
					
				 if( (row==3 || row==6) && (column==2 || column==5))   {
						
						h.getStyleClass().add("hbox2");
					
					}
				 	else if(row==3 || row==6) {
						
						h.getStyleClass().add("hbox1");
		
					}
				 	else if (column==2 || column==5) {
						
						h.getStyleClass().add("hbox");

					}
					else {
						
						
					}
		
					this.gridpane.add(h, column, row);		
				
				}
				
		}
	
			
	}
	

	
	


}
