package jdbc_assignment;

import java.util.ArrayList;
import java.util.List;

import data.City;
import data.CityDaoImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

			CityDaoImpl c=new CityDaoImpl();
			List<City> theCities = new ArrayList<City>();
//			System.out.println(c.findById(5));
//			
//	    	theCities = c.findByCode("GB");
//	    	theCities.forEach(System.out::println);
//	    	
	    	theCities.clear();
	    	theCities = c.findByName("Astad2");
	    	theCities.forEach(System.out::println);
	    	
//	    	theCities.clear();
//	    	theCities = c.findAll();
//	    	theCities.forEach(System.out::println);
	    	
//	    	City theCity = new City(0, "Astad2", "SWE", "Skane", 54321);
//	    	c.add(theCity);
//	    
	    	theCities.clear();
	    	theCities = c.findByName("Astad2");
	    	City theCity = c.findById((c.findByName("Astad2").get(0).getID())); //just take the first object and update
	    	theCity.setPopulation(98556);
	    	theCity.setDistrict("Småland");
	    	
	    	System.out.println("After change: " +theCity);	    	
	    	System.out.println(theCity);
//	    	theCities.clear();
//	    	theCities = c.findAll();
//	    	theCities.forEach(System.out::println);
	}
}
