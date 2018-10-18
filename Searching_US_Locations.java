import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;
	
public class USpostal {
        public static Place[] places;
        
        public static int search(Place[] p, String zip) {
        	for(int i=0; i< places.length;i++) {
        		if(zip.equals(places[i].getZip())) {
        		return i;
        		}	  
            }
			return -1;
        }
        
        static String[] options = { "Do it again?", "Exit"};
        
        
		public static void main(String[] args) {
			readData();
			int response=0;
			 do {
				 String zip = JOptionPane.showInputDialog(null,"Enter zip code");
				try {
					if (zip != null) {
						
						System.out.println("You asked me to search for zip code: " + zip);
						System.out.println("The zip code " + zip + " belongs to " +  places[search(places,zip)].getTown() +", " + places[search(places,zip)].getState());
						response=JOptionPane.showOptionDialog(null,
								"The zip code "+ zip+ " belongs to " + places[search(places,zip)].getTown() +", " + places[search(places,zip)].getState(),
								zip, JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null, options,options[0]);
						if(response == JOptionPane.YES_OPTION){
						System.out.println("Do you want me to search again? Yes");
						System.out.println(" ");
						}else{
							System.out.println("Do you want me to search again? No");
							System.out.println(" ");
							System.out.println("Good Bye!");
						}
						
					}
					
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "The zip code doesn't exist, try again", "Input Error",JOptionPane.ERROR_MESSAGE);
					System.out.println("The zip code " + zip + " does not exist");
					if(response == JOptionPane.YES_OPTION){
						System.out.println("Do you want me to search again? Yes");
						System.out.println(" ");
						}else{
							System.out.println("Do you want me to search again? No");
							System.out.println(" ");
							System.out.println("Good Bye!");
						}
					System.out.println(" ");
				} catch (java.lang.ArrayIndexOutOfBoundsException q) {
					JOptionPane.showMessageDialog(null, "The zip code doesn't exist, try again", "Input Error",JOptionPane.ERROR_MESSAGE);
					System.out.println("The zip code " + zip + " does not exist");
					if(response == JOptionPane.YES_OPTION){
						System.out.println("Do you want me to search again? Yes");
						System.out.println(" ");
						}else{
							System.out.println("Do you want me to search again? No");
							System.out.println(" ");
							System.out.println("Good Bye!");
						}
					System.out.println(" ");
				}
			} while (response == 0);
		}// main()
		
		public static void readData() {
			Scanner input;
			String line,line1;
			int i=0;
			
			try{
				
				URL webfile= new URL ("http://cs.brynmawr.edu/Courses/cs206/fall2017/DataFiles/uszipcodes.csv");
		        input= new Scanner(webfile.openStream());
		        line1= input.nextLine();
		        String[] entries= line1.split(",");
		        //System.out.println(entries[0]);
		        int n= Integer.parseInt(entries[0]);
		        places = new Place[n];	    
				while(input.hasNextLine()) {
					line = input.nextLine();
					//System.out.println(line);
					String[] pieces= line.split(",");
					places[i] = new Place(pieces[1],pieces[2], pieces[0]);
					i++;
					//System.out.println(p);	
				}
				/*for(int j=0; j< places.length; j++) {
			    	System.out.println(places[j]);
				}*/
			}catch(MalformedURLException e) {
				System.out.println("Error in opening file");
				e.printStackTrace();
				System.exit(1);
			}catch(IOException e) {
				System.out.println("Error in opening file");
				e.printStackTrace();
				System.exit(1);
			}
		}//readData()

} // class USPostal
