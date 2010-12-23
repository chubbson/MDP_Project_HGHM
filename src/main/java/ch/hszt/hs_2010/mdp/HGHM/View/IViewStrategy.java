package main.java.ch.hszt.hs_2010.mdp.HGHM.View;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;

/**
 * This Interface cointains main functions which should implemented by every view
 * @author David Hauri
 */

public interface IViewStrategy {
	
	/**
	 * Each view should have this function to add a controller to the view
	 * @param controller Controller to set on this view
	 */
	public void setController(AbstractController controller);
	
    /**
     * Called by the controller when it needs to pass along a property change 
     * from a model.
     *
     * @param evt The property change event from the model
     */
	public void modelPropertyChange(final PropertyChangeEvent evt); 
}
