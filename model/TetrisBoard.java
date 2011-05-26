package tetris.model;

import java.awt.Color;
import java.util.ArrayList;

import tetris.config.TetrisConfig;
import tetris.fake.FakeBlock;
import tetris.fake.FakeBoard;

/**
 * Reprezentuje planszę gry tetris
 * 
 * @author Anna Stępień
 */
class TetrisBoard 
{
	
	/* Lista przechowująca wiersze składające się na planszę */
	private ArrayList<Row> board;
	/*  Liczba usuniętych wierszy */
	private int removedRows;
	
	
	/**
	 * Klasa reprezentująca wiersz planszy
	 *
	 */
	private class Row
	{
		
		/** Lista wszytkich bloków składających się na wiersz */
		private final ArrayList<Block> blocks;
		
		/**
		 * Tworzy nowy pusty wiersz
		 * 
		 */
		public Row()
		{
			blocks = new ArrayList<Block>(TetrisConfig.WIDTH);
			
			for (int i = 0; i < TetrisConfig.WIDTH; ++i)
			{
				blocks.add(new Block());
			}
		}
		
		/**
		 * Tworzy nowy wiersz o blokach w danym kolorze
		 * 
		 * @param color kolor wiersza
		 */
		public Row(final Color color)
		{
			blocks = new ArrayList<Block>(TetrisConfig.WIDTH);
			
			for (int i = 0; i < TetrisConfig.WIDTH; ++i)
			{
				blocks.add(new Block(color));
			}
		}
		
		/**
		 * Zwraca wszystkie bloki należące do wiersza
		 * 
		 * @return lista wszystkich blokow składających się na wiersz
		 */
		public final ArrayList<Block> getBlocks() 
		{
			return blocks;
		}
		
		/**
		 * Zwraca blok o podanej pozycji
		 * 
		 * @param position położenie bloku w wierszu
		 * @return blok
		 */
		public final Block getBlock(final int position)
		{
			return blocks.get(position);
		}
		
		/**
		 * Koloruje blok o danej pozycji na zadany kolor
		 * 
		 * @param position położenie bloku w wierszu
		 * @param color    nowy kolor
		 */
		public void setBlock(final int position, final Color color)
		{
			blocks.get(position).setColor(color);
		}
		
		/**
		 * Sprawdza czy wiesz jest pełen
		 * 
		 * @return true jeśli wiersz jest pełen, false w przeciwnym wpadku
		 */
		public boolean isFull()
		{
			for (Block block : blocks) 
			{
				if (block.getColor() == null)
					return false;
			}
			return true;
		}

		/**
		 * Czyści cały wiersz, zostawia obramowanie
		 * 
		 */
		public void clear()
		{
			for (Block block : blocks.subList(1, TetrisConfig.WIDTH - 1)) 
			{
				block.setColor(null);
			}
			
		}
	}


	/**
	 * Tworzy nową planszę
	 * 
	 */
	public TetrisBoard()
	{
		board  = new ArrayList<Row>(TetrisConfig.HEIGHT);
		removedRows = 0;
		
		for (int i = 0; i < TetrisConfig.HEIGHT; ++i)
		{
			board.add(new Row());
		}
		
		createBorder();
	}
	
	
	
	/**
	 * Zwraca wiersze planszy
	 * 
	 * @return wiersze planszy
	 */
	public final ArrayList<Row> getRows()
	{
		return board;
	}
	

	/**
	 * Koloruje pojedynczy blok planszy na określony kolor
	 * 
	 * @param position Położenie klocka na planszy
	 * @param color Nowy kolor klocka
	 */
	public void setBlock(final Coordinates position, final Color color)
	{
		
		try
		{
			board.get(TetrisConfig.HEIGHT-1-position.getY()).setBlock(position.getX(), color);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Index bloku jest poza zakresem");
		}
		
	}
	
	/**
	 * Sprawdza czy blok planszy jest zajęty
	 * 
	 * @param position Położenie klocka na planszy
	 * @return true jeśli blok planszy jest zajęty, false w przeciwnym wypadku
	 */
	public boolean isOccupied(final Coordinates position)
	{

		try
		{
			return board.get(TetrisConfig.HEIGHT-1-position.getY()).getBlock(position.getX()).getColor() != null;
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Index bloku jest poza zakresem.");
		}
		
		return false;
	}
	
	/**
	 * Umieszcza klocek na planszy
	 * 
	 * @param shape klocek który zostanie umieszczony na planszy
	 */
	public void addShape(final Shape shape)
	{
		for (Coordinates coords : shape.getCoords())
		{
			setBlock(new Coordinates(shape.getCenter().getX()+coords.getX(), shape.getCenter().getY()+coords.getY()), shape.getColor());
		}
	}
	
	/**
	 * Usuwa i zwraca liczbę usuniętych wierszy
	 * 
	 * @return liczba usuniętych wierszy
	 */
	public int removeFullRows()
	{
		int numOfRemoved;
		
		ArrayList<Row> fullRows = new ArrayList<Row>();
		
		for (Row row : board.subList(1, TetrisConfig.HEIGHT-1)) 
		{
			if (row.isFull())
			{
				fullRows.add(row);
				removedRows++;
			}
		}
		numOfRemoved = fullRows.size();
		board.removeAll(fullRows);
		
		while(board.size() != TetrisConfig.HEIGHT)
		{
			board.add(1, new Row());
		}
		
		createBorder();
		
		return numOfRemoved;
	}
	
	/**
	 * Zwraca liczbę usuniętych wierszy
	 * 
	 * @return Liczba usuniętych wierszy
	 */
	public int getRemovedRows()
	{
		return removedRows;
	}
	
	/**
	 * Czyści całą planszę gry
	 * 
	 */
	public void clear()
	{
		removedRows = 0;
		for (Row row : board.subList(1, TetrisConfig.HEIGHT-1)) 
		{
			row.clear();
		}
	}
	

	/**
	 * Tworzy obiekt typu FakeBoard 
	 * 
	 * @param currentShape aktywny klocek
	 * @return obiekt planszy przeznaczony dla widoku
	 */
	public FakeBoard getFakeWithCurrentShape(final Shape currentShape) 
	{
		ArrayList<ArrayList<FakeBlock>> fakeRows = new ArrayList<ArrayList<FakeBlock>>();
		int i, j;
		i = 0;
		
		for (Row row : board) 
		{
			ArrayList<FakeBlock> fakeBlocks = new ArrayList<FakeBlock>();
			j = 0;
			
			for (Block block : row.getBlocks()) 
			{
				fakeBlocks.add(new FakeBlock(new Coordinates(j, i), block.getColor()));
				j++;
			}
			fakeRows.add(fakeBlocks);
			
			i++;
		}
		
		for (Coordinates coordinates : currentShape.getCoords()) 
		{
			int row = TetrisConfig.HEIGHT -1 - (coordinates.getY()+currentShape.getCenter().getY());
			int col = coordinates.getX() + currentShape.getCenter().getX();
			fakeRows.get(row).set(col, new FakeBlock(new Coordinates(col, row), currentShape.getColor()));
		}
		return new FakeBoard(fakeRows);
	}
	
	/**
	 * Tworzy obramowanie planszy
	 * 
	 */
	private void createBorder()
	{
		for (Row row : board) 
		{
			row.setBlock(0, TetrisConfig.BORDER_COLOR);
			row.setBlock(TetrisConfig.WIDTH - 1, TetrisConfig.BORDER_COLOR);
		}
		
		board.set(0, new Row(TetrisConfig.BORDER_COLOR));
		board.set(TetrisConfig.HEIGHT - 1, new Row(TetrisConfig.BORDER_COLOR));
	}
}
