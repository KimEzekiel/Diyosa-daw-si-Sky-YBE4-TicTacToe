package gui;
import game.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

// import
public class Board extends JFrame{
	/*Constants*/
	public static int BUTTONS_COL = 3; //number of button columns
	public static int BUTTONS_ROW = 3; //nuumber of button rows
	public static String NAME = "TicTacToe";
	/*Attributes*/
	private TicTacToe tictactoe;
	private CheckerButton[][] buttons;
	private JLabel playerTurn;
	private Container container;
	private JLabel[] playerScoreBoards;
	private JLabel winnerLabel;
	/*Constructor*/
	public Board(TicTacToe tictactoe){
		super(Board.NAME);
		this.tictactoe = tictactoe;
		this.prepareGUI();
	}
	/*
	*GUI elements preparation
	*/
	private void prepareGUI(){
		int i;
		int j;

		this.setPreferredSize(new Dimension(600, 600));
		// this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		container = this.getContentPane();
		this.container.setBackground(Color.RED);
		// this.createPaddings();
		this.createBoard();
		this.createTurnLabel();
		this.createScorePanel();
		this.createWinnerLabel();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void createBoard(){
		JPanel board = new JPanel();
		// board.setSize(600,600);
		// board.setPreferredSize(new Dimension(400,400));
		board.setLayout(new GridLayout(3,3));
		/*initialize buttons*/
		buttons = new CheckerButton[Board.BUTTONS_ROW][Board.BUTTONS_COL];
		for(int i = 0; i < Board.BUTTONS_ROW; i++){
			for(int j = 0; j < Board.BUTTONS_COL; j ++){
				buttons[i][j] = new CheckerButton(i,j,this.tictactoe);
				board.add(buttons[i][j]);
		    	}
	    	}
		this.container.add(board, BorderLayout.CENTER);
	}
	private void createScorePanel(){
		int i;
		int j;
		JPanel[] paddings = new JPanel[2];
		for(i = 0; i < paddings.length; i++){
			paddings[i] = new JPanel();
			paddings[i].setOpaque(false);
			// paddings[i].setBackground(Color.RED);
		}
		paddings[0].setPreferredSize(new Dimension(100, 600));
		paddings[1].setPreferredSize(new Dimension(100, 600));
		//placing

		// JPanel southPanel = new JPanel(new GridLayout(2,2));
		this.playerScoreBoards = new JLabel[2];
		JLabel[] scoreBoardLabels = new JLabel[4];
		for(i = 0; i < scoreBoardLabels.length; i++){
			scoreBoardLabels[i] = new JLabel();
			scoreBoardLabels[i].setFont(scoreBoardLabels[i].getFont().deriveFont(20f));
			scoreBoardLabels[i].setHorizontalAlignment(JLabel.CENTER);
		}
		for (i = 1;i < scoreBoardLabels.length ;i += 2 ) {
			scoreBoardLabels[i].setFont(scoreBoardLabels[i].getFont().deriveFont(100f));
		}
		this.playerScoreBoards[0] = scoreBoardLabels[1];
		this.playerScoreBoards[1] = scoreBoardLabels[3];
		/**/
		scoreBoardLabels[0].setText("Player 1");
		scoreBoardLabels[1].setText("0");
		scoreBoardLabels[2].setText("Player 2");
		scoreBoardLabels[3].setText("0");

		for(i = 0; i < scoreBoardLabels.length-2; i++){
			// southPanel.add(scoreBoardLabels[i]);
			paddings[0].add(scoreBoardLabels[i]);
		}
		for(i = 2; i < scoreBoardLabels.length; i++){
			// southPanel.add(scoreBoardLabels[i]);
			paddings[1].add(scoreBoardLabels[i]);
		}

		// this.container.add(southPanel, BorderLayout.SOUTH);
		this.container.add(paddings[0], BorderLayout.WEST);
		this.container.add(paddings[1], BorderLayout.EAST);

	}
	private void createTurnLabel(){
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(600,100));
		northPanel.setLayout(new FlowLayout());
		// northPanel.setBackground(Color.RED);
		northPanel.setOpaque(false);
		playerTurn = new JLabel();
		playerTurn.setFont(playerTurn.getFont().deriveFont(30f));
		playerTurn.setVerticalAlignment(JLabel.CENTER);
		this.updatePlayerTurn();

		northPanel.add(playerTurn);
		container.add(northPanel, BorderLayout.NORTH);
	}
	private void createWinnerLabel(){
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(600,100));
		southPanel.setLayout(new FlowLayout());
		// southPanel.setBackground(Color.RED);
		southPanel.setOpaque(false);

		this.winnerLabel = new JLabel();
		this.winnerLabel.setFont(playerTurn.getFont().deriveFont(30f));
		southPanel.add(this.winnerLabel);
		this.container.add(southPanel, BorderLayout.SOUTH);
	}
	/*
	*	Board operations
	*/
	public void resetButtons(){
		/*resets the buttons */
		for(int i = 0; i < Board.BUTTONS_ROW; i++){
			for(int j = 0; j < Board.BUTTONS_COL; j++){
				this.buttons[i][j].setText(" ");
				this.buttons[i][j].setClickable(true);
			}
		}
	}
	public void updatePlayerTurn(){
		this.playerTurn.setText("Player " + (this.tictactoe.getCurrentPlayerNum() + 1) + " to move.");
	}
	public void closeGame(){
		this.dispose();
	}
	public void updateScore(int playerNum){
		/*updates the score of the playerNum in the JLabel*/
		this.playerScoreBoards[playerNum].setText("" + this.tictactoe.getPlayers()[playerNum].getScore());
	}
	public void updateWinner(int winnerNum){
		String winner;
		switch (winnerNum) {
			case 0:
				winner = "Player 1 wins !";
				break;
			case 1:
				winner = "Player 2 wins!";
				break;
			default:
				winner = "It's a tie!";
				break;
		}
		this.winnerLabel.setText(winner);
	}

}
