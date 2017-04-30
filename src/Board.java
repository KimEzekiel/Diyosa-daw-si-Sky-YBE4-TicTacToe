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

class Board extends JFrame{
     static int BUTTONS_COL = 3; //number of button columns
     static int BUTTONS_ROW = 3; //nuumber of button rows

     private TicTacToe tictactoe;
     public Board(String name, TicTacToe tictactoe){
          super(name);
          this.tictactoe = tictactoe;
          this.initGUI();
     }

       private void initGUI(){
         this.setPreferredSize(new Dimension(500,300));
         this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

         Container container = this.getContentPane();

         JPanel board = new JPanel();
         board.setLayout(new GridLayout(3,3));
         JPanel northPanel = new JPanel();
         northPanel.setPreferredSize(new Dimension(500,50));
         northPanel.setLayout(new FlowLayout());
         northPanel.setBackground(Color.YELLOW);
         JPanel westPanel = new JPanel();
         westPanel.setPreferredSize(new Dimension(125,300));
         westPanel.setBackground(Color.YELLOW);
         JPanel eastPanel = new JPanel();
         eastPanel.setPreferredSize(new Dimension(175,300));
         eastPanel.setBackground(Color.YELLOW);
         JPanel southPanel = new JPanel();
         southPanel.setPreferredSize(new Dimension(500,50));
         southPanel.setBackground(Color.YELLOW);

         JLabel player1 = new JLabel();
         player1.setFont(player1.getFont().deriveFont(15f));
         player1.setText("Player 1: 0");
         player1.setPreferredSize(new Dimension(155,50));
         JLabel turn = new JLabel();
         turn.setFont(player1.getFont().deriveFont(15f));
         turn.setText("Player 1's turn");
         turn.setPreferredSize(new Dimension(155,50));
         JLabel player2 = new JLabel();
         player2.setText("Player 2: 0");
         player2.setFont(player2.getFont().deriveFont(15f));
         player2.setPreferredSize(new Dimension(150,50));
         CheckerButton[][] buttons = new CheckerButton[Board.BUTTONS_ROW][Board.BUTTONS_COL];
         for(int i = 0; i < Board.BUTTONS_ROW; i++){
              for(int j = 0; j < Board.BUTTONS_COL; j ++){
                    buttons[i][j] = new CheckerButton(i,j,this.tictactoe);
              }

         }
          /*
         JButton topLeft = new JButton();
         topLeft.setFont(topLeft.getFont().deriveFont(15f));
         JButton topMiddle = new JButton();
         topMiddle.setFont(topMiddle.getFont().deriveFont(15f));
         JButton topRight = new JButton();
         topRight.setFont(topRight.getFont().deriveFont(15f));
         JButton middleLeft = new JButton();
         middleLeft.setFont(middleLeft.getFont().deriveFont(15f));
         JButton center = new JButton();
         center.setFont(center.getFont().deriveFont(15f));
         JButton middleRight = new JButton();
         middleRight.setFont(middleRight.getFont().deriveFont(15f));
         JButton bottomLeft = new JButton();
         bottomLeft.setFont(bottomLeft.getFont().deriveFont(15f));
         JButton bottomMiddle = new JButton();
         bottomMiddle.setFont(bottomMiddle.getFont().deriveFont(15f));
         JButton bottomRight = new JButton();
         bottomRight.setFont(bottomRight.getFont().deriveFont(15f));
         */
         /*
         board.add(topLeft);
         board.add(topMiddle);
         board.add(topRight);
         board.add(middleLeft);
         board.add(center);
         board.add(middleRight);
         board.add(bottomLeft);
         board.add(bottomMiddle);
         board.add(bottomRight);
         */
         for(int i = 0; i < Board.BUTTONS_ROW; i++){
              for(int j = 0; j < Board.BUTTONS_COL; j ++){
                    board.add(buttons[i][j]);
              }
         }
         northPanel.add(player1);
         northPanel.add(turn);
         northPanel.add(player2);

         container.add(northPanel, BorderLayout.NORTH);
         container.add(westPanel, BorderLayout.WEST);
         container.add(board, BorderLayout.CENTER);
         container.add(eastPanel, BorderLayout.EAST);
         container.add(southPanel, BorderLayout.SOUTH);
         /*
         topLeft.addMouseListener(new BoardMouseListener(topLeft));
         topMiddle.addMouseListener(new BoardMouseListener(topMiddle));
         topRight.addMouseListener(new BoardMouseListener(topRight));
         middleLeft.addMouseListener(new BoardMouseListener(middleLeft));
         center.addMouseListener(new BoardMouseListener(center));
         middleRight.addMouseListener(new BoardMouseListener(middleRight));
         bottomLeft.addMouseListener(new BoardMouseListener(bottomLeft));
         bottomMiddle.addMouseListener(new BoardMouseListener(bottomMiddle));
         bottomRight.addMouseListener(new BoardMouseListener(bottomRight));
         */
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }

}
