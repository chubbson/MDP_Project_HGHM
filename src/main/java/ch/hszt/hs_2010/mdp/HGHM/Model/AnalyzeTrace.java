package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.LoadFirewall;

public class AnalyzeTrace {

	public static String Analyze(String string){
		ArrayList<String> strArr = ExtractIpFromTrace(string);
		return CompareIps(strArr);
	}

	private static ArrayList<String> ExtractIpFromTrace(String TraceRouteValue){
		String patternStr = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(TraceRouteValue);
		ArrayList<String> strArr = new ArrayList<String>();
		
		while(matcher.find()){
			strArr.add(matcher.group());
		}

		return strArr;
	}
	
	private static String CompareIps(ArrayList<String> strArr){
		String result = "";
		LoadFirewall fw = new LoadFirewall();
		HashMap<String, String> ipMap = fw.GetMap();

		for(int i=0; i<strArr.size(); i++){
			if(ipMap.get(strArr.get(i))!=null){
				result = result + strArr.get(i) + " " + ipMap.get(strArr.get(i)) + "\n";
			}
		}
		
		return result;
	}

}
