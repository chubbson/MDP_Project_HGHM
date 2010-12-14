package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

public class Model extends AbstractModel {
	private String hostIP;
	
	//Accessor
	public String getHostIp()
	{
		return hostIP;
	}
	
	public void setHostIp(String ip)
	{
		hostIP = ip;
	}
	
	/**
     * Provides the means to set or reset the model to
     * a default state
     */
    public void initDefault() {
    	setHostIp("127.0.0.1");
    }


}
