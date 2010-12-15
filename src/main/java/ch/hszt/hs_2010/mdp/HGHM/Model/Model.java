package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;

/**
 * Model class contains base functionality of HGHM
 *
 * @author David Hauri
 */
public class Model extends AbstractModel {
	private String hostIP;

	/**
     * Provides the means to set or reset the model to
     * a default state
     */
    public void initDefault() {
    	setHostIp("127.0.0.1");
    }
    
	// Accessors
	public String getHostIp()
	{
		return hostIP;
	}
	
	public void setHostIp(String hostIp)
	{
		String oldHostIp = hostIP;
		this.hostIP = hostIp;
		firePropertyChange(Controller.ELEMENT_HOSTIP_PROPERTY, oldHostIp, hostIP);
	}
}
