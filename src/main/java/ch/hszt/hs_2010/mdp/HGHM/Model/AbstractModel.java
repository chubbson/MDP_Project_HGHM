package main.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class provides base level functionality for all models, including a 
 * support for a property change mechanism (using the PropertyChangeSupport class),
 * as well as a convenience method that other objects can use to reset model state.
 * @author david
 */
public abstract class AbstractModel
{
    /**
     * Convenience class that allow others to observe changes to the model properties
     */
    protected PropertyChangeSupport propertyChangeSupport;

    /**
     * Default constructor. Instantiates the PropertyChangeSupport class.
     */
    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    /**
     * Adds a property change listener to the observer list.
     * @param listener The property change listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Removes a property change listener from the observer list.
     * @param listener The property change listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Fires an event to all registered listeners informing them that a property in
     * this model has changed.
     * @param propertyName The name of the property
     * @param oldValue The previous value of the property before the change
     * @param newValue The new property value after the change
     */
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}