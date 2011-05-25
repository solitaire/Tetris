package pl.edu.pw.elka.www.proz.tetris.fake;

import javax.swing.table.AbstractTableModel;

/**
 * Tworzy model z najlepszymi wynikami dla widoku
 * @author Anna Stępień
 *
 */
public class FakeHighScore extends AbstractTableModel 
{

	private static final long serialVersionUID = 1L;
	
	/** Nazwy kolumn */
	private String [] columnNames = {"Nazwa Gracza", "Liczba punktów"};
	/** Dane z najlepszymi wynikami */
	private Object [][] highScores;
	
	public FakeHighScore(Object highScores[][])
	{
		this.highScores = highScores;
	}
	
	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount() 
	{
		return highScores.length;
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		return highScores[row][col];
	}
	
	@Override
	public String getColumnName(int column) 
	{
		return columnNames[column];
	}

}
