import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class CheckerButton extends JButton{
     private int column;
     private int row;
     static final String DEFAULT_TEXT = " ";
     
     public CheckerButton(int column, int row, TicTacToe game){
          super();
          this.column = column;
          this.row = row;
          this.setFont(this.getFont().deriveFont(15f));
          //listeners
          this.addMouseListener(new BoardMouseListener(this, game) );
          // this.setText();
     }
     /*getters*/
     public int getCol(){
          return this.column;
     }
     public int getRow(){
          return this.row;
     }
     void markButton(){

     }

}
