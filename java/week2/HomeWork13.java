package week2;
public class HomeWork13 {
	public static void main(String[] args) 
	{
		// create two variables i and j
		int i, j;
		
		// enter first for loop for number of rows 5 here
		for(i=0;i<5;i++)
		{
			// enter second for number of columns
			// if j is less than or equal to 2i+1 then print stars, else stop iteration 
			for(j=1;j<=(2*i+1);j++)
			{
				// print stars in the same line
				System.out.print("*");
			}
			// print new line
			System.out.println();			
		}
	}
}
