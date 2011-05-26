package tetris.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import tetris.config.TetrisConfig;

/**
 * Klasa reprezentuje najlepsze wyniki osiągnięte przez graczy
 * Na wynik składa się nazwa gracza i jego liczba punktów
 * 
 * @author Anna Stępień
 */
class HighScore 
{
	/**Lista z najlepszymi wynikami graczy */
	private ArrayList<Score> highScores;
	
	
	/**
	 * Tworzy nowy obiekt 
	 * 
	 */
	public HighScore()
	{
		highScores = new ArrayList<Score>();
		load();
	}
	
	/**
	 * Dodaje wynik gracza do listy najlepszych wyników
	 * 
	 * @param playerName nazwa gracza
	 * @param score wynik
	 */
	public void addScore(String playerName, int score)
	{
		highScores.add(new Score(playerName, score));
	}
	
	/**
	 * Wczytuje i zwraca listę najlepszych wyników uporządkowanych 
	 * od najlepszego do najsłabszego
	 * 
	 * @return lita najlepszych wyników
	 */
	public final ArrayList<Score> getScores()
	{
		load();
		Collections.sort(highScores);
		return highScores;
	}
	
	/**
	 * Wczytuje listę wyników z pliku
	 * 
	 */
	public void load()
	{
		File file = new File(TetrisConfig.HIGHSCORE_FILE);
		
		if (!file.exists())
			try {
				file.createNewFile();
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		ObjectInputStream inputStream = null;
		try
		{
			inputStream = new ObjectInputStream(new FileInputStream(TetrisConfig.HIGHSCORE_FILE));
			highScores = (ArrayList<Score>) inputStream.readObject();
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
		catch(IOException e3)
		{
			e3.printStackTrace();
		}
		finally
		{
			try
			{
				if (inputStream != null)
					inputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Zapisuje listę najlepszych wyników do pliku
	 * 
	 */
	public  void save()
	{
		ObjectOutputStream outputStream = null;
		try
		{
			outputStream = new ObjectOutputStream(new FileOutputStream(TetrisConfig.HIGHSCORE_FILE));
			outputStream.writeObject(highScores);
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			try
			{
				if (outputStream != null)
					outputStream.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
