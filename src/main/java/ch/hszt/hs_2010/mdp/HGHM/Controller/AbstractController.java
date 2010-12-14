package main.java.ch.hszt.hs_2010.mdp.HGHM.Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.AbstractModel;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

public abstract class AbstractController implements PropertyChangeListener {
	
    private ArrayList<IViewStrategy> registeredViews;
    private ArrayList<AbstractModel> registeredModels;
	
	public AbstractController() {
        registeredViews = new ArrayList<IViewStrategy>();
        registeredModels = new ArrayList<AbstractModel>();
	}
	
	public void addModel(AbstractModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    public void addView(IViewStrategy view) {
        registeredViews.add(view);
    }

    public void removeView(IViewStrategy view) {
        registeredViews.remove(view);
    }

    public void propertyChange(PropertyChangeEvent evt) {

		System.out.println("du bist im AbstractController.jav");
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
