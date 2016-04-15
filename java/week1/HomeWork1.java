// Program to find prime number or not

package week1;

public class HomeWork1 
{
	public static void main(String[] args) 
	{
		int i; // define divisor variable
		int primeNum = 332;	// define prime number to be tested

		// if number is divided by 2 then it is not prime
		if (primeNum%2==0)
		{
			System.out.println(primeNum +" is NOT Prime");
			return;
		}
			
		// start for loop with divisor not greater or equal to than primeNum/2
		for(i=3; i<primeNum/2; i+=2) 
		{
		// calculate remainder for primeNum / divisor, if remainder is zero then the input is not prime
			if(primeNum%i==0)  
				break;
		}
		// if divisor becomes greater than or equal to primeNum/2 then number is prime
		if(i>=primeNum/2)
			System.out.println(primeNum +" is Prime");
		else
			System.out.println(primeNum +" is Not a Prime");
	}
}
