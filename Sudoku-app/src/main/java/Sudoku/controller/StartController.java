package Sudoku.controller;

import java.awt.Toolkit;
import java.util.ArrayList;

import Sudoku.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartController {

	private MainApp mainApp;

	private final int GRID_SIZE = 9;
	private final int GRID_SIZE2 = 4;

	
	@FXML
	private VBox startVBox;
	
	@FXML
	private HBox mainHBox;

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

	  ArrayList<int[][]> boards = new ArrayList<>(); // Create an ArrayList object
	
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

		AnchorPane.setLeftAnchor(startVBox, 0.0);
		AnchorPane.setRightAnchor(startVBox, 0.0);
		AnchorPane.setTopAnchor(startVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.13);
		AnchorPane.setBottomAnchor(startVBox, Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0);

		this.mainHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.mainHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.675);
		
		this.gridpane.setMaxHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.67);
		this.gridpane.setMaxWidth(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.67);
		
		this.schließenHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.buttonHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.08);
		
		this.meldungsHBox.setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.meldungsHBox.setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.06);

		for (int row = 1; row < 10; row++) {

			for (int column = 0; column < 9; column++) {

				TextField t = new TextField();
				t.setAlignment(Pos.CENTER);
				t.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.069,
						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.069);
				t.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
				t.setFont(Font.font("System", FontWeight.BOLD,
						Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
				
				if(board[row-1][column]!=0) {
					t.setText(String.valueOf(board[row-1][column]));	
				}
				
				t.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(final ObservableValue<? extends String> ov, final String oldValue,
							final String newValue) {

						if (t.getText().length() > 1) {
							String s = t.getText().substring(0, 1);
							t.setText(s);

						}

						if (!t.getText().isEmpty()) {

							try {
								int zahl = Integer.parseInt(t.getText());
								if (zahl == 0) {
									t.setText("");
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

				if ((row == 3 || row == 6) && (column == 2 || column == 5)) {

					h.getStyleClass().add("hbox2");

				} else if (row == 3 || row == 6) {

					h.getStyleClass().add("hbox1");

				} else if (column == 2 || column == 5) {

					h.getStyleClass().add("hbox");

				} else {

				}

				this.gridpane.add(h, column, row);

			}

		}

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


		
		
		
		
//		    int[][] board = {
//		            {0, 0, 0, 0},
//		            {0, 0, 0, 0},
//		            {0, 0, 0, 0},
//		            {0, 0, 0, 0}   
//		          };
//		
//		    this.solveBoard2(board);
		    int[][] board = this.loadBoard();
//		    System.out.println("Counter: "+this.counter);
		    	this.mainApp.initLösungsLayout(board);
		if (this.ckeckBoard()) {

			this.meldungstext.setText("true");

			
			
//			int[][] boardAfter = this.loadBoard();
			
			
		
			
			
//			 this.solveBoard2(boardAfter);
//			 System.out.println("Counter: "+this.counter);
//			 this.counter=0;
//			 
//		    if (solveBoard(boardAfter)) {
//		    	
//				for (int row = 1; row < 10; row++) {
//
//					for (int column = 0; column < 9; column++) {
//
//						Label l = new Label();
//						if(boardBefore[row-1][column]!=0) {
//											
//										l.setAlignment(Pos.CENTER);
//										l.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062,
//												Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062);
//										l.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
//										l.setTextFill(Color.RED);
//										l.setFont(Font.font("System", FontWeight.BOLD,
//												Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
//										
//									
//										l.setText(String.valueOf(boardBefore[row-1][column]));
//							
//						}
//						else {
//							
//							l.setAlignment(Pos.CENTER);
//							l.setMaxSize(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062,
//									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.062);
//							l.setStyle("		-fx-border-color: white ; -fx-border-width: 0 px ;   ");
//							l.setTextFill(Color.BLACK);
//							l.setFont(Font.font("System", FontWeight.BOLD,
//									Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.02));
//							
//							l.setText(String.valueOf(boardAfter[row-1][column]));
//							
//							
//							
//							
//						}
//			
//
//						
//						
//						HBox h = new HBox();
//						h.setAlignment(Pos.CENTER);
//						h.getChildren().add(l);
//
//						if ((row == 3 || row == 6) && (column == 2 || column == 5)) {
//
//							h.getStyleClass().add("hbox2");
//
//						} else if (row == 3 || row == 6) {
//
//							h.getStyleClass().add("hbox1");
//
//						} else if (column == 2 || column == 5) {
//
//							h.getStyleClass().add("hbox");
//
//						} else {
//
//						}
//
//						this.gridpane.add(h, column, row);
//
//					}
//
//				}
//		  
//		    		
//		    	
//		    		
//		    		
//		    		
//		    		
//		    		
//		    		
//		    	
//		    	
//		      }
//		      else {
//		    	  this.meldungstext.setText("Es wurden keine Lösungen gefunden!");
//		      }
			
			
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

					// System.out.println("row: "+row+" column: "+column);
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
		
		return counter>5;

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
