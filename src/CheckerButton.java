import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class CheckerButton extends JButton{
     private int column;
     private int row;
     static final String DEFAULT_TEXT = " ";
     static final boolean DEFAULT_STATE = true;   //isEnabled = true by default
     private boolean isEnabled;
     public CheckerButton(int column, int row, TicTacToe game){
          super();
          this.column = column;
          this.row = row;
          this.setFont(this.getFont().deriveFont(15f));
          //listeners
          this.addMouseListener(new BoardMouseListener(this, game) );
          this.isEnabled = DEFAULT_STATE;
     }
     /*getters*/
     public int getCol(){
          return this.column;
     }
     public int getRow(){
          return this.row;
     }
     public boolean getState(){
          return this.isEnabled;
     }
     /*setters*/
     public void setState(boolean state){
          this.isEnabled = state;
     }
     public void resetToDefault(){
          this.setText(DEFAULT_TEXT);
          this.isEnabled = DEFAULT_STATE;
     }

}
