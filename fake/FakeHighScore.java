package pl.edu.pw.elka.www.proz.tetris.fake;

import javax.swing.table.AbstractTableModel;

public class FakeHighScore extends AbstractTableModel 
{

	private static final long serialVersionUID = 8160499615037479142L;
	
	private String [] columnNames = {"Nazwa Gracza", "Liczba punktów"};
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
