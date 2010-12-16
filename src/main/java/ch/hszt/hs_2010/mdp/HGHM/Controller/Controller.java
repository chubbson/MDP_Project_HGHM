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
	
	/**
	 * The HostIp name
	 */
	public static final String ELEMENT_HOSTIP_PROPERTY = "HostIp";

	/**
     * Change the element hostIp value in the model
     * @param newHostIp The new text element hostIp 
     */
    public void changeElementHostIp(String newHostIp) {
        setModelProperty(ELEMENT_HOSTIP_PROPERTY, newHostIp);
    }
}
