// Fibonacci Series

package week1;
public class HomeWork2 
{
	public static void main(String[] args) 
	{
		int start = 0; // start of all series is 0
		int prev  = 1; // second value for all series is 1
		int next = 0; // define next value in series
		int maxValue = 100; // set maximum value for which series is designed
		
		System.out.println("Fibonacci Series");
		System.out.print(start +" " + prev + " ");// print initial two values
		
		while(true) // go for infinte loop
		{
			next = prev + start; // next value = current + previous value 
			start = prev; // previous value = current value
			prev = next; // current value = next value calculated
			
			if(next > maxValue) // test if we reached enough values in series
				break; // come out of infinite loop
			
			System.out.print(next + " "); // if current value in series is less than max print it
		}
	}
}
