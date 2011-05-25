package pl.edu.pw.elka.www.proz.tetris.model;
import java.io.Serializable;

/**
 * Klasa reprezentująca wynik gracza
 * Przechowuje informacje o nazwie gracza i jego zdobytych punktach
 * 
 * @author Anna Stępień
 */
class Score implements Serializable,Comparable<Score>
	{
		
		private static final long serialVersionUID = 1L;

		/** Nazwa gracza */
		private final String playerName;
		/** Wynik */
		private final int score;
		
		/**
		 * Tworzy nowy obiekt wyniku gracza
		 * 
		 * @param playerName Nazwa gracza
		 * @param score Wynik gry
		 */
		public Score(String playerName, int score)
		{
			
			this.playerName = playerName;
			this.score = score;
		}
		
		/**
		 * Zwraca wynik gracza (liczbę punktów)
		 * 
		 * @return wynik gracza
		 */
		public final int getScore()
		{	
			return score;
		}
		
		/**
		 * Zwraca nazwę gracza
		 * 
		 * @return nazwa gracza
		 */
		public final String getPlayerName()
		{
			return playerName;
		}

		@Override
		public int compareTo(Score other) {
			
			int otherScore = other.getScore();
			
			if (getScore() > otherScore){
				return -1;
			}
			else if (getScore() < otherScore){
				return 1;
			}
			else{
				return 0;
			}
		}
		
	}