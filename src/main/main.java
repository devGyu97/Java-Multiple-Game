package main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import Game.*;

public class main extends JFrame {
	main() {
		setTitle("Game!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("게임을 선택해주세요");
		JButton btn1 = new JButton("TicTacToe 시작");
		JButton btn2 = new JButton("오목 시작");
		JButton btn3 = new JButton("1 to 50 시작");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SetBoardSize();
			}

		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OmokGame();
			}

		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				new One2FiftyGame(startTime);
			}

		});
		
		add(label);
		add(btn1);
		add(btn2);
		add(btn3);
		
		setLayout(null);
		
		label.setBounds(100, 60, 150, 30);
		btn1.setBounds(90, 110, 120, 40);
		btn2.setBounds(90, 150, 120, 40);
		btn3.setBounds(90, 190, 120, 40);
		
		setSize(300, 300);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		main mf = new main();
	}
}