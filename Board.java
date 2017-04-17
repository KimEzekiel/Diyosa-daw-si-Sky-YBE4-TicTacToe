import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Container;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class Board extends JFrame{
  private JFrame frame;

  public Board(String name){
    super(name);
    this.initGUI();
  }

  private void initGUI(){
    this.setPreferredSize(new Dimension(500,300));
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    Container container = this.getContentPane();
    container.setLayout(new GridLayout(3,1));

    JPanel board = new JPanel();
    board.setLayout(new GridLayout(3,3));
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(1,3));
    JPanel westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(1,1));
    JPanel eastPanel = new JPanel();
    eastPanel.setLayout(new GridLayout(1,1));

    JButton topLeft = new JButton();
    JButton topMiddle = new JButton();
    JButton topRight = new JButton();
    JButton middleLeft = new JButton();
    JButton center = new JButton();
    JButton middleRight = new JButton();
    JButton bottomLeft = new JButton();
    JButton bottomMiddle = new JButton();
    JButton bottomRight = new JButton();

    JLabel northLabel = new JLabel();
    northLabel.setText("              Player 1's turn");
    JLabel westLabel = new JLabel();
    westLabel.setLayout(new GridLayout());
    westLabel.setText("Player 1 ->");
    JLabel eastLabel = new JLabel();
    eastLabel.setLayout(new GridLayout());
    eastLabel.setText("Player 2 ->");
    JLabel southLabel = new JLabel();

    board.add(topLeft);
    board.add(topMiddle);
    board.add(topRight);
    board.add(middleLeft);
    board.add(center);
    board.add(middleRight);
    board.add(bottomLeft);
    board.add(bottomMiddle);
    board.add(bottomRight);

    westPanel.add(westLabel);

    centerPanel.add(northLabel);
    centerPanel.add(board);
    centerPanel.add(southLabel);

    eastPanel.add(eastLabel);

    container.add(westPanel);
    container.add(centerPanel);
    container.add(eastPanel);


    this.pack();
    this.setVisible(true);
  }
}
