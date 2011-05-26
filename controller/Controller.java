package tetris.controller;


import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import tetris.events.DisplayHighScoreEvent;
import tetris.events.GameEvent;
import tetris.events.KeyDownPressedEvent;
import tetris.events.KeyLeftPressedEvent;
import tetris.events.KeyRightPressedEvent;
import tetris.events.KeyUpPressedEvent;
import tetris.events.NewHighScoreEvent;
import tetris.events.PauseButtonPressedEvent;
import tetris.events.SpacePressedEvent;
import tetris.events.StartButtonPressedEvent;
import tetris.events.StopButtonPressedEvent;
import tetris.events.TimerTickEvent;
import tetris.model.Coordinates;
import tetris.model.Model;
import tetris.view.View;

/**
 * Kontroler gry
 * 
 * @author Anna Stępień
 * 
 */

public class Controller
{
	
	/** Model gry */
	private final Model model;
	/** Widok gry */
	private final View view;
	/** Kolejka blokująca przechowująca nadchodzące zdarzenia */
	private final BlockingQueue<GameEvent> eventQueue;
	/** Mapa wiążąca zdarzenia z akcjami */
	private final HashMap<Class<? extends GameEvent>, GameAction> actionMap;
	/** Timer */
	private final GameTimer gameTimer;
	
	

	/**
	 * Tworzy nowy obiekt kontrolera
	 * 
	 * @param model
	 * @param view
	 * @param eventQueue
	 */
	public Controller(Model model, View view, BlockingQueue<GameEvent> eventQueue)
	{
		
		this.model = model;
		this.view = view;
		this.eventQueue = eventQueue;
		gameTimer = new GameTimer(model.getGameSpeed(), eventQueue);
		actionMap = new HashMap<Class<? extends GameEvent>, GameAction>();
		createActionMap();
		
	}
	
	/**
	 * Uruchamia kontroler
	 * 
	 */
	public void start()
	{
		while(true)
		{
			final GameEvent event;
			try
			{
				event = eventQueue.take();
				actionMap.get(event.getClass()).execute(event);
			}
			catch(final InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Tworzy mapę zdarzeń i powiązanych akcji
	 * 
	 */
	private void createActionMap()
	{
		actionMap.put(StartButtonPressedEvent.class, new StartNewGameAction());
		actionMap.put(StopButtonPressedEvent.class, new StopGameAction());
		actionMap.put(PauseButtonPressedEvent.class, new PauseGameAction());
		actionMap.put(KeyDownPressedEvent.class, new MoveDownAction());
		actionMap.put(KeyLeftPressedEvent.class, new MoveLeftAction());
		actionMap.put(KeyRightPressedEvent.class, new MoveRightAction());
		actionMap.put(KeyUpPressedEvent.class, new RotateAction());
		actionMap.put(SpacePressedEvent.class, new DropDownAction());
		actionMap.put(TimerTickEvent.class, new TimerTickAction());
		actionMap.put(DisplayHighScoreEvent.class, new DisplayHighScoreAction());
		actionMap.put(NewHighScoreEvent.class, new RegisterHighScoreAction());
	}
	
	/**
	 * Akcja reprezentująca opuszczenie klocka na dno planszy
	 *
	 */
	private class DropDownAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			
			if (model.isGameRunning())
			{
				model.dropCurrentShapeDown();
				model.addDropPoints();
				view.updateBoard(model.getBoard());	
			}			
		}
		
	}
	
	/**
	 * Akcja reprezentująca przesunięcie klocka o jeden blok w dół
	 *
	 */
	private class MoveDownAction extends GameAction{

		@Override
		public void execute(GameEvent event) 
		{
				if (model.isGameRunning())
				{
					if (model.canMove(new Coordinates(0, -1)))
					{
						model.moveCurrentShapeDown();
						model.addFallPoints();
					}
					else
					{
						model.dropCurrentShapeDown();
					}
					view.updateBoard(model.getBoard());
				}
		}
		
	}
	
	/**
	 * Akcja reprezentująca przesunięcie kolcka o jedno pole w lewo
	 *
	 */
	private class MoveLeftAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			if (model.isGameRunning())
			{
				if (model.canMove(new Coordinates(-1, 0)))
				{
					model.moveCurrentShapeLeft();
					view.updateBoard(model.getBoard());
				}		
			}
		}
	}
	
	/**
	 * Akcja reprezentująca przesunięcie klocka o jeden blok w prawo
	 *
	 */
	private class MoveRightAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			if (model.isGameRunning())
			{
				if (model.canMove(new Coordinates(1, 0)))
				{
					model.moveCurrentShapeRight();
				}
				view.updateBoard(model.getBoard());
			}
		}
	}
	
	/**
	 * Akcja reprezentująca obrót klocka zgodnie z przyjętą strategią
	 *
	 */
	private class RotateAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			if (model.isGameRunning())
			{
				if (model.canRotate())
				{
					model.rotateCurrentShape();
					view.updateBoard(model.getBoard());
				}
			}
		}
	}
	
	/**
	 *Akcja reprezentująca rozpoczęcie nowej gry
	 *
	 */
	private class StartNewGameAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			model.startGame();
			gameTimer.start();
			view.enableButtons();
			view.updateBoard(model.getBoard());
			view.updatePreviewBoard(model.getNextShape());
			view.updateScore(model.getScore());
		}
		
	}
	
	/**
	 * Akcja reprezentująca wstrzymanie gry
	 *
	 */
	private class PauseGameAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			
			if (model.isGamePaused())
			{
				model.resumeGame();
				gameTimer.start();
			}
			else if (model.isGameRunning())
			{
				model.pauseGame();
				gameTimer.stop();
			}
			
		}
		
	}
	
	/**
	 * Akcja reprezentująca zakończenie gry
	 *
	 */
	private class StopGameAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			gameTimer.stop();
			model.endGame();
			view.updateScore(model.getScore());
			view.updatePreviewBoard(model.getNextShape());
			view.clearBoard();
		}
		
	}
	
	/**
	 * Akcja reprezentująca kwant czasu timera
	 *
	 */
	private class TimerTickAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			
			if (model.isGameRunning())
			{
				gameTimer.setDelay(model.getGameSpeed());
				if (model.canMove(new Coordinates(0, -1)))
				{
					model.moveCurrentShapeDown();
					model.addRemovedRowPoints(model.removeFullRows());
					view.updateBoard(model.getBoard());
					view.updateScore(model.getScore());
					view.updatePreviewBoard(model.getNextShape());
				}
				else
				{
					model.dropCurrentShapeDown();
					model.addRemovedRowPoints(model.removeFullRows());
					
					if (model.canAddNewShape())
					{
						model.addNewShape();
						view.updateBoard(model.getBoard());
						view.updateScore(model.getScore());
						view.updatePreviewBoard(model.getNextShape());
					}
					else
					{
						if (model.isHighScore())
						{
							view.displayRegisterHighScoreDialog(model.getScore());
						}
						model.endGame();
						view.clearBoard();
						view.updateScore(model.getScore());
						view.updatePreviewBoard(model.getNextShape());
					}
				}
				
			}
			
		}
		
	}
	
	/**
	 * Akcja reprezentująca pobranie najlepszych wyników
	 * 
	 */
	private class DisplayHighScoreAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			view.showHighScoreDialog(model.getFakeHighScore());
		}
		
	}
	
	/**
	 * Akcja reprezentująca zarejestrowanie dobrego wyniku
	 *
	 */
	private class RegisterHighScoreAction extends GameAction
	{

		@Override
		public void execute(GameEvent event) 
		{
			NewHighScoreEvent highScoreEvent = (NewHighScoreEvent)event;
			String playerName = highScoreEvent.getPlayerName();
			int playerScore = highScoreEvent.getScore();
			model.recordScore(playerName, playerScore);
		}
		
	}
	
	
}
