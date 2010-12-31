package main.java.ch.hszt.hs_2010.mdp.HGHM;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.Model;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.ViewStrategyFactory;

public class RunHGHM {
	public static void main(String[] args) {	
		RunHGHM runHGHM = new RunHGHM();
		runHGHM.run();
	}
	
	private void run()
	{
		try {
			Model model = new Model();
			Controller controller = new Controller();
			IViewStrategy viewGui = ViewStrategyFactory.getGuiStrategy();
			IViewStrategy viewConsole = ViewStrategyFactory.getConsoleStrategy();
			viewGui.setController(controller);
			viewConsole.setController(controller);
			controller.addView(viewConsole);
			controller.addView(viewGui);
			controller.addModel(model);
			model.initDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
