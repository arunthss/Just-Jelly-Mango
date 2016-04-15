// Print all even numbers between 100 and 200

package week1;
public class HomeWork3 
{
	public static void main(String[] args) 
	{
		int start = 100; // define start value
		int end = 200; // define end value
		
		System.out.println("Even Numbers Between "+start+" and "+end);
		
		// increment value by 2 and print it
		while(start<end)
		{
			System.out.println(start+=2);
		}
	}
}
