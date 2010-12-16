package main.java.ch.hszt.hs_2010.mdp.HGHM.View.GUI;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

/**
 * Gui view class which implements the interface IViewStrategy. 
 * This class is added in the ViewStrategyFactory. 
 * Hanldles the usability in the controller
 * @author david
 */
public class ViewGuiStrategy implements IViewStrategy{

	private Controller controller; 
	
	/**
	 * Default Constructor is used in the ViewStrategyFactory for adding to available view strategies
	 * Note: If an instance would be used by the ViewStrategyFactory, a controller should be set once. 
	 */
	public ViewGuiStrategy(){
	}
	
	/**
	 * This Constructor should be used if you would instantiate this class without the factory
	 * @param controller
	 */
	public ViewGuiStrategy(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * This function shows current HostIp
	 */
	@Override
	public void showIP() {
		// TODO Auto-generated method stub
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
		// TODO look @ ViewConsoleStrategy
	}

	/**
	 * Sets the controller of this view. Must be used for view instances which would be load by the ViewStrategyFactory
	 * @param controller 
	 */
	@Override
	public void setController(AbstractController controller) {
		// TODO Auto-generated method stub
	}

}