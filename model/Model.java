package pl.edu.pw.elka.www.proz.tetris.model;

import pl.edu.pw.elka.www.proz.tetris.fake.FakeBoard;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeScore;
import pl.edu.pw.elka.www.proz.tetris.fake.FakeShape;

/**
 * Model gry
 * 
 */
public class Model {
	
	/** Bonusowe punkty za usunięty wiersz */
	private final static int removedRowBonus  = 15;
	/** Bonusowe punkty za opuszczenie klocka na dno planszy */
	private final static int instantDropBonus = 10;
	/** Bonusowe punkty za przyspieszenie opadania */
	private final static int fallBonus = 5;
	/** Maksymalna liczba najlepszych wyników */
	private final static int MAX_HIGHSCORES = 10;
	
	/** Bieżący klocek poruszający się po planszy */
	private Shape currentShape;
	
	/** Następny klocek jaki pojawi się na planszy */
	private Shape nextShape;
	
	/** Stan gry */
	private GameState state;
	
	/** Plansza gry */
	private TetrisBoard board;
	
	/* Fabryka losowych klocków */
	private RandomShapeFactory shapeFactory;
	
	/** Poziom */
	private int level;
	
	/** Wynik */
	private int score;
	
	/** Najlepsze wyniki */
	private HighScore highScore;
	
	/**
	 * Tworzy nowy obiekt modelu
	 */
	public Model()
	{
		board = new TetrisBoard();
		shapeFactory = new RandomShapeFactory();
		currentShape = null;
		nextShape = shapeFactory.getRandomShape();
		highScore = new HighScore();
	}
	
	
	/*
	 * Rozpoczyna grę
	 */
	public void startGame()
	{
		state = GameState.RUNNING;
		board.clear();
		level = 1;
		score = 0;
		addNewShape();
	}
	
	/**
	 * Wstrzymuje grę
	 */
	public void pauseGame()
	{
		state = GameState.PAUSED;
	}
	
	/**
	 * Wznawia grę
	 */
	public void resumeGame()
	{
		if (state == GameState.PAUSED)
		{
			state = GameState.RUNNING;
		}
	}
	
	/**
	 * Kończy grę
	 */
	public void endGame()
	{
		state = GameState.ENDED;
		nextShape = null;
		score = 0;
	}
	
	/**
	 * Sprawdza czy gra jest aktywna
	 * @return true jeśli na planszy jest aktywny klocek, false w przeciwnym wypadku
	 */
	public boolean isGameRunning()
	{
		return state == GameState.RUNNING;
	}
	
	/**
	 * Sprawdza czy gra jest wstrzymana
	 * @return true jeśli gra jest wstrzymana, false w przeciwnym wypadku
	 */
	public boolean isGamePaused()
	{
		return state == GameState.PAUSED;
	}
	
	/**
	 * Sprawdza czy gra została zakończona
	 * @return true, jeśli gra jest zakończona,false w przeciwnym przypadku
	 */
	public boolean isGameEnded()
	{
		return state == GameState.ENDED;
	}
	
	/**
	 * Sprawdza czy uzyskany wynik należy do 10 najlepszych
	 * @return true, jeśli uzyskany wynik należy do 10 najlepszych, false w przeciwnym przypadku
	 */
	public boolean isHighScore()
	{
		int highScoreSize = highScore.getScores().size();
		int lastMax = highScore.getScores().get(highScoreSize -1).getScore();
		if ( highScoreSize < MAX_HIGHSCORES || score >= lastMax)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Umieszcza nowy klocek na planszy
	 */
	public void addNewShape()
	{
		currentShape = nextShape;
		currentShape.setCenter(new Coordinates(6, 20));
		nextShape = shapeFactory.getRandomShape();
	}
	
	/**
	 * Przesuwa klocek o jedno pole w prawo
	 */
	public void moveCurrentShapeRight()
	{
		currentShape.moveRight();
	}
	
	/**
	 * Przesuwa klocek o jedno pole w lewo
	 */
	public void moveCurrentShapeLeft()
	{
		currentShape.moveLeft();
	}
	
	/**
	 * Przesuwa klocek o jedno pole w dół
	 */
	public void moveCurrentShapeDown()
	{
		currentShape.moveDown();
	}
	
	/**
	 * Opuszcza klocek na dno planszy
	 */
	public void dropCurrentShapeDown()
	{
		while(canMove(new Coordinates(0, -1)))
		{
			currentShape.moveDown();
		}
		board.addShape(currentShape);
	}
	
	/**
	 * Obraca klocek o 90 stopni przeciwnie do ruchu wskazówek zegara
	 */
	public void rotateCurrentShape()
	{
		currentShape.rotate();
	}
	
	/**
	 * Sprawdza czy na planszy można umieścić nowy klocek
	 * @return true jeśli na planszy można umieścić nowy klocek, false w przeciwnym wypadku
	 */
	public boolean canAddNewShape()
	{
		return nextShape.collide(board, new Coordinates(6, 20));
	}
	

	/**
	 * Sprawdza czy aktywny klocek może wykonać ruch
	 * @param vector
	 * @return true jeśli aktywny klocek może się przemieścic o vector
	 */
	public boolean canMove(Coordinates vector)
	{
		Coordinates oldPosition = currentShape.getCenter();
		Coordinates newPosition = new Coordinates(oldPosition.getX()+vector.getX(),
				oldPosition.getY()+vector.getY());
		return currentShape.collide(board, newPosition);
	}
	
	/**
	 * Sprawdza czy aktywny klocek może wykonać obrót
	 * @return true jeśli klocek może się obrócić, false w przeciwnym wypadku
	 */
	public boolean canRotate()
	{
		Shape rotatedShape = currentShape.getNextRotation();
		return rotatedShape.collide(board, rotatedShape.getCenter());
	}
	
	/**
	 * Usuwa pełne wiersze z planszy
	 */
	public int removeFullRows() 
	{
		 return board.removeFullRows();
	}
	
	/**
	 * Zwraca obiekt przeznaczony dla widoku reprezentujący następny klocek 
	 * @return następny klocek
	 */
	public final FakeShape getNextShape()
	{
		try {
			return nextShape.getFake();
		}
		catch(NullPointerException e){
			return null;
		}
	}
	
	/**
	 * Zwraca obiekt przeznaczony dla widoku reprezentujący planszę
	 * @return plansza gry
	 */
	public final FakeBoard getBoard()
	{
		try{
			return board.getFakeWithCurrentShape(currentShape);
		}
		catch(NullPointerException e){
			return null;
		}
	}
	
	/**
	 * Zwraca obiekt przeznaczony dla widoku informujący o poziomie, wyniku i liczbie usuniętych wierszy
	 * @return informacja o punktacji
	 */
	public final FakeScore getScore()
	{
		return new FakeScore(score, getLevel(), board.getRemovedRows());
	}
	
	/**
	 * Zwraca aktualną szybkość gry
	 * @return Szybkość gry 
	 */
	public int getGameSpeed() 
	{
		return (11 - getLevel()) * 100;
	}
	
	/**
	 * Zwraca poziom gry (1 do 10)
	 * @return Aktualny poziom gry
	 */
	public int getLevel()
	{
		if (board.getRemovedRows() <= 0)
			level = 1;
		else if (board.getRemovedRows() <= 90 && board.getRemovedRows() >= 1)
			level = 1 + (board.getRemovedRows() -1 )/10;
		else
			level = 10;
		return level;
	}
	
	/**
	 * Dodaje punkty za swobodny spadek
	 */
	public void addFallPoints()
	{
		score += getLevel()*fallBonus;
	}
	
	/**
	 * Dodaje punkty za opuszczenie klocka
	 */
	public void addDropPoints()
	{
		score += getLevel()*instantDropBonus;
	}
	
	/**
	 * Dodaje pukty za usunięte wiersze
	 * @param num liczba usuniętych wierszy
	 */
	public void addRemovedRowPoints(final int num)
	{
		score += getLevel()*num*removedRowBonus;
	}
	
	
	/**
	 * Zapisuje wynik gry do pliku
	 * @param playerName Nazwa gracza
	 * @param score Wynik gracza
	 */
	public void recordScore(String playerName)
	{
		if (playerName != null){
			highScore.addScore(playerName, score);
			highScore.save();
		}
	}
	
}
