package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Error.TicTacToeError;

public class SetBoardSize extends JFrame {
	public int SIZE;
	public SetBoardSize() {
		setTitle("���� ������ ����");
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("���� ����� �������ּ���");
		JButton btn = new JButton("���� ����");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SIZE = Integer.parseInt(txtfield.getText());
				if (SIZE < 3)
					new TicTacToeError();

				else
					new TicTacToeGame(SIZE);
				dispose();
			}

		});
		
		add(label);
		add(btn);
		add(txtfield);
		
		setLayout(null);
		
		btn.setBounds(90, 80, 100, 30);
		label.setBounds(75, 20, 150, 30);
		txtfield.setBounds(70, 50, 150, 20);
		
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
	}
}