import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class PokerTest {

	@Test
	public void cardConstructor()
	{
		Card c1 = new Card("5H");
		Assertions.assertThat(c1.getValue()).isEqualTo(5);
		Assertions.assertThat(c1.getSuit()).isEqualTo(4);
	}
	
	
	@Test
	public void onePair() {
		
		Card c1 = new Card("5H");
		Card c2 = new Card("5C");
		Card c3 = new Card("6S");
		Card c4 = new Card("7S");
		Card c5 = new Card("TD");
		
		Hand hand1 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand1.rank()).isEqualTo(Hand.ONE_PAIR);
		
		c1 = new Card("JD");
		c2 = new Card("8D");
		c3 = new Card("8S");
		c4 = new Card("3S");
		c5 = new Card("2C");
		
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand2.rank()).isEqualTo(Hand.ONE_PAIR);
		Assertions.assertThat(hand1.compareTo(hand2)).isEqualTo(-1);
	}
	
	@Test
	public void highCard() {
		
		Card c1 = new Card("5D");
		Card c2 = new Card("8C");
		Card c3 = new Card("9S");
		Card c4 = new Card("AC");
		Card c5 = new Card("JS");
		
		Hand hand1 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand1.rank()).isEqualTo(Hand.HIGH_CARD);
		
		c1 = new Card("2C");
		c2 = new Card("8S");
		c3 = new Card("5C");
		c4 = new Card("QH");
		c5 = new Card("7D");
		
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand2.rank()).isEqualTo(Hand.HIGH_CARD);
		Assertions.assertThat(hand1.compareTo(hand2)).isEqualTo(1);
	}
	
	@Test
	public void flushAndThree() {
		
		Card c1 = new Card("2D");
		Card c2 = new Card("9C");
		Card c3 = new Card("AS");
		Card c4 = new Card("AH");
		Card c5 = new Card("AC");
		
		Hand hand1 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand1.rank()).isEqualTo(Hand.THREE_OF_A_KIND);
		
		c1 = new Card("7D");
		c2 = new Card("QD");
		c3 = new Card("6D");
		c4 = new Card("TD");
		c5 = new Card("3D");
		
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand2.rank()).isEqualTo(Hand.FLUSH);
		Assertions.assertThat(hand1.compareTo(hand2)).isEqualTo(-1);
		Assertions.assertThat(hand2.compareTo(hand1)).isEqualTo(1);
	}
	
	@Test
	public void onePairEqual() {
		
		Card c1 = new Card("9D");
		Card c2 = new Card("9C");
		Card c3 = new Card("JS");
		Card c4 = new Card("AH");
		Card c5 = new Card("4C");
		
		Hand hand1 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand1.rank()).isEqualTo(Hand.ONE_PAIR);
		
		c1 = new Card("AS");
		c2 = new Card("4D");
		c3 = new Card("9S");
		c4 = new Card("JD");
		c5 = new Card("9H");
		
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand2.rank()).isEqualTo(Hand.ONE_PAIR);
		Assertions.assertThat(hand1.compareTo(hand2)).isEqualTo(0);
	}

	@Test
	public void twoPair() {
		
		Card c1 = new Card("9D");
		Card c2 = new Card("9C");
		Card c3 = new Card("JS");
		Card c4 = new Card("4H");
		Card c5 = new Card("4C");
		
		Hand hand1 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand1.rank()).isEqualTo(Hand.TWO_PAIRS);
		
		c1 = new Card("4S");
		c2 = new Card("4D");
		c3 = new Card("9S");
		c4 = new Card("KD");
		c5 = new Card("9H");
		
		Hand hand2 = new Hand(c1, c2, c3, c4, c5);
		Assertions.assertThat(hand2.rank()).isEqualTo(Hand.TWO_PAIRS);
		
		Assertions.assertThat(hand1.compareTo(hand2)).isEqualTo(-1);
		Assertions.assertThat(hand2.compareTo(hand1)).isEqualTo(1);
	}
	
	@Test
	public void match()  throws FileNotFoundException
	{
		int vic = Match.match();
		Assertions.assertThat(vic).isEqualTo(376);
		
	}
}
