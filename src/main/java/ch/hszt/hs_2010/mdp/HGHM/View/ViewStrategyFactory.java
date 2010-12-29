package main.java.ch.hszt.hs_2010.mdp.HGHM.View;

import java.util.ArrayList;
import java.util.List;

import main.java.ch.hszt.hs_2010.mdp.HGHM.View.Console.ViewConsoleStrategy;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.GUI.ViewGuiStrategy;

/**
 * View Strategy Factory, this class contains all available view which could be setup with this factory class 
 * @author David Hauri
 *
 */
public class ViewStrategyFactory {
	
	/** list holding all available view strategies */
	static List<IViewStrategy> strategies = new ArrayList<IViewStrategy>();
	
	/** description of all view strategies */
	static String description = "";
	
	/** initial list view strategies available */
	static {
		addStrategy(ViewConsoleStrategy.class);
		addStrategy(ViewGuiStrategy.class);
	}
	
	/** @return strategy with given id */
	public static IViewStrategy getStrategy(int id) {
		return strategies.get(id);
	}
	
	public static IViewStrategy getConsoleStrategy()
	{
		return strategies.get(0);
	}
	
	public static IViewStrategy getGuiStrategy()
	{
		return strategies.get(1);
	}
	
	/** 
	 * adds a new view strategy
	 * instantiates strategy and adds it to description
	 */
	public static void addStrategy(Class clazz) {
		try {
			IViewStrategy tmpViewStrategy = (IViewStrategy) clazz.newInstance();
			strategies.add(tmpViewStrategy);
			description = description + (strategies.size()-1) +": "
				+clazz.getSimpleName()+"\n";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * @return human readable description of all view strategies
	 */
	public static String getDescription() {
		return description;
	}
}
