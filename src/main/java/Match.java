import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Match {

	public final static int FILE_LENGTH = 1000;
	
	public static int match() throws FileNotFoundException {
		
		Scanner poker = new Scanner(new File("src\\main\\resources\\poker.txt"));
		String line;
		
		int victory = 0;
				
		for (int i=0; i < FILE_LENGTH; i++)
		{
			line = poker.nextLine();
			
			String[] ls = line.split(" ");
			
			Hand hand1 = new Hand(new Card(ls[0]), new Card(ls[1]), new Card(ls[2]), new Card(ls[3]), new Card(ls[4]));
			Hand hand2 = new Hand(new Card(ls[5]), new Card(ls[6]), new Card(ls[7]), new Card(ls[8]), new Card(ls[9]));
			
			if (hand1.compareTo(hand2) == 1)
			{	
				victory++;
			}
		}
		poker.close();
		System.out.println(victory);
		return victory;
	}
	
}
