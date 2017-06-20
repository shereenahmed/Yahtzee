package yahtzee.game.model;
import java.util.*;
import javax.swing.*;

public class ScoreSheet{
	
private int [] scores;
	
	public ScoreSheet(){
		scores = new int[15];
		for (int i = 0; i < 15; i++)
		{
			scores[i] = -1;
		}
}
	public void setScore(int n, int score){
		scores[n] = score;
	}
	
	public int getScore(int n){
		return scores[n];
}
	
	public int upperScore(){
		int upperScore = 0;
		for (int i = 0; i < 6; i++)
			if (scores[i] != -1)
				upperScore += scores[i];
		return upperScore;
	}
	
	public int bonusScore()
	{
		if (bonus())
			return 35;
		return 0;
	}
	
	public int totalUpperScore(){
		return upperScore() + bonusScore();
	}
	
	public int lowerScore(){
		int lowerScore = 0;
		for (int i = 6; i < scores.length; i++)
			if (scores[i] != -1)
				lowerScore += scores[i];
		return lowerScore;
}
	
	public int grandTotal(){
		return upperScore() + lowerScore();
	}

	public boolean bonus(){
		return upperScore() >= 63;
	}
	
	public boolean filled(){
		boolean ans = true;
		for (int i = 0; i < 13; i++)
			if (scores[i] == -1)
				ans = false;
		return ans;
}
	
	public boolean num(int n, Die [] dice){
		boolean ans = false;
		for (int i = 0; i < 5; i++)
			if (dice[i].value() == n)
				ans = true;
				
		return ans;
} 
	
	public boolean numOfAKind(int n, Die [] dice){
		boolean ans = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		for (int i = 0; i < 5; i++){
			if (dice[i].value() == 1)
				ones++;
			if (dice[i].value() == 2)
				twos++;
			if (dice[i].value() == 3)
				threes++;
			if (dice[i].value() == 4)
				fours++;
			if (dice[i].value() == 5)
				fives++;
			if (dice[i].value() == 6)
				sixes++;
		}
		ans = (ones >= n) || (twos >= n) || (threes >= n) || (fours >= n)
						 || (fives >= n) || (sixes >= n);
				
		return ans;
} 
	
	public boolean fullHouse(Die [] dice){
		boolean ans = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		for (int i = 0; i < 5; i++){
			if (dice[i].value() == 1)
				ones++;
			if (dice[i].value() == 2)
				twos++;
			if (dice[i].value() == 3)
				threes++;
			if (dice[i].value() == 4)
				fours++;
			if (dice[i].value() == 5)
				fives++;
			if (dice[i].value() == 6)
				sixes++;
		}		
		ans = (ones == 3 && (twos == 2 || threes == 2 || fours == 2 ||
				fives == 2 || sixes == 2)) || (twos == 3 && (ones == 2 ||
				 threes == 2 || fours == 2 || fives == 2 || sixes == 2)) ||
				 (threes == 3 && (ones == 2 || twos == 2 || fours == 2 ||
				 fives == 2 || sixes == 2)) || (fours == 3 && (ones == 2 ||
				 threes == 2 || twos == 2 || fives == 2 || sixes == 2))
				 || (fives == 3 && (ones == 2 || threes == 2 || fours == 2 ||
				 twos == 2 || sixes == 2)) || (sixes == 3 && (ones == 2 ||
				 threes == 2 || fours == 2 || fives == 2 || twos == 2));
				
		return ans;
	}
	
	// n == 4 for small, n == 5 for large
	public boolean numStraight(int n, Die [] dice){
		boolean ans = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		for (int i = 0; i < 5; i++){
			if (dice[i].value() == 1)
				ones++;
			if (dice[i].value() == 2)
				twos++;
			if (dice[i].value() == 3)
				threes++;
			if (dice[i].value() == 4)
				fours++;
			if (dice[i].value() == 5)
				fives++;
			if (dice[i].value() == 6)
				sixes++;
		}
		if (n == 4)
			ans = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1) ||
			 		(twos >= 1 && threes >= 1 && fours >= 1 &&	fives >= 1) ||
					  (threes >= 1 && fours >= 1 && fives >= 1 && sixes >= 1);
		
		if (n == 5)
			ans = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1 &&
					fives >= 1) || (twos >= 1 && threes >= 1 && fours >= 1 &&
						fives >= 1 && sixes >= 1);
		
		return ans;
}
	
	public boolean chance(){
		return scores[12] == -1;
	}

	// true iff there's been a yahtzee, and they have a yahtzee
	public boolean yahtzeeBonus(Die [] dice){
		return (numOfAKind(5, dice) && scores[11] == 50);
}

}

