package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class is used to create a Hashmap out of the Config file
 * 
 * @author Simon Marcin
 */
public class LoadFirewall {
	
	
	private String configPath;
	private HashMap <String,String> FirewallMap;

	public LoadFirewall() {
		this.ConfigToHash(); 
	}
	
	/**
	 * Creates the HashMap and Reader
	 * Reads also the config file line by line
	 */
	public void ConfigToHash(){
		
		configPath = "list.txt";
		FirewallMap = new HashMap<String, String>();
		
		try{
			
			BufferedReader reader = new BufferedReader(new FileReader(configPath));
			String readLine = reader.readLine();
			
			while(readLine!=null){
				EditNextLine(readLine);
				readLine = reader.readLine();
			}
			
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Splits the String into 3 parts and write the IP and Firewall name into the HashMap
	 * @param line of the config
	 */
	public void EditNextLine(String line){
		
		String[] temp = line.split("/");
		FirewallMap.put(temp[0], temp[2]);
	}	

	/**
	 * Gets the Hashmap with IP and Firewall name
	 * @return HashMap
	 */
	public HashMap<String, String> GetMap(){
		return FirewallMap;
	}
	
}
