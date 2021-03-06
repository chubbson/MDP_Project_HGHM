package main.java.ch.hszt.hs_2010.mdp.HGHM.Controller;

/**
 * This controller implements the required methods and provides the properties
 * necessary to work with the DisplayViewPanel and PropertyViewPanel views. Each of
 * methods in this class can be called upon by the views to update to state of the
 * registered models.
 * @author david
 */
public class Controller extends AbstractController {
	//  Properties this controller expects to be stored in one or more registered models
	
	public static final String ELEMENT_HOSTIP_PROPERTY = "HostIp";
	public static final String REQUEST_QUIT_PROPERTY = "QuitRequest";
	public static final String REQUEST_TRACEROUTE_PROPERTY = "StartTraceRequest";
	public static final String RESPONSE_TRACEROUTE_PROPERTY = "TraceRouteResponse";
	public static final String RESPONSE_MATCHIP_PROPERTY = "MatchIpResponse";
	public static final String REQUEST_MATCHIP_PROPERTY = "MatchIpRequest";
	public static final String REQUEST_ANALYZETRACE_PROPERTY = "AnalyzeTraceRequest";
	public static final String END_ANALYZETRACE_PROPERTY = "AnalyzeTraceEnd";
	public static final String RESPONSE_ANALYZETRACE_PROPERTY = "AnalyzeTraceResponse";
	public static final String GET_TRACEROUTE_PROPERTY = "TraceRouteRequest";
	
	/**
     * Change the element hostIp value in the model
     * @param newHostIp The new text element hostIp 
     */
    public void changeElementHostIp(String newHostIp) {
        setModelProperty(ELEMENT_HOSTIP_PROPERTY, newHostIp);
    }
    
    /**
     * Quit requested
     */
    public void requestQuit()
    {
    	setModelProperty(REQUEST_QUIT_PROPERTY, true);
    }
    
    /**
     * starting traceroute request
     */
    public void requestTraceRoute()
    {
    	setModelProperty(REQUEST_TRACEROUTE_PROPERTY, true);
    }
    
    /**
     * Traceroute response
     */
    public void responseTraceRoute(String newTraceRoute)
    {
    	setModelProperty(RESPONSE_TRACEROUTE_PROPERTY, newTraceRoute);
    }

    /**
     * starting analyze trace request
     */
	public void requestTraceAnalyze() {
		setModelProperty(REQUEST_ANALYZETRACE_PROPERTY, true);
	}

    /**
     * response of requested trace route
     */
	public void responseTraceAnalyze() {
		setModelProperty(RESPONSE_TRACEROUTE_PROPERTY, true);
	}
}
