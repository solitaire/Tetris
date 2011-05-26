package tetris.view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.fake.FakeScore;

/**
 * Panel wyświetlający informacje o stanie gry
 * 
 * @author Anna Stępień
 */
class InfoPanel extends JPanel 
{
	
	private static final long serialVersionUID = 1L;

	/** Liczba zdobytych punktów */
	private final JLabel score;
	/** Poziom gry */
	private final JLabel level;
	/** Liczba usuniętych wierszy */
	private final JLabel removedRows;
	

	public InfoPanel()
	{
		setLayout(new GridLayout(3,0));
		score = new JLabel(Messages.getString("ScoreInfoScore")); //$NON-NLS-1$
		level = new JLabel(Messages.getString("ScoreInfoLevel")); //$NON-NLS-1$
		removedRows = new JLabel(Messages.getString("ScoreInfoRemovedRows")); //$NON-NLS-1$
		add(score);
		add(level);
		add(removedRows);
	}
	
	/**
	 * Uaktualnia liczbę zdobytych punktów
	 * 
	 * @param fake
	 */
	public void updateScore(FakeScore fake)
	{
		score.setText(Messages.getString("ScoreInfoLevel") + String.valueOf(fake.getScore())); //$NON-NLS-1$
	}
	
	/**
	 * Uaktualnia liczbę usuniętych wierszy
	 * 
	 * @param fake
	 */
	public void updateRemovedRows(FakeScore fake)
	{
		removedRows.setText(Messages.getString("ScoreInfoRemovedRows") + String.valueOf(fake.getRemovedRows())); //$NON-NLS-1$
	}
	
	/**
	 * Uaktualnia poziom
	 * 
	 * @param fake
	 */
	public void updateLevel(FakeScore fake)
	{
		level.setText(Messages.getString("ScoreInfoLevel") + String.valueOf(fake.getLevel())); //$NON-NLS-1$
	}

}
