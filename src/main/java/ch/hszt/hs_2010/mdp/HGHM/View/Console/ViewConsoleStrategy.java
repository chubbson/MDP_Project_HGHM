package main.java.ch.hszt.hs_2010.mdp.HGHM.View.Console;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

/**
 * Console view class which implements the interface IViewStrategy. 
 * This class is added in the ViewStrategyFactory. 
 * Hanldles the usability in the controller
 * @author david
 */
public class ViewConsoleStrategy implements IViewStrategy{

	private Controller controller; 
	private String hostIp;
	
	/**
	 * Default Constructor is used in the ViewStrategyFactory for adding to available view strategies
	 * Note: If an instance would be used by the ViewStrategyFactory, a controller should be set once. 
	 */
	public ViewConsoleStrategy(){
	}
	
	/**
	 * This Constructor should be used if you would instantiate this class without the factory
	 * @param controller
	 */
	public ViewConsoleStrategy(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * This function shows current HostIp
	 */
	@Override
	public void showIP() {
		System.out.println(getHostIp());
	}

    /**
     * Called by the controller when it needs to pass along a property change
     * from a model. Note that the method checks each GUI parameter to determine
     * if the current value is already equal to the incoming value. If it is, 
     * the method will not reset the value. This is done to prevent looping from
     * occurring when a model property is reset.
     * @param evt The property change event
     */
	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				Controller.ELEMENT_HOSTIP_PROPERTY)) {
			String newStringValue = evt.getNewValue().toString();
			if (getHostIp() == null || !getHostIp().equals(newStringValue))
                setHostIp(newStringValue);
		}
		//Further vars will be handled here
/*		else if 
			(evt.getPropertyName().equals(
      			DefaultController.ELEMENT_FONT_PROPERTY)) {
			Font f = (Font)evt.getNewValue();
			String fontString = f.getFontName() + " " + f.getSize();
			font.setText(fontString);
			currentFont = f;
		}
*/		
	}
	
	/**
	 * Sets local view stored hostIp
	 * @param hostIp
	 */
	private void setHostIp(String hostIp)
	{
		this.hostIp = hostIp; 
	}

	/**
	 * Gets local view stored hostIp
	 * @return hostIp
	 */
	private String getHostIp()
	{
		return this.hostIp; 
	}

	/**
	 * Sets the controller of this view. Must be used for view instances which would be load by the ViewStrategyFactory
	 * @param controller 
	 */
	@Override
	public void setController(AbstractController controller) {
		this.controller = (Controller)controller;
	}
}
