/*
Author: Yevheniia Lavrova
Date: 16.06.2021
 */

public class Computer {

	String brand;
	String model; 
	long SN;
	double price;
	static int numOfComps;
	
	//Default constructor
	public Computer() {
		brand = "HP";
		model = "ProBook";
		SN = 100000;
		price = 1000;
		//numOfComps++;
	}
	
	//Fully Parameterized Constructor
	public Computer (String br, String md, long sn, double pr) {
		
		brand = br;
		model = md;
        SN = sn;  
        price = pr;
        numOfComps++;
    }

	//Getters and setters
	
	//BRAND
	public String getBrand() {
		return brand;
	}

	public void setBrand(String br) {
		brand = br;
	}

	//MODEL
	public String getModel() {
		return model;
	}

	public void setModel(String md) {
		model = md;
	}
	
	//SN
	public long getSN() {
		return SN;
	}

	public void setSN(long sn) {
		SN = sn;
	}
	//PRICE
	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}
	
//	public void showInfo() {
//		System.out.println("The brand of the computer is " + brand + " it's model is " + model + " it's serial number is " + SN +
//				" and the price is " + price);
//	}
	
	public String toString() {  
        return "The brand of the computer is " + brand + " it's model is " + model + " it's serial number is " + SN +
				" and the price is " + price;
    }
	
	public static int findNumberOfCreatedComputers() {
		//numOfComps++;
        System.out.println("\nThe number of computers is " + numOfComps);
        return numOfComps;
    }
}