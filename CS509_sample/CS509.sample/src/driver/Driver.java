/**
 * 
 */
package driver;

import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import airport.Airport;
import airport.Airports;
import dao.ServerInterface;
import schedule.Depart;

/**
 * @author blake
 *
 */
public class Driver {

	/**
	 * Entry point for CS509 sample code driver
	 * 
	 * This driver will retrieve the list of airports from the CS509 server and print the list 
	 * to the console sorted by 3 character airport code
	 * 
	 * @param args is the arguments passed to java vm in format of "CS509.sample teamName" where teamName is a valid team
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: CS509.sample teamName");
			System.exit(-1);
			return;
		}
		String teamName = args[0];
		String dLocation;
		String aLocation;
		String dyear, dmonth, dday, dtime;
		int type = -1;
		//String dLocation = args[1];
	//	String dTime = args[2];
		//String aLocation = args[3];
		// Try to get a list of airports
		//Airports airports = ServerInterface.INSTANCE.getAirports(teamName);
		//String [] airports = [];
		System.out.println("please input the departure airport");
		 Scanner sc = new Scanner(System.in); 
		 dLocation = sc.nextLine();
		System.out.println("please input the departure date(year)");
		dyear = sc.nextLine();
		System.out.println("please input the departure date(month)");
		dmonth = sc.nextLine();
		System.out.println("please input the departure date(day)");
		dday = sc.nextLine();
		dtime = dyear + "_" + dmonth + "_" + dday;
		System.out.println(dtime);
		//System.out.println(dtime);
		ArrayList<Depart> result = ServerInterface.INSTANCE.departPlans(teamName, dLocation, dtime);
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++) {
			//System.out.println(result.get(i).getdLocation());
			if (result.get(i).getdLocation().equals(dLocation) ) {
				 System.out.println("Information found and this is all the departure information");	
				 System.out.println("departure airport");
				  System.out.println(result.get(i).getdLocation());
				  System.out.println("Airplane");
				  System.out.println(result.get(i).getAirplane());
				  System.out.println("departure time");
				  System.out.println(result.get(i).getDtime());
				  System.out.println("airplane number");
				  System.out.println(result.get(i).getNumber());
				  System.out.println("Information found and this is all the arrival information");
				  System.out.println("arrival airport");
				  System.out.println(result.get(i).getaLocation());
				  System.out.println("arrival time");
				  System.out.println(result.get(i).getAtime());
				  System.out.println("Flight time");
				  System.out.println(result.get(i).getFtime());
				  System.out.println("Number of first class booked");
				  System.out.println(result.get(i).getfClass());
				  System.out.println("first class price");
				  System.out.println(result.get(i).getfPrice());
				  System.out.println("Number of coach class booked");
				  System.out.println(result.get(i).getCclass());
				  System.out.println("coach class price");
				  System.out.println(result.get(i).getcPrice());
			}
		}
	 // if (type > 0) {
		  //System.out.println("Information found and this is all the airplane information");
		  //System.out.println(result.get(type).getdLocation());
		 // System.out.println(result.get(type).getAirplane());
		  //System.out.println(result.get(type).getDtime());
		//  System.out.println(result.get(type).getNumber());
	  //}
	}
}
