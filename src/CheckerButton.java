package gui;
import game.*;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

// import listeners;
import gui.listeners.BoardMouseListener;
public class CheckerButton extends JButton{
     static final String DEFAULT_TEXT = " ";

     private int column;
     private int row;
     private boolean isEnabled;
     private TicTacToe game;
     public CheckerButton(int column, int row, TicTacToe game){
          super();
          this.column = column;
          this.row = row;
          this.game = game;
          this.isEnabled = true;
          this.setFont(this.getFont().deriveFont(75f));
          //listeners
          this.addMouseListener(new BoardMouseListener(this, game) );
     }
     /*getters*/
     public int getCol(){
          return this.column;
     }
     public int getRow(){
          return this.row;
     }
     public boolean getClickable(){
          return this.isEnabled;
     }
     /*setters*/
     public void setClickable(boolean state){
          this.isEnabled = state;
     }
     public void markButton(){
          this.setText(this.game.getCurrentPlayer().getButtonText());
     }

}
