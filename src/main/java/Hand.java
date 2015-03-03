import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hand implements Comparable<Hand>{

	private List<Card> cards;
	
	public final static int STRAIGHT_FLUSH = 8; //
	public final static int FOUR_OF_A_KIND = 7; //
	public final static int FULL_HOUSE = 6; //
	public final static int FLUSH = 5; //
	public final static int STRAIGHT = 4; //
	public final static int THREE_OF_A_KIND = 3; //
	public final static int TWO_PAIRS = 2;
	public final static int ONE_PAIR = 1;
	public final static int HIGH_CARD = 0; //
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5)
	{
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		Collections.sort(cards);
	}
	
	
	
	public int compareTo(Hand other) {
		
		if (this.rank() > other.rank())
		{
			return 1;
		}
		if (this.rank() < other.rank())
		{
			return -1;
		}
		
		if (
				(this.rank() == FOUR_OF_A_KIND)
				||
				(this.rank() == FULL_HOUSE)
				||
				(this.rank() == THREE_OF_A_KIND)
				||
				(this.rank() == STRAIGHT_FLUSH)
				||
				(this.rank() == STRAIGHT)
			)
		{
			return this.getCard(2).compareTo(other.getCard(2));
		}
		
		if ( (this.rank() == FLUSH) || (this.rank() == HIGH_CARD) )
		{
			for (int i=4; i>=0; i--)
			{
				if (this.getCard(i).getValue() > other.getCard(4).getValue())
				{
					return 1;
				}
				if (this.getCard(i).getValue() < other.getCard(4).getValue())
				{
					return -1;
				}
			}
			return 0;
		}
		
		if (this.rank() == ONE_PAIR)
		{
			return onePair(this, other);
		}
		
		if (this.rank() == TWO_PAIRS)
		{
			return twoPairs(this, other); 
		}
		
		return 0;
	}
	
	private int onePair(Hand hand1, Hand hand2)
	{
			List<Card> cards1 = new ArrayList<Card>();
			List<Card> cards2 = new ArrayList<Card>();
			
			for (int i=0; i<5; i++)
			{
				cards1.add(hand1.getCard(i));
				cards2.add(hand2.getCard(i));
			}
			
			
			int index1 = 0;
			int index2 = 0;
			
			for (int i=0 ; i<4; i++)
			{
				if(cards1.get(i).getValue() == cards1.get(i+1).getValue())
				{
					index1 = i;
				}
				if(cards2.get(i).getValue() == cards2.get(i+1).getValue())
				{
					index2 = i;
				}
			}
			
			if (cards1.get(index1).getValue() > cards2.get(index2).getValue())
			{
				return 1;
			}
			
			if (cards1.get(index1).getValue() < cards2.get(index2).getValue())
			{
				return -1;
			}
			
			cards1.remove(index1);
			cards1.remove(index1);
			cards2.remove(index2);
			cards2.remove(index2);
			
			for (int i=2; i>=0; i--)
			{
				if (cards1.get(i).getValue() > cards2.get(i).getValue())
				{
					return 1;
				}
				if (cards1.get(i).getValue() < cards2.get(i).getValue())
				{
					return -1;
				}
			}
			return 0;
		}
	
	
	private int twoPairs(Hand hand1, Hand hand2)
	{
		List<Card> cards1 = new ArrayList<Card>();
		List<Card> cards2 = new ArrayList<Card>();
		
		for (int i=0; i<5; i++)
		{
			cards1.add(hand1.getCard(i));
			cards2.add(hand2.getCard(i));
		}
		
			
		int index1 = 0;
		int index2 = 0;
			
		for (int i=0 ; i<4; i++)
		{
			if(cards1.get(i).getValue() == cards1.get(i+1).getValue())
			{
				index1 = i;
			}
			if(cards2.get(i).getValue() == cards2.get(i+1).getValue())
			{
				index2 = i;
			}
		}
		
		if (cards1.get(index1).getValue() > cards2.get(index2).getValue())
		{
			return 1;
		}
		
		if (cards1.get(index1).getValue() < cards2.get(index2).getValue())
		{
			return -1;
		}
		
		cards1.remove(index1);
		cards1.remove(index1);
		cards2.remove(index2);
		cards2.remove(index2);
		
		for (int i=0 ; i<2; i++)
		{
			if(cards1.get(i).getValue() == cards1.get(i+1).getValue())
			{
				index1 = i;
			}
			if(cards2.get(i).getValue() == cards2.get(i+1).getValue())
			{
				index2 = i;
			}
		}
		
		if (cards1.get(index1).getValue() > cards2.get(index2).getValue())
		{
			return 1;
		}
		
		if (cards1.get(index1).getValue() < cards2.get(index2).getValue())
		{
			return -1;
		}
		
		cards1.remove(index1);
		cards1.remove(index1);
		cards2.remove(index2);
		cards2.remove(index2);
		
		return cards1.get(0).compareTo(cards2.get(0));
	}
	
	
	public int rank()
	{
		boolean flagValue = true;
		boolean flagColor = true;
		
		for (int i=0; i<4; i++)
		{
			if ( cards.get(i).getValue() != cards.get(i+1).getValue() - 1 )
			{
				flagValue = false;
				break;
			}
		}
		for (int i=0; i<4; i++)
		{
			if (cards.get(i).getSuit() != cards.get(i+1).getSuit() )
			{
				flagColor = false;
				break;
			}
		}
			
		if (flagValue && flagColor)
		{
			return STRAIGHT_FLUSH;
		}
		
		if (flagColor)
		{
			return FLUSH;
		}
		
		if (flagValue)
		{
			return STRAIGHT;
		}
		
		if (
				(cards.get(1).getValue() == cards.get(2).getValue())
				&&
				(cards.get(2).getValue() == cards.get(3).getValue())
				&&
				(
					(cards.get(0).getValue() == cards.get(1).getValue())
					||
					(cards.get(4).getValue() == cards.get(3).getValue())		
				)
			)
		{
			return FOUR_OF_A_KIND;
		}

		if (
				(cards.get(0).getValue() == cards.get(1).getValue())
				&&
				(cards.get(3).getValue() == cards.get(4).getValue())
				&&
				(
					(cards.get(2).getValue() == cards.get(1).getValue())
					||
					(cards.get(2).getValue() == cards.get(3).getValue())		
				)
			)
		{
			return FULL_HOUSE;
		}
		
		for (int i=0; i<3; i++)
		{
			if (
					(cards.get(i).getValue() == cards.get(i+1).getValue())
					&&
					(cards.get(i+1).getValue()==cards.get(i+2).getValue())  
				)
			{
				return THREE_OF_A_KIND;
			}
		}
		

		int pairs = 0;
		for (int i = 0; i<4; i++)
		{
			if (cards.get(i).getValue()==cards.get(i+1).getValue())
			{
				pairs++;
			}
		}
		
		if (pairs == 2)
		{
			return TWO_PAIRS;
		}
		
		if (pairs == 1)
		{
			return ONE_PAIR;
		}
		
		return HIGH_CARD;
		
	}
	
	public Card getCard(int i)
	{
		return cards.get(i);
	}
}
