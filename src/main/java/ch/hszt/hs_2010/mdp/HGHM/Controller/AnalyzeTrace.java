package main.java.ch.hszt.hs_2010.mdp.HGHM.Controller;

import java.util.HashMap;
import java.util.Iterator;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.LoadFirewall;

public class AnalyzeTrace {
	private String result;

	public String Analyze(String string){
		String[] strArr = ExtractIpFromTrace(string);
		return CompareIps(strArr);
	}

	public String[] ExtractIpFromTrace(String TraceRouteValue){
		String[] strArr = {"10.238.2.17", "10.239.3.33" , "10.239.8.1", "10.3.4.3"};	
		return strArr;
	}
	
	public String CompareIps(String[] strArr){
		LoadFirewall fw = new LoadFirewall();
		HashMap ipMap = fw.GetMap();
		result = "";
		
		for(int i=0;i<strArr.length;i++){
			if(ipMap.get(strArr[i])!=null){
				result = result + strArr[i] + " " + ipMap.get(strArr[i]) + "\n";
			}
		}
		
		return result;
	}

}
