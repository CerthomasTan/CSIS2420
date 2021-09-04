import java.io.*;
import java.util.Scanner; 
import com.sun.tools.javac.Main; //Needed if developer needs to access classloader

@SuppressWarnings("unused")
public class Week2Part2 {
	
	/* This code assumes that you would like to access the data from outside the .jar bin file. Thus File method 
	 * was used. If the file cannot be find, it will prompt the user to enter in the file location. If you want
	 * to instead access the file from with the /bin files (i.e. .jar file) please scroll to the 2nd block of code.
	 * The 2nd block of code can be used instead to access the file within the jar file by inputstream class and class
	 * loaders.
	 */
	
	public static void main(String[] args) throws IOException {
		
		//Attributes
		Float totalValue = 0f; 
		int numberOfRow = 0; 
		String fileAddress = "Week2Part2.txt"; 
		File dataFile = new File(fileAddress); //will load the file 
		Scanner sc = new Scanner(System.in); 
		
		/*Checks if File exists and there is data within it. If either are not satisfied, 
		 * program will request user to enter a valid address. 
		 * This will loop until an appropriate data file is available 
		 */
		while(!dataFile.exists() || dataFile.length() < 0 ) {
			System.out.println("File not found. Exiting Program");
			System.out.println("Please Enter Address of File:");
			fileAddress = sc.nextLine(); 
			dataFile = new File(fileAddress); 
		}
		
		/*Will start be trying to place file into the buffered reader.
		 * If its able, this will begin reading each line and adding all values to total
		 * Additional exception check is placed if file is moved before code executes. 
		 */
		if(dataFile.exists() || dataFile.length() > 0) {
			BufferedReader br = null;
			String line = "";
			try {
				br = new BufferedReader(new FileReader(fileAddress));
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Exiting Program");
			}
			
			//will start reading lines
			while((line = br.readLine()) != null){
				float lineValue = Float.parseFloat(line);
				numberOfRow++;
				totalValue += lineValue;
			}
			
			//close file, buffered reader, and file reader
			br.close();
			
			//print out summary report for user
			System.out.printf("%25s%n","Summary of Data");
			System.out.println("--------------------------------");
			
			System.out.printf("%s%d%n","Number of Rows: " ,numberOfRow);
			System.out.printf("%s%,.2f%n","Total: " ,totalValue);
			System.out.printf("%s%,.2f%n", "Average: ",totalValue/numberOfRow );
			
			System.out.println("--------------------------------");
		}
		
		//allow for pause in program and awaits user to hit enter to terminate program.
		System.out.println("press enter to exit");
		sc.nextLine();
		sc.close();
	}
	
	
	/*
	 * If you wanted the file to be accessible from within .Jar File, Use the code Below.
	 */
	
	/*
	public static void main(String[] args) throws IOException {
			
			Float totalValue = 0f;
			int numberOfRow = 0;
			String fileAddress = "Week2Part2.txt";
			InputStream in = Main.class.getClassLoader().getResourceAsStream(fileAddress);
			Scanner sc = new Scanner(System.in);
			
			if(in.available() > 0) {
				BufferedReader br = null;
				String line = "";
				br = new BufferedReader(new InputStreamReader(in));
				while((line = br.readLine()) != null){
					float lineValue = Float.parseFloat(line);
					numberOfRow++;
					totalValue += lineValue;
				}
				
				br.close();
				
				System.out.printf("%25s%n","Summary of Data");
				System.out.println("--------------------------------");
				
				System.out.printf("%s%d%n","Number of Rows: " ,numberOfRow);
				System.out.printf("%s%,.2f%n","Total: " ,totalValue);
				System.out.printf("%s%,.2f%n", "Average: ",totalValue/numberOfRow );
				
				System.out.println("--------------------------------");
			}
			
			System.out.println("press enter to exit");
			sc.nextLine();
			sc.close();
		}*/
		
}
