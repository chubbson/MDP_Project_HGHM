package main.java.ch.hszt.hs_2010.mdp.HGHM.View;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;

public interface IViewStrategy {
	/** shows the submitted string */
	public void showIP(String s);
	
	public void setController(AbstractController controller);
	
	public void modelPropertyChange(final PropertyChangeEvent evt); 
}
