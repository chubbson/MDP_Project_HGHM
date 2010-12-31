package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import java.util.HashMap;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Common;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.AnalyzeTrace;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;

/**
 * Model class contains base functionality of HGHM
 *
 * @author David Hauri
 */
public class Model extends AbstractModel {
	private String hostIP;
	private HashMap<String, String> matchIp;
	private boolean quitRequest = false;
	private boolean startTraceRequest = false;
	private boolean analyzeTraceRequest = false;
	private String traceRouteString = "";
	private String analyzedTraceResult = ""; 

	/**
     * Provides the means to set or reset the model to
     * a default state
     */
    public void initDefault() {
    	setHostIp("127.0.0.1");
    }
    
	// Accessors
    /**
     * get model HostIp
     */
	public String getHostIp()
	{
		return hostIP;
	}
	
	/**
	 * Set Model HostIp
	 * @param hostIp
	 */
	public void setHostIp(String hostIp)
	{
		String oldHostIp = this.hostIP;
		this.hostIP = hostIp;
		firePropertyChange(Controller.ELEMENT_HOSTIP_PROPERTY, oldHostIp, this.hostIP);
	}
	            
	/**
	 * Set a quit Request and exit after firing requestProperty back to controller the application
	 * @param quitRequest
	 */
	public void setQuitRequest(java.lang.Boolean quitRequest)
	{
		boolean oldQuitRequest = this.quitRequest;
		this.quitRequest = quitRequest;
		firePropertyChange(Controller.REQUEST_QUIT_PROPERTY, oldQuitRequest, this.quitRequest);
		System.exit(0);
	}
	
	/**
	 * Set a start trace request 
	 * @param startTraceRequest
	 */
	public void setStartTraceRequest(java.lang.Boolean startTraceRequest)
	{
		boolean oldStartTraceRequest = this.startTraceRequest;
		this.startTraceRequest = startTraceRequest;
		firePropertyChange(Controller.REQUEST_TRACEROUTE_PROPERTY, oldStartTraceRequest, this.startTraceRequest);
		//starting Traceroute
		setTraceRouteResponse();
	}
	
	/**
	 * Set a start trace request 
	 * @param startTraceRequest
	 */
	public void setTraceRouteResponse()
	{
		String oldTraceRoute = this.traceRouteString;
		traceRouteString = Common.DEFAULT_TRACEROUTE;
		firePropertyChange(Controller.RESPONSE_TRACEROUTE_PROPERTY, oldTraceRoute, traceRouteString);
	}
	
	private void showMatchIp(HashMap<String, String> hmIp)
	{
		HashMap<String, String> oldMatchIp = this.matchIp;
		this.matchIp = hmIp;
		firePropertyChange(Controller.RESPONSE_MATCHIP_PROPERTY, oldMatchIp, this.matchIp);
	}
	
	public void setMatchIpRequest()
	{
		firePropertyChange(Controller.REQUEST_MATCHIP_PROPERTY, false, true);
		//get MatchIp 
		showMatchIp(new HashMap<String, String>());
	}
	
	public void setAnalyzeTraceRequest(java.lang.Boolean analyzeTraceRequest)
	{
		boolean oldAnalyzeTraceRequest = this.analyzeTraceRequest;
		this.analyzeTraceRequest = analyzeTraceRequest;
		firePropertyChange(Controller.REQUEST_ANALYZETRACE_PROPERTY, oldAnalyzeTraceRequest, this.analyzeTraceRequest);
		//starting Traceroute
		setAnalyzeTraceResponse();
	}
	
	public void setAnalyzeTraceResponse()
	{
		String oldAnalyzeResult = this.analyzedTraceResult;
		this.analyzedTraceResult = AnalyzeTrace.Analyze(traceRouteString);
		firePropertyChange(Controller.RESPONSE_ANALYZETRACE_PROPERTY, oldAnalyzeResult, this.analyzedTraceResult);
	}
	
//	AnalyzeTrace analyzeTrace = new AnalyzeTrace();
//	this.showResult(analyzeTrace.Analyze(taTraceField.getText()));
}
