package main.java.ch.hszt.hs_2010.mdp.HGHM.Controller;

public class Controller extends AbstractController {
	public static final String ELEMENT_HOSTIP_PROPERTY = "HostIp";

    public void changeElementText(String newHostIp) {
        setModelProperty(ELEMENT_HOSTIP_PROPERTY, newHostIp);
    }
}
