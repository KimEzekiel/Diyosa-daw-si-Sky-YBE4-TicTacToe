import java.awt.Color;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

class BoardMouseListener implements MouseListener {
	/* Executes when the button is clicked */
	private int isDisabled = 0;

	private JButton button;

	public BoardMouseListener(JButton button){
		this.button = button;
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	public void mouseClicked(MouseEvent e){
		
		this.button.setEnabled(false);
		this.isDisabled = 1;
	}
	public void mouseEntered(MouseEvent e){
		if(this.isDisabled == 0)
			this.button.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e){
		this.button.setBackground(null);
	}
}
