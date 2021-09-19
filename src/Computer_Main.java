/*
Author: Yevheniia Lavrova
Date: 16.06.2021
 */

import java.util.Scanner;

public class Computer_Main {

	public static void main(String[] args) {

		System.out.println("Welcome!");
		
		Scanner scanner = new Scanner (System.in);
		
		Computer c1 = new Computer("Dell", "XPS", 111111, 1400.70); //using parameterized constructor
		Computer c2 = new Computer("HP", "ENVY", 222222, 1700.90);
		Computer c3 = new Computer("Microsoft", "Surface", 333333, 1300.40);
		//Computer c4 = new Computer(); //using default constructor
		
		char ans = 'y';
		int maxComputers;
		do {
			System.out.print("\nWhat's your inventory limit? \n(Please, enter a number greater than 5): ");
			maxComputers = scanner.nextInt ();
		} while (maxComputers < 6);
        scanner.nextLine();

        Computer[] inventory = new Computer[maxComputers];
       
       	inventory[0] = c1;
       	inventory[1] = c2;
       	inventory[2] = c3;
       	//inventory[3] = c4;
       	
       	Computer comp = new Computer();

       	boolean userChoice = true;
       	while (userChoice) {
       		System.out.println("\nSelect an option: ");
       		System.out.println("To enter new computers (password required) - press 1");
       		System.out.println("To change information of the computer (password required) - press 2");
       		System.out.println("To display all computers of a specific brand - press 3");
       		System.out.println("To display all computers under the certain price - press 4");
       		System.out.println("To quit - press 5");
       		System.out.print("\nPlease, enter your option (number from 1 to 5): ");
       		int option = scanner.nextInt();
       		
       		final int password = 123;
       		boolean optionOne = true;
       		
       		//1 this option is verifying the password entered by user and then, if it's correct, adding new object to the array
       		if (option == 1) {
       			System.out.print("Please, enter your password: ");
       			int pass = scanner.nextInt();
       			scanner.nextLine();
       			if (pass == password) {
       				while(optionOne) {
       					System.out.print("How many computers do you want to enter? ");
       					int compQuantity = scanner.nextInt();
       					scanner.nextLine();
       					//checking if number of entered computers is less than the inventory limit
       					if (compQuantity <= maxComputers) { 
       						//writing new objects to the array
       						for (int i = 0; i < compQuantity; i++) {
       							do {
       								System.out.print("Please, enter the brand: ");
       								comp.brand = scanner.nextLine();
       							} while (comp.brand.length() == 0);
       							
       							do {
       								System.out.print("Please, enter the model: ");
       								comp.model = scanner.nextLine();
       							} while (comp.model.length() == 0);
       							
       							do {
       								System.out.print("Please, enter the SN (must contain 6 digits): ");
       								comp.SN = scanner.nextLong();
       							} while (String.valueOf(comp.SN).length() != 6);

								do {
									System.out.print("Please, enter the price (should be more than 500): ");
									comp.price = scanner.nextDouble();
								} while (comp.price < 500);
								
								//creating new object in the array
       							inventory[Computer.numOfComps] = new Computer(comp.brand, comp.model, comp.SN, comp.price); 
       							System.out.println("\nNew computer was added successfully");
       							scanner.nextLine();
       						}
       						System.out.println("Do you want to add more computers?");
       						ans = scanner.next().charAt(0);
       						if (ans == 'y' || ans == 'Y') {
       							optionOne = true;
       						}
       						else {

       							System.out.println("\n=================== Info about computers ===================");
	                    
       							//iterating over inventory
       							for (int i = 0; i < inventory.length; i++) {
       								System.out.println(inventory[i] + " ");
       								compQuantity++;
       							}
		        		
       							//calling method for counting number of computers
       							Computer.findNumberOfCreatedComputers();
       							System.out.println("\nThank you! You'll be redirected to the main menu");
       							optionOne = false;
       						}
       					}
	        	
       					else {
       						System.out.println("The number you entered is larger than the limit of your inventory");
       					}
       				}
       			}
	        
       			//verifying the password
       			else {
       				int numOfTries = 3;
			        do {
			        	System.out.print("Try again (number of tries left: " + numOfTries + ") :  ");
				        pass = scanner.nextInt();
				        numOfTries--;  
			        } while (pass != password && numOfTries > 0);
       			}	
       		}
		
       		//2 this option is verifying the password entered by user and then, if it's correct, modifying characteristics of existing objects
       		else if(option == 2) {
       			boolean optionTwo = true;
       			System.out.print("Please, enter your password: ");
       			int pass = scanner.nextInt();
       			scanner.nextLine();
       				if (pass == password) {
       					while (optionTwo) {
       						System.out.print("Please, enter a number of computer you want to modify: ");
       						int selectedIndex = scanner.nextInt();
       						System.out.print("What information would you like to modify? ");
       						System.out.println("\n1. Brand");
       						System.out.println("2. Model");
       						System.out.println("3. SN");
       						System.out.println("4. Price");
       						System.out.println("5. Quit");
       						System.out.print("\nEnter your choice: ");
       						int userInput = scanner.nextInt();  

       						switch (userInput) {
       							case 1:
       								System.out.print("=== Brand modification ===\nPlease, enter new brand: ");
       								String newBrand = scanner.next();
       								scanner.nextLine();
       								//changing brand for the chosen computer
       								inventory[selectedIndex].setBrand(newBrand);
       								System.out.println("Computer brand was sucessfully modified\n");
       								System.out.println("Computer # " + selectedIndex + "\n" + inventory[selectedIndex]);
       								break;
       							case 2:  
       								System.out.print("=== Model modification ===\nPlease, enter new model: ");
       								String newModel = scanner.next();
       								scanner.nextLine();
       								//changing model for the chosen computer
       								inventory[selectedIndex].setModel(newModel);
       								System.out.println("Computer model was sucessfully modified\n");
       								System.out.println("Computer # " + selectedIndex + "\n" + inventory[selectedIndex]);
       								break;
       							case 3:  
       								System.out.print("=== SN modification ===\nPlease, enter new SN: ");
       								int newSN = scanner.nextInt();
       								scanner.nextLine();
       								//changing SN for the chosen computer
       								inventory[selectedIndex].setSN(newSN);
       								System.out.println("Computer SN was sucessfully modified\n");
       								System.out.println("Computer # " + selectedIndex + "\n" + inventory[selectedIndex]);
       								break;
       							case 4:  
       								System.out.print("=== Price modification ===\nPlease, enter new price: ");
       								int newPrice = scanner.nextInt();
       								scanner.nextLine();
       								//changing price for the chosen computer
       								inventory[selectedIndex].setPrice(newPrice);
       								System.out.println("Computer price was sucessfully modified\n");
       								System.out.println("Computer # " + selectedIndex + "\n" + inventory[selectedIndex]);
       								break;
       							case 5:  
       								optionTwo = false;
       								System.out.println("\nThank you! You'll be redirected to the main menu");
       								break;
       							default:
       								break;
       						}
       						//prompting the user to continue or go back to the main menu
       						System.out.println("Do you want to modify any other computers?");
       						ans = scanner.next().charAt(0);
       						if (ans == 'y' || ans == 'Y') {
       							optionTwo = true;
       						}
       						else {
       							optionTwo = false;
   								System.out.println("\nThank you! You'll be redirected to the main menu");
   								break;
       						}
       					}
       				}
		        
       				else {
       					int numOfTries = 3;
       					do {
       						System.out.println("Please enter password (number of tries left: " + numOfTries + ") :  ");
       						pass = scanner.nextInt();
       						numOfTries--;
       					} while (pass != password && numOfTries > 0);
       				}    
       		}
		
       		//3 this option is iterating over the array of objects and searching for the objects which have exact brand entered by the user
       		else if(option == 3) {
       			System.out.print("Please, enter the name of the brand you're looking for: ");
       			String brandSearch = scanner.next();
       			//iterating over inventory
       			for(int i = 0; i <= inventory.length; i++){
       				//comparing brand names
       				if(inventory[i].brand.equals(brandSearch)){
       					System.out.println("The brand is " + inventory[i].brand + " the model is " + inventory[i].model + " the price is " + inventory[i].price);
       					break;
    	           }	
       			} 
       		}
       		
       		//4 this option is iterating over the array of objects and searching for the objects which have less price than the price entered by the user
       		else if(option == 4) {
       			System.out.print("Please, enter the maximum price: ");
       			double maxPrice = scanner.nextDouble();
       			scanner.nextLine();
       			//iterating over inventory
       			for(int i = 0; i < inventory.length; i++){
       				//comparing the prices
       				if((double)inventory[i].price < maxPrice){
       					System.out.println("The brand is " + inventory[i].brand + " the model is " + inventory[i].model + " the price is " + inventory[i].price);
       				}
       			}
       			break;
       		}
		
       		//5 this option is quitting from the program
       		else if(option == 5) {
       			System.out.println("Thank you and bye!");
       			userChoice = false;
       		}
       		else {
       			System.out.print("\nYou entered a wrong number. Please, enter a number between 1 to 5\n");
       		}	
       	}   
       	
		scanner.close();
	}
}