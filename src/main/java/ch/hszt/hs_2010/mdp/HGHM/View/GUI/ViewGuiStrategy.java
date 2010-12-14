package main.java.ch.hszt.hs_2010.mdp.HGHM.View.GUI;

import java.beans.PropertyChangeEvent;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

public class ViewGuiStrategy implements IViewStrategy{

	private Controller controller; 
	
	public ViewGuiStrategy(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void showIP(String s) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setController(AbstractController controller) {
		// TODO Auto-generated method stub
	}

}