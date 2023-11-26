package Sudoku.controller;



import java.awt.Toolkit;
import Sudoku.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LösungController {

	private MainApp mainApp;

	private final int GRID_SIZE = 9;
	private final int GRID_SIZE2 = 4;

	
	@FXML
	private VBox lösungVBox;
	
	@FXML
	private ScrollPane mainScrollPane;

	@FXML
	private VBox bottomVBox;

	@FXML
	private GridPane gridpane;

	@FXML
	private HBox schließenHBox;

	@FXML
	private HBox buttonHBox;

	@FXML
	private HBox meldungsHBox;

	@FXML
	private Text meldungstext;

	int[][] board; // Create an ArrayList object
	
		private int counter=0;
	  
	@FXML
	private void initialize() {

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

	/**
	 * setzt alle Informationen die Angezeigt werden sollen (Raumbeschreibung,
	 * Infotext, Spieler-Lebenspunkte und Lebensanzeige, Bild der Mapp für die
	 * Räume, Bild des Raums
	 * @param board 
	 */
	public void startwerteSetzen(int[][] board) {

		AnchorPane.setLeftAnchor(lösungVBox, 0.0);
		AnchorPane.setRightAnchor(lösungVBox, 0.0);
		AnchorPane.setTopAnchor(lösungVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.13);
		AnchorPane.setBottomAnchor(lösungVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		this.mainScrollPane.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.mainScrollPane.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.675);
//		
//		this.gridpane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.67);
//		this.gridpane.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.67);
//		
		this.schließenHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.08);
		
		this.meldungsHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.meldungsHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.06);

		this.board=board;
		
//		for (int row = 1; row < 10; row++) {
//
//			for (int column = 0; column < 9; column++) {
//
//				TextField t = new TextField();
//				t.setAlignment(Pos.CENTER);
//				t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.069,
//						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.069);
//				t.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
//				t.setFont(Font.font("System", FontWeight.BOLD,
//						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
//
//				t.textProperty().addListener(new ChangeListener<String>() {
//					@Override
//					public void changed(final ObservableValue<? extends String> ov, final String oldValue,
//							final String newValue) {
//
//						if (t.getText().length() > 1) {
//							String s = t.getText().substring(0, 1);
//							t.setText(s);
//
//						}
//
//						if (!t.getText().isEmpty()) {
//
//							try {
//								int zahl = Integer.parseInt(t.getText());
//								if (zahl == 0) {
//									t.setText("");
//								}
//
//							} catch (Exception e) {
//
//								t.setText("");
//							}
//
//						}
//
//					}
//				});
//
//				HBox h = new HBox();
//				h.setAlignment(Pos.CENTER);
//				h.getChildren().add(t);
//
//				if ((row == 3 || row == 6) && (column == 2 || column == 5)) {
//
//					h.getStyleClass().add("hbox2");
//
//				} else if (row == 3 || row == 6) {
//
//					h.getStyleClass().add("hbox1");
//
//				} else if (column == 2 || column == 5) {
//
//					h.getStyleClass().add("hbox");
//
//				} else {
//
//				}
//
//				this.gridpane.add(h, column, row);
//
//			}
//
//		}

	}

	@FXML
	private void handleCloseButton() {

		this.mainApp.getPrimaryStage().close();

	}

	@FXML
	private void handleNeuButton() {

		this.mainApp.initStartLayout(this.board);

	}
	

	
	




	  private void printBoard(int[][] board) {
		    for (int row = 0; row < GRID_SIZE; row++) {
		      if (row % 3 == 0 && row != 0) {
		        System.out.println("-----------");
		      }
		      for (int column = 0; column < GRID_SIZE; column++) {
		        if (column % 3 == 0 && column != 0) {
		          System.out.print("|");
		        }
		        System.out.print(board[row][column]);
		      }
		      System.out.println();
		    }
		  }
	
	private void printBoard2(int[][] board) {
		for (int row = 0; row < GRID_SIZE2; row++) {
			if (row % 2 == 0 && row != 0) {
				System.out.println("-----------");
			}
			for (int column = 0; column < GRID_SIZE2; column++) {
				if (column % 2 == 0 && column != 0) {
					System.out.print("|");
				}
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
		
		System.out.println();
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
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;

		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isNumberInRow2(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE2; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumberInColumn2(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE2; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isNumberInBox2(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 2;
		int localBoxColumn = column - column % 2;

		for (int i = localBoxRow; i < localBoxRow + 2; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 2; j++) {
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
	
	private boolean isValidPlacement2(int[][] board, int number, int row, int column) {
		return !isNumberInRow2(board, number, row) && !isNumberInColumn2(board, number, column)
				&& !isNumberInBox2(board, number, row, column);
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
	
	  private boolean solveBoard2(int[][] board) {
		  
		    for (int row = 0; row < GRID_SIZE; row++) {
		      for (int column = 0; column < GRID_SIZE; column++) {
		       
		    	  
		    	  if (board[row][column] == 0) {
		        	
		          for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
		        	  
		            if (isValidPlacement(board, numberToTry, row, column)) {
		              board[row][column] = numberToTry;
		              
		              if (solveBoard2(board)) {
		            	  
		            	  this.counter++;
		            	//this. boards.add(board);
		            	  this.printBoard(board);
		            	  System.out.println();
		            	//  this.printBoard2(board);
		              //  return true;
		              }
		              board[row][column] = 0;
		              
		            }
		          }
		          
		          return false;
		          
		        }
		    	  
		      }
		    }
		    
		    return true;
		  }
	
	
	
	
	
	
	
	
}
