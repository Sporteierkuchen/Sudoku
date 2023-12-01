package Sudoku.controller;



import java.awt.Toolkit;
import java.util.ArrayList;

import Sudoku.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LösungController {

	private MainApp mainApp;

	private int GRID_SIZE;

	private boolean angehalten = false;
	
	@FXML
	private VBox lösungVBox;
	
	@FXML
	private ScrollPane mainScrollPane;

	@FXML
	private VBox bottomVBox;

	@FXML
	private HBox schließenHBox;

	@FXML
	private HBox buttonHBox;

	@FXML
	private HBox meldungsHBox;

	@FXML
	private Text meldungstext;

	int[][] boardBefore; // Create an ArrayList object
	
	int[][] boardToSolve; // Create an ArrayList object

	private VBox hauptVBox = new VBox();

	private int nodecounter = 0;

	ArrayList<GridPane> grids = new ArrayList<>();
	private int counter = 0;
	  
	private int abbruchanzahl = 500;

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
	 * 
	 * @param board
	 * @param boardToSolve
	 */
	public void startwerteSetzen(int[][] board, int[][] boardToSolve) {

		AnchorPane.setLeftAnchor(lösungVBox, 0.0);
		AnchorPane.setRightAnchor(lösungVBox, 0.0);
		AnchorPane.setTopAnchor(lösungVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.125);
		AnchorPane.setBottomAnchor(lösungVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		this.mainScrollPane.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.mainScrollPane.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.683);

		this.schließenHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.07);
		
		this.meldungsHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.meldungsHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.065);


		this.boardBefore=board;
		this.boardToSolve = boardToSolve;

		this.hauptVBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.hauptVBox.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.hauptVBox.setAlignment(Pos.CENTER);


		this.hauptVBox.setStyle("-fx-background-color: #cff4c9 ;");


		solveBoard2(this.boardToSolve);

		HBox zweiHBox = new HBox();
		zweiHBox.setAlignment(Pos.CENTER);
		// zweiHBox.setStyle("-fx-background-color: pink ;");

		for (GridPane grid : this.grids) {

			zweiHBox.getChildren().add(grid);

		}

		this.hauptVBox.getChildren().add(zweiHBox);
		this.mainScrollPane.setContent(this.hauptVBox);

		if (counter > 1) {

			if (this.angehalten) {
				this.meldungstext.setText(
						"Hier gibt es sehr viele Lösungen...Es werden davon " + this.abbruchanzahl
								+ " Lösungen angezeigt!");
			} else {
				this.meldungstext.setText("Es wurden " + this.counter + " Lösungen gefunden!");
			}

		} else {
			this.meldungstext.setText("Es wurde genau eine Lösung gefunden!");

		}

	}

	@FXML
	private void handleCloseButton() {

		this.mainApp.getPrimaryStage().close();

	}

	@FXML
	private void handleNeuButton() {

		this.mainApp.initStartLayout(this.boardBefore);

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
	
			private boolean solveBoard2(int[][] boardsolve) {
		  
		    for (int row = 0; row < GRID_SIZE; row++) {
		      for (int column = 0; column < GRID_SIZE; column++) {
		       
		    	  
					if (boardsolve[row][column] == 0) {
		        	
		          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
		        	  
							if (isValidPlacement(boardsolve, numberToTry, row, column)) {
								boardsolve[row][column] = numberToTry;
		              
								if (solveBoard2(boardsolve)) {

									if (this.counter < this.abbruchanzahl) {
										this.addBord(boardsolve);
									this.counter++;

									} else {
										this.angehalten = true;
										return true;
									}

		              //  return true;
		              }
						boardsolve[row][column] = 0;
		              
		            }
		          }
		          
		          return false;
		          
		        }
		    	  
		      }
		    }
		    
		    return true;
		  }
	
			private void addBord(int[][] solvedBoard) {

				GridPane g = null;

				switch (this.GRID_SIZE) {
				case 4:

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane2x2.fxml"));
					try {
						g = (GridPane) loader.load();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						MainApp.fehlerBeimLadenVonFxmlDateiAnzeigen("GridPane2x2: " + e.getMessage());
						e.printStackTrace();
					}

					break;
				case 9:

					FXMLLoader loader2 = new FXMLLoader();
					loader2.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane3x3.fxml"));
					try {
						g = (GridPane) loader2.load();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						MainApp.fehlerBeimLadenVonFxmlDateiAnzeigen("GridPane: " + e.getMessage());
						e.printStackTrace();
					}

					break;
				case 16:

					FXMLLoader loader3 = new FXMLLoader();
					loader3.setLocation(MainApp.class.getResource("../fxml Dateien/GridPane4x4.fxml"));
					try {
						g = (GridPane) loader3.load();
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

				g.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
				g.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
				g.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
				g.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.6);
				g.setAlignment(Pos.CENTER);
				HBox.setMargin(g, new Insets(20, Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.03, 20,
						Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.03));

				for (int row = 1; row < this.GRID_SIZE + 1; row++) {

					for (int column = 0; column < this.GRID_SIZE; column++) {

						Label l = new Label();

						if (this.boardBefore[row - 1][column] != 0) {

							l.setAlignment(Pos.CENTER);
							l.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
							l.setTextFill(Color.RED);
							l.setText(String.valueOf(boardBefore[row - 1][column]));

						} else {

							l.setAlignment(Pos.CENTER);
							l.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
							l.setTextFill(Color.BLACK);
							l.setText(String.valueOf(solvedBoard[row - 1][column]));

						}

						switch (this.GRID_SIZE) {
						case 4:
							l.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.14,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.14);
							l.setFont(Font.font("System", FontWeight.BOLD,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.06));
							break;
						case 9:
							l.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.066,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.066);
							l.setFont(Font.font("System", FontWeight.BOLD,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
							break;
						case 16:

							l.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.036,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.036);
							l.setFont(Font.font("System", FontWeight.BOLD,
									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.013));

							break;
						default:
							System.out.println("Fehler!");
							break;
						}


						HBox h = new HBox();
						h.setAlignment(Pos.CENTER);
						h.getChildren().add(l);


						switch (this.GRID_SIZE) {
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

						g.add(h, column, row);

					}

				}

				if (this.nodecounter < 1) {

					this.grids.add(g);
					this.nodecounter++;
				} else {

					this.grids.add(g);

					HBox zweiHBox = new HBox();
					zweiHBox.setAlignment(Pos.CENTER);
					// zweiHBox.setStyle("-fx-background-color: pink ;");

					for (GridPane grid : this.grids) {

						zweiHBox.getChildren().add(grid);

					}

					this.hauptVBox.getChildren().add(zweiHBox);
					this.grids.clear();
					this.nodecounter = 0;

				}


			}
	
}
