package main.java.ch.hszt.hs_2010.mdp.HGHM.View;

import java.util.ArrayList;
import java.util.List;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.Console.ViewConsoleStrategy;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.GUI.ViewGuiStrategy;

public class ViewStrategyFactory {
	
	/** list holding all available view strategies */
	static List<IViewStrategy> strategies = new ArrayList<IViewStrategy>();
	
	/** a human readable description of all view strategies */
	static String description = "";
	
	static Controller controller; 
	
	static {
		controller = new Controller();
	}
	
	
	/** initial list view strategies available */
	static {
		addStrategy(ViewConsoleStrategy.class);
		addStrategy(ViewGuiStrategy.class);
	}
	
	public static AbstractController getController(){
		return controller;
	}
	
	/** @return strategy with given id */
	public static IViewStrategy getStrategy(int id) {
		return strategies.get(id);
	}
	
	/** 
	 * adds a new view strategy
	 * instantiates strategy and adds it to description
	 */
//	public static void addStrategy(Class classstrategy) {
//		try {
//			strategies.add((IViewStrategy) classstrategy.newInstance());
//			description = description + (strategies.size()-1) +": "
//				+classstrategy.getSimpleName()+"\n";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
	
	
	
	public static void addStrategy(Class clazz) {
		try {
			IViewStrategy tmpStrategy = (IViewStrategy) clazz.newInstance();
			tmpStrategy.setController(controller);
			strategies.add(tmpStrategy);
			description = description + (strategies.size()-1) +": "
				+clazz.getSimpleName()+"\n";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** @return human readable description of all view strategies */
	public static String getDescription() {
		return description;
		
	}
}
