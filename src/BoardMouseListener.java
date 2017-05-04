import java.awt.Color;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

class BoardMouseListener implements MouseListener {
	/* Executes when the button is clicked */

	private CheckerButton button;
	private TicTacToe game;

	public BoardMouseListener(CheckerButton button, TicTacToe game){
		this.button = button;
		this.game = game;
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	public void mouseClicked(MouseEvent e){
		if(this.button.getState() == true){
			this.button.setText(this.game.getCurrentPlayer().getButtonText());
			/*point is earned, reset*/
			this.button.setEnabled(false);
			this.button.setState(false);
			this.game.playerMoves(this.button.getCol(), this.button.getRow());
		}
	}
	public void mouseEntered(MouseEvent e){
		if(this.button.getState() == true)
			this.button.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e){
		this.button.setBackground(null);
	}
}
