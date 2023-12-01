package Sudoku.controller;

import java.awt.Toolkit;

import Sudoku.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartController {

	private MainApp mainApp;

	private int GRID_SIZE = 0;


	
	@FXML
	private VBox startVBox;
	
	@FXML
	private HBox mainHBox;

	@FXML
	private VBox bottomVBox;

	private GridPane gridpane;

	@FXML
	private HBox schließenHBox;

	@FXML
	private HBox buttonHBox;

	@FXML
	private HBox meldungsHBox;

	@FXML
	private Text meldungstext;

	@FXML
	private ComboBox gridauswahl;
	
		private int counter=0;
	  
	@FXML
	private void initialize() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		this.GRID_SIZE = this.mainApp.getGRID_SIZE();
	}

	/**
	 * setzt alle Informationen die Angezeigt werden sollen (Raumbeschreibung,
	 * Infotext, Spieler-Lebenspunkte und Lebensanzeige, Bild der Mapp für die
	 * Räume, Bild des Raums
	 * @param board 
	 */
	public void startwerteSetzen(int[][] board) {

		AnchorPane.setLeftAnchor(startVBox, 0.0);
		AnchorPane.setRightAnchor(startVBox, 0.0);
		AnchorPane.setTopAnchor(startVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.15);
		AnchorPane.setBottomAnchor(startVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		int gridsize = this.mainApp.getGRID_SIZE();

		ObservableList<String> datenliste = FXCollections.observableArrayList("2x2", "3x3", "4x4");
		this.gridauswahl.setItems(datenliste);

		switch (gridsize) {
		case 4:
			this.gridauswahl.getSelectionModel().select(0);

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane2x2.fxml"));
			try {
				this.gridpane = (GridPane) loader.load();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				MainApp.fehlerBeimLadenVonFxmlDateiAnzeigen("GridPane2x2: " + e.getMessage());
				e.printStackTrace();
			}


			break;
		case 9:
			this.gridauswahl.getSelectionModel().select(1);

			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane3x3.fxml"));
			try {
				this.gridpane = (GridPane) loader2.load();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				MainApp.fehlerBeimLadenVonFxmlDateiAnzeigen("GridPane: " + e.getMessage());
				e.printStackTrace();
			}


			break;
		case 16:
			this.gridauswahl.getSelectionModel().select(2);

			FXMLLoader loader3 = new FXMLLoader();
			loader3.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane4x4.fxml"));
			try {
				this.gridpane = (GridPane) loader3.load();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				MainApp.fehlerBeimLadenVonFxmlDateiAnzeigen("GridPane: " + e.getMessage());
				e.printStackTrace();
			}


			break;
		default:
			System.out.println("Fehler!");
			break;
		}

		this.mainHBox.getChildren().add(this.gridpane);


		this.mainHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.mainHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.675);
		
		this.gridpane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.66);
		this.gridpane.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.66);
		this.gridpane.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.66);
		this.gridpane.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.66);
		
		this.schließenHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.08);
		
		this.meldungsHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.meldungsHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.06);

		for (int row = 1; row < gridsize + 1; row++) {

			for (int column = 0; column < gridsize; column++) {

				TextField t = new TextField();


				switch (gridsize) {
				case 4:
					t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.16,
							Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.16);
					t.setFont(Font.font("System", FontWeight.BOLD,
							Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.06));
					break;
				case 9:
				t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.066,
						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.066);
					t.setFont(Font.font("System", FontWeight.BOLD,
						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
					break;
				case 16:

					t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.036,
							Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.036);
					t.setFont(Font.font("System", FontWeight.BOLD,
							Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.013));

					break;
				default:
					System.out.println("Fehler!");
					break;
				}
				
				t.setAlignment(Pos.CENTER);
				t.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");

				if(board[row-1][column]!=0) {
					t.setText(String.valueOf(board[row-1][column]));	
				}
				
				t.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(final ObservableValue<? extends String> ov, final String oldValue,
							final String newValue) {

						if (t.getText().length() > 1 && (gridsize == 9 || gridsize == 4)) {
							String s = t.getText().substring(0, 1);
							t.setText(s);

						}
						if (t.getText().length() > 2 && gridsize == 16) {
							String s = t.getText().substring(0, 2);
							t.setText(s);

						}

						if (!t.getText().isEmpty()) {

							try {
								int zahl = Integer.parseInt(t.getText());
								if (zahl == 0) {
									t.setText("");
								}
								if (gridsize == 4 && zahl > 4) {
									t.setText("");
								}
								if (gridsize == 16 && zahl > 16) {
									String s = t.getText().substring(0, 1);
									t.setText(s);
								}

							} catch (Exception e) {

								t.setText("");
							}

						}

					}
				});

				HBox h = new HBox();
				h.setAlignment(Pos.CENTER);
				h.getChildren().add(t);

				switch (gridsize) {
				case 4:

					if (row == 2 && column == 1) {

						h.getStyleClass().add("hbox2");

					} else if (row == 2) {

						h.getStyleClass().add("hbox1");

					} else if (column == 1) {

						h.getStyleClass().add("hbox");

					}

					break;
				case 9:

					if ((row == 3 || row == 6) && (column == 2 || column == 5)) {

						h.getStyleClass().add("hbox2");

					} else if (row == 3 || row == 6) {

						h.getStyleClass().add("hbox1");

					} else if (column == 2 || column == 5) {

						h.getStyleClass().add("hbox");

					}

					break;
				case 16:

					if ((row == 4 || row == 8 || row == 12) && (column == 3 || column == 7 || column == 11)) {

						h.getStyleClass().add("hbox2");

					} else if (row == 4 || row == 8 || row == 12) {

						h.getStyleClass().add("hbox1");

					} else if (column == 3 || column == 7 || column == 11) {

						h.getStyleClass().add("hbox");

					}

					break;
				default:
					System.out.println("Fehler!");
					break;
				}


				this.gridpane.add(h, column, row);

			}

		}

	}


	@FXML
	private void handleComboBox() {

		int[][] board = this.loadBoard();
		switch (this.GRID_SIZE) {
		case 4:

			this.mainApp.setBoard2x2(board);
			break;
		case 9:
			this.mainApp.setBoard3x3(board);
			break;
		case 16:
			this.mainApp.setBoard4x4(board);
			break;
		default:
			System.out.println("Fehler!");
			break;
		}

		switch (this.gridauswahl.getSelectionModel().getSelectedIndex()) {
		case 0:

			this.mainApp.setGRID_SIZE(4);
			break;
		case 1:
			this.mainApp.setGRID_SIZE(9);
			break;
		case 2:
			this.mainApp.setGRID_SIZE(16);
			break;
		default:
			System.out.println("Fehler!");
			break;
		}

		this.mainApp.initStartLayout(this.mainApp.boardübergeben());

	}

	@FXML
	private void handleCloseButton() {

		this.mainApp.getPrimaryStage().close();

	}

	@FXML
	private void handleLeerenButton() {

		for (Node node : this.gridpane.getChildren()) {

			if (node instanceof HBox) {
				HBox h = (HBox) node;

				if (h.getChildren().get(0) instanceof TextField) {

					TextField t = (TextField) h.getChildren().get(0);
					t.setText("");

				}

			}

		}

	}
	
	@FXML
	private void handleLösenButton() {

		if (this.ckeckBoard()) {

			this.meldungstext.setText("true");

			int[][] board = this.loadBoard();
			int[][] boardToSolve = this.loadBoard();


			int[][] boardAfter = this.loadBoard();
			if (solveBoard(boardAfter)) {

				this.mainApp.initLösungsLayout(board, boardToSolve);
			} else {
				this.meldungstext.setText("Es wurden keine Lösungen gefunden!");
			}
			
			
		} else {

			this.meldungstext.setText("Ungültige Eingabe...Die eingegebenen Zahlen verstoßen gegen die Sudoku Regeln bzw. wurden zu wenige Zahlen eingegeben!");

		}

	}
	
	
	private int[][] loadBoard() {

		int[][] board = new int[this.GRID_SIZE][this.GRID_SIZE];

		for (int i = 0; i < this.gridpane.getChildren().size(); i++) {

			if (this.gridpane.getChildren().get(i) instanceof HBox) {
				HBox h = (HBox) this.gridpane.getChildren().get(i);

				if (h.getChildren().get(0) instanceof TextField) {

					TextField t = (TextField) h.getChildren().get(0);

					int zahl = 0;
					if (!t.getText().isEmpty()) {
						zahl = Integer.parseInt(t.getText());
					}

					int column = 0;
					int row = 0;

					if (i % this.GRID_SIZE == 0) {

						column = this.GRID_SIZE - 1;
						row = (i / this.GRID_SIZE) - 1;
					} else {
						column = (i % this.GRID_SIZE) - 1;
						row = i / this.GRID_SIZE;
					}

					// System.out.println("row: " + row + " column: " + column);
					board[row][column] = zahl;

				}

			}

		}

//		this.printBoard(board);

		return board;

	}

	private boolean ckeckBoard() {

		int[][] board = this.loadBoard();
		int counter=0;
		
		for (int row = 0; row < GRID_SIZE; row++) {

			for (int column = 0; column < GRID_SIZE; column++) {

				int zahl = board[row][column];
				
				if (zahl != 0) {
					counter++;
					board[row][column] = 0;
					if (!this.isValidPlacement(board, zahl, row, column)) {

						return false;
					}

				}

			}

		}
		switch (this.GRID_SIZE) {
		case 4:
		
			return true;
		case 9:

			return counter >= 17;
		case 16:

			return counter >= 40;
		default:
			System.out.println("Fehler!");
			break;
		}
		return false;

	}

	private boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int boxgröße = (int) Math.sqrt(this.mainApp.getGRID_SIZE());
		int localBoxRow = row - row % boxgröße;
		int localBoxColumn = column - column % boxgröße;

		for (int i = localBoxRow; i < localBoxRow + boxgröße; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + boxgröße; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column)
				&& !isNumberInBox(board, number, row, column);
	}

	  private boolean solveBoard(int[][] board) {
		    for (int row = 0; row < GRID_SIZE; row++) {
		      for (int column = 0; column < GRID_SIZE; column++) {
		        if (board[row][column] == 0) {
		        	
		        	
		          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
		        	  
		            if (isValidPlacement(board, numberToTry, row, column)) {
		              board[row][column] = numberToTry;
		              
		              if (solveBoard(board)) {
		            	  
		            	  
		                return true;
		              }
		              else {
		                board[row][column] = 0;
		              }
		            }
		            
		            
		          }
		          
		          
		          return false;
		          
		        }
		      }
		    }
		    return true;
		  }

}
