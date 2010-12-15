package main.java.ch.hszt.hs_2010.mdp.HGHM.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.AbstractModel;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

/**
 * This class provides base level functionality for each controller.
 * This includes the ability to register multiple models and views, 
 * propogating model change events to each of the views, 
 * and providing a utility funktion to broadcast model
 * property changes when necessary
 * @author david
 */
public abstract class AbstractController implements PropertyChangeListener {
	
    private ArrayList<IViewStrategy> registeredViews;
    private ArrayList<AbstractModel> registeredModels;
	
    /**
     * Default constructor
     * Initialize registring vars
     */
	public AbstractController() {
        registeredViews = new ArrayList<IViewStrategy>();
        registeredModels = new ArrayList<AbstractModel>();
	}
	
	/**
	 * Binds a model to this controller. 
	 * The controller listen for all model property changes of all registered
	 * model and propagate them on registred views.
	 * @param model
	 */
	public void addModel(AbstractModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

	/**
	 * Unbinds a model from this controller
	 * @param model
	 */
    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    /**
     * Binds a view to this controller. 
     * The controller lister for all view property changes of all registered
     * view and propagate changes to each view for consideration 
     * @param view
     */
    public void addView(IViewStrategy view) {
        registeredViews.add(view);
    }

    /**
     * Unbinds a view from this controller
     * @param view
     */
    public void removeView(IViewStrategy view) {
        registeredViews.remove(view);
    }

    /**
     * This method is used to implement the PropertyChangeListener interface. Any model
     * changes will be sent to this controller through the use of this method.
     * @param evt An object that describes the model's property change.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        for (IViewStrategy view: registeredViews) {
            view.modelPropertyChange(evt);
        }
    }


    /**
     * This is a convenience method that subclasses can call upon
     * to fire property changes back to the models. This method
     * uses reflection to inspect each of the model classes
     * to determine whether it is the owner of the property
     * in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName = The name of the property.
     * @param newValue = An object that represents the new value
     * of the property.
     */
    protected void setModelProperty(String propertyName, Object newValue) {

        for (AbstractModel model: registeredModels) {
            try {
                Method method = model.getClass().
                    getMethod("set"+propertyName, new Class[] {
                                                      newValue.getClass()
                                                  }
                             );
                method.invoke(model, newValue);

            } catch (Exception ex) {
                //  Handle exception.
            }
        }
    }

}
