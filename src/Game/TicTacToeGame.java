package Game;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeGame extends JFrame {
	SetBoardSize s = new SetBoardSize();
	protected JButton btn[][];
	int SIZE;

	public TicTacToeGame(int SIZE) {
		this.SIZE = SIZE;
		setTitle("TicTacToe ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		TicTacToeActionListener l = new TicTacToeActionListener();

		btn = new JButton[SIZE][SIZE];

		cp.setLayout(new GridLayout(SIZE, SIZE));

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setText("");
				add(btn[i][j]);
				btn[i][j].addActionListener(l);
			}
		}

		setSize(600, 600);
		setResizable(false);
		setVisible(true);
	}

	public class TicTacToeActionListener implements ActionListener {
		int turn = 0;

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int exitOption;
			if (b.getText().equals("")) {
				if (turn % 2 == 0) {
					b.setText("O");
					if (TicTacToeCheckWinner("O")) {
						exitOption = JOptionPane.showConfirmDialog(null, "���� ����!\nO�� �¸�\n������ �����մϴ�.", "���α׷� ����",
								JOptionPane.YES_NO_OPTION);
						if (exitOption == JOptionPane.YES_OPTION)
							System.exit(JFrame.EXIT_ON_CLOSE);

						else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
							return;
					}

				} else if (turn % 2 == 1) {
					b.setText("X");
					if (TicTacToeCheckWinner("X")) {
						exitOption = JOptionPane.showConfirmDialog(null, "���� ����!\nX�� �¸�\n������ �����մϴ�.", "���α׷� ����",
								JOptionPane.YES_NO_OPTION);
						if (exitOption == JOptionPane.YES_OPTION)
							System.exit(JFrame.EXIT_ON_CLOSE);

						else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
							return;
					}
				}
			} else if (b.getText().equals("O") || b.getText().equals("X"))
				turn--;

			turn++;

			if (turn == SIZE * SIZE) {
				exitOption = JOptionPane.showConfirmDialog(null, "���� ����!\n���º��Դϴ�.\n������ �����մϴ�.", "���α׷� ����",
						JOptionPane.YES_OPTION);
				if (exitOption == JOptionPane.YES_OPTION)
					System.exit(JFrame.EXIT_ON_CLOSE);

				else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
					return;
			}
		}
	}

	public boolean TicTacToeCheckWinner(String symbol) {
		int i, j;
		// �࿡�� �¸� ����
		for (i = 0; i < SIZE; i++) {
			for (j = 0; j < SIZE; j++)
				if (!btn[i][j].getText().equals(symbol))
					break;
			if (j == SIZE)
				return true;
		}
		// ������ �¸� ����
		for (i = 0; i < SIZE; i++) {
			for (j = 0; j < SIZE; j++)
				if (!btn[j][i].getText().equals(symbol))
					break;
			if (j == SIZE)
				return true;
		}
		
		// �밢������ �¸� ����
		for (i = 0; i < SIZE; i++) {
			if (!btn[i][i].getText().equals(symbol))
				break;
		}
		if (i == SIZE)
			return true;

		for (i = 0; i < SIZE; i++) {
			if (!btn[i][SIZE - i - 1].getText().equals(symbol))
				break;
		}
		if (i == SIZE)
			return true;

		return false;
	}
}