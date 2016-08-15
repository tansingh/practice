import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame{

	JPanel p = new JPanel();
	Player p1;
	Player p2;
	Player currPlayer;
	boolean gameWon = false;
	int[][] board = new int[3][3];
	TTTButton[] buttons = new TTTButton[9];
	
	public TicTacToe() {
		super("TicTacToe");
		p1 = new Player("Player 1", 1);
		p2 = new Player("Player 2", 2);
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3)); //default: flow layout
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = -1;
				int num = i*3 + j;
				buttons[num] = new TTTButton(this, i, j);
				p.add(buttons[num]);
			}
		}
		add(p);
		setVisible(true);
		currPlayer = p1;
		
	}
	public void switchPlayer(Player p) {
		currPlayer = p.id == 1 ? p2 : p1;
	}
	
	public void checkGameStatus(int x, int y) {
		int col = 0; int row = 0; int diag = 0; int rdiag = 0;
		int player = currPlayer.id;
		for (int i = 0; i < 3; i++) {
			if (board[x][i] == player) {row++;};
			if (board[i][y] == player) {col++;};
			if (board[i][i] == player) {diag++;};
			if (board[2-i][i] == player) {rdiag++;};
		}
		if (row == 3 || col == 3 || diag == 3 || rdiag == 3) {
			winBoard();
			gameWon = true;
		}
	}
	
	public void updateBoard(int row, int col) {
		board[row][col] = currPlayer.id;
		checkGameStatus(row, col);
	}
	
	public void winBoard() {
		for (int i = 0; i < 9; i++) {
			buttons[i].changeSkin();
		}
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
}
