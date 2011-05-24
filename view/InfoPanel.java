package pl.edu.pw.elka.www.proz.tetris.view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeScore;

/**
 * Panel wyświetlający informacje o stanie gry
 *
 */
class InfoPanel extends JPanel 
{
	
	private static final long serialVersionUID = -6581047491363585470L;

	/** Liczba zdobytych punktów */
	private final JLabel score;
	/** Poziom gry */
	private final JLabel level;
	/** Liczba usuniętych wierszy */
	private final JLabel removedRows;
	

	public InfoPanel()
	{
		setLayout(new GridLayout(3,0));
		score = new JLabel("Wynik: ");
		level = new JLabel("Poziom: ");
		removedRows = new JLabel("Usunięte wiesze: ");
		add(score);
		add(level);
		add(removedRows);
	}
	
	/**
	 * Uaktualnia liczbę zdobytych punktów
	 * @param fake
	 */
	public void updateScore(FakeScore fake)
	{
		score.setText("Wynik: " + String.valueOf(fake.getScore()));
	}
	
	/**
	 * Uaktualnia liczbę usuniętych wierszy
	 * @param fake
	 */
	public void updateRemovedRows(FakeScore fake)
	{
		removedRows.setText("Usunięte wiersze: " + String.valueOf(fake.getRemovedRows()));
	}
	
	/**
	 * Uaktualnia poziom
	 * @param fake
	 */
	public void updateLevel(FakeScore fake)
	{
		level.setText("Poziom: " + String.valueOf(fake.getLevel()));
	}

}
