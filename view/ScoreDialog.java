package tetris.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tetris.fake.FakeHighScore;

/**
 * Okienko wyświetlające najlepsze wyniki
 * 
 * @author Anna Stępień
 *
 */
class ScoreDialog extends JDialog
{
	
	private static final long serialVersionUID = 1L;

	public ScoreDialog(JFrame parent)
	{
		super(parent, true);
		setSize(200, 400);
	}
	
	public void display(FakeHighScore fakeHighScore)
	{
		JTable table = new JTable(fakeHighScore);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane);
		setVisible(true);
	}
}
