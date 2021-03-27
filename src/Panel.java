import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
	Game game;
	Timer tm;
	Font font;
	Panel() {
		setLayout(null);
		game = new Game();
//		tm = new Timer(100, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				repaint();
//			}
//		});
//		tm.start();
		repaint();
		font = new Font("sans-serif",2,40);
		JButton nGameBtn = new JButton("����� ����");
		nGameBtn.setBounds(500, 700, 200, 50);
		add(nGameBtn);
		nGameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game = new Game();
				repaint();
			}
		});
		JButton exitBtn = new JButton("�����");
		exitBtn.setBounds(1250, 700, 200, 50);
		add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		super.paint(g);
		game.computerField.paintField(g);
		game.playerField.paintField(g);
		if (game.computerWin()) {
			int x = game.computerLeftIndent - game.centerIndent;
			int y = game.topIndent + game.fieldSize * game.cellSize + 50;
			g.setFont(font);
			g.drawString("� ��������� �� ���������", x, y);
		} else if (game.playerWin()) {
			int x = game.computerLeftIndent - game.centerIndent;
			int y = game.topIndent + game.fieldSize * game.cellSize + 50;
			g.setFont(font);
			g.drawString("�����������! �� ��������!", x, y);
		}
	}
}
