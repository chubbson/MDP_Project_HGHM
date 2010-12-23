package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import java.util.HashMap;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Common;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;

/**
 * Model class contains base functionality of HGHM
 *
 * @author David Hauri
 */
public class Model extends AbstractModel {
	private String hostIP;
	private boolean quitRequest = false;
	private boolean startTraceRequest = false;
	private String startTraceRouteString = "";

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
	 * Set a quit Request and exit after fireing requestProperty back to controller the application
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
		String TraceResponset = "";
		firePropertyChange(Controller.RESPONSE_TRACEROUTE_PROPERTY, TraceResponset, Common.DEFAULT_TRACEROUTE);
	}
	
}
