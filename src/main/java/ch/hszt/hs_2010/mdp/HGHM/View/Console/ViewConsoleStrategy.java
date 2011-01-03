package main.java.ch.hszt.hs_2010.mdp.HGHM.View.Console;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Common;
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
		System.out.println(Common.APPLICATION_NAME);
	}
	
	/**
	 * This Constructor should be used if you would instantiate this class without the factory
	 * @param controller
	 */
	public ViewConsoleStrategy(Controller controller) {
		this();
		this.controller = controller;
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
		else if 
		(evt.getPropertyName().equals(
  			Controller.REQUEST_QUIT_PROPERTY)) {
			boolean newBoolValue = ((java.lang.Boolean)(evt.getNewValue()));
			if (newBoolValue)
			{
				showShutDown();
			}
		}
		else if 
		(evt.getPropertyName().equals(
  			Controller.REQUEST_TRACEROUTE_PROPERTY)) {
			boolean newBoolValue = ((java.lang.Boolean)(evt.getNewValue()));
			if (newBoolValue)
			{
				showStartTrace();
			}
		}
		else if 
		(evt.getPropertyName().equals(
  			Controller.RESPONSE_TRACEROUTE_PROPERTY)) {
			String newTraceRouteResponse = evt.getNewValue().toString();
			if (newTraceRouteResponse != null)
			{
				showTraceResponse();
			}
		}
		else if 
		(evt.getPropertyName().equals(
  			Controller.RESPONSE_MATCHIP_PROPERTY)) {
//			String newTraceRouteResponse = evt.getNewValue().toString();
//			if (newTraceRouteResponse != null)
//			{
//				showTraceResponse();
//			}
		}
		else if 
		(evt.getPropertyName().equals(
  			Controller.REQUEST_ANALYZETRACE_PROPERTY)) {
			boolean newTraceAnalyzeRequest = ((java.lang.Boolean)(evt.getNewValue()));
			if (newTraceAnalyzeRequest)
			{
				showAnalyzeTrace();
			}
		}
		else if 
		(evt.getPropertyName().equals(
  			Controller.RESPONSE_ANALYZETRACE_PROPERTY)) {
			String newTraceAnalyzeResponse = evt.getNewValue().toString();
			if (newTraceAnalyzeResponse != null)
			{
				showAnalyzeTraceResponse(newTraceAnalyzeResponse);
			}
		}
	}
	
	/**
	 * Shows Traceroute response in console
	 * @param newTraceAnalyzeResponse
	 */
	private void showAnalyzeTraceResponse(String newTraceAnalyzeResponse) {
		System.out.println("Tracerout analyze result:");
		System.out.println(newTraceAnalyzeResponse);
		System.out.println("Finished analyzing tracerout");
	}

	/**
	 * Shows analyze trace in console
	 */
	private void showAnalyzeTrace() {
		System.out.println("Start analyzing tracerout");
	}

	/**
	 * Shows trace route response
	 */
	private void showTraceResponse() {
		System.out.println("Trace route sequence finished");
	}

	/**
	 * Shows starting trace sequence
	 */
	private void showStartTrace() {
		System.out.println("Starting trace route sequence ...");
	}

	/**
	 * Shows shutting down request in console
	 */
	private void showShutDown() {
		System.out.println(Common.APPLICATION_NAME + " is shutting down ...");
	}

	/**
	 * Sets local view stored hostIp
	 * @param hostIp
	 */
	private void setHostIp(String hostIp)
	{
		this.hostIp = hostIp; 
		System.out.println("Host IP: " + hostIp);
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
