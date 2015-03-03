
public class Card implements Comparable<Card> {

	private int value;
	private int suit;
	
	public Card(String input)
	{
		
		char val = input.charAt(0);
		char su = input.charAt(1);
		
		switch (val)
		{
		case '2':
			this.value = 2;
			break;
			
		case '3':
			this.value = 3;
			break;
			
		case '4':
			this.value = 4;
			break;
			
		case '5':
			this.value = 5;
			break;
			
		case '6':
			this.value = 6;
			break;
			
		case '7':
			this.value = 7;
			break;
			
		case '8':
			this.value = 8;
			break;
			
		case '9':
			this.value = 9;
			break;
			
		case 'T':
			this.value = 10;
			break;
			
		case 'J':
			this.value = 11;
			break;
			
		case 'Q':
			this.value = 12;
			break;
			
		case 'K':
			this.value = 13;
			break;
			
		case 'A':
			this.value = 14;
			break;
		}
		
		switch (su)
		{
		case 'S':
			this.suit = 1;
			break;
		
		case 'C':
			this.suit = 2;
			break;
		
		case 'D':
			this.suit = 3;
			break;
		
		case 'H':
			this.suit = 4;
			break;
		}
		
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public int compareTo(Card other) {
		
		return Integer.compare(this.getValue(), other.getValue());
//		
//		if (this.getValue() > other.getValue())
//		{
//			return 1;
//		}
//		if (this.getValue() < other.getValue())
//		{
//			return -1;
//		}
//		
//		return 0;
	}

}
