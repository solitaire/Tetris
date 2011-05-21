package pl.edu.pw.elka.www.proz.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.Timer;

import pl.edu.pw.elka.www.proz.tetris.events.GameEvent;
import pl.edu.pw.elka.www.proz.tetris.events.TimerTickEvent;

/**
 * Klasa timera gry, stanowi opakowanie dla Swingowego Timera.
 * Udostępnia jedynie trzy metody: start, stop i setDelay
 * Po upłynięciu określonego czasu
 * do kolejki blokującej dodawane jest zdarzenie TimerTickEvent
 *
 */
class GameTimer 
{
	
	/* Timer */
	private Timer timer;
	
	/* Kolejka blokująca */
	private BlockingQueue<GameEvent> eventQueue;
	
	
	/**
	 * Tworzy nowy obiekt timera
	 * @param delay początkowe opóźnienie timera (w milisekundach)
	 * @param queue kolejka blokująca
	 */
	public GameTimer(int delay, BlockingQueue<GameEvent> queue)
	{
		eventQueue = queue;
		timer = new Timer(delay, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eventQueue.put(new TimerTickEvent());
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * Uruchamia timer
	 */
	public void start()
	{
		timer.start();
	}
	
	/**
	 * Zatrzymuje timer
	 */
	public void stop()
	{
		timer.stop();
	}
	
	/**
	 * Ustawia nowe opóźnienie timera
	 * @param delay opóźnienie w milisekundach
	 */
	public void setDelay(int delay)
	{
		timer.setDelay(delay);
	}
}
