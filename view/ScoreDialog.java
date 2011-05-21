package pl.edu.pw.elka.www.proz.tetris.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeHighScore;

class ScoreDialog extends JDialog
{
	
	private static final long serialVersionUID = 2282191363055377316L;

	public ScoreDialog(JFrame parent, final FakeHighScore highScore)
	{
		super(parent, true);
		JList scores = JList(list(highScore.getHighScore()));
		add(new JScrollPane(scores));
		setSize(200, 400);
	}
	
	public void display(){
		setVisible(true);
	}
}
