import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TTTButton extends JButton implements ActionListener{
	ImageIcon X,O;
	TicTacToe game;
	int row, col;
	
	public TTTButton(TicTacToe game, int row, int col) {
		X = new ImageIcon(this.getClass().getResource("x.png"));
		O = new ImageIcon(this.getClass().getResource("o.png"));
		this.addActionListener(this);
		this.game = game;
		this.row = row;
		this.col = col;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (!game.gameWon) {
			changeSkin();
			game.updateBoard(row, col);
			game.switchPlayer(game.currPlayer);
		}
		
	}
	
	public void changeSkin() {
		switch(game.currPlayer.id) {
			case 0:
				setIcon(null);
				break;
			case 1:
				setIcon(X);
				break;
			case 2:
				setIcon(O);
				break;
		}
	}
}
