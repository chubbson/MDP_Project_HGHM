package main.java.ch.hszt.hs_2010.mdp.HGHM.View.Console;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

public class ViewConsoleStrategy implements IViewStrategy{

	private Controller controller; 
	
	private String hostIp;
	
	public ViewConsoleStrategy(){
	}
	
	public ViewConsoleStrategy(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void showIP(String s) {
		System.out.println(getHostIp());
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				Controller.ELEMENT_HOSTIP_PROPERTY)) {
			String newStringValue = evt.getNewValue().toString();
			if (!getHostIp().equals(newStringValue))
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
	
	private void setHostIp(String hostIp)
	{
		this.hostIp = hostIp; 
		showIP(getHostIp());
	}

	private String getHostIp()
	{
		return this.hostIp; 
	}

	@Override
	public void setController(AbstractController controller) {
		this.controller = (Controller)controller;
	}
}
