package week3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileHandling {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(new File("./data/amazon.xlsx"));

	}

}
