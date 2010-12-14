package main.java.ch.hszt.hs_2010.mdp.HGHM;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
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
			showInfo();
			int strategyNo = getStrategyNo();
			AbstractController controller = ViewStrategyFactory.getController();
			IViewStrategy v = ViewStrategyFactory.getStrategy(strategyNo);
			controller.addView(v);
			controller.addModel(new Model());
			v.showIP("sdf");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/** retrieves a strategy no from the user */
	private int getStrategyNo() throws IOException {
		System.out.print("Choose view #: ");
		String s = readLn();
		return Integer.parseInt(s);
	}

	/** reads a line from stdin */
	private String readLn() throws IOException {
		 InputStreamReader input = new InputStreamReader(System.in);
		 BufferedReader reader = new BufferedReader(input);
	     return reader.readLine(); 
	}
	
	/** 
	 * shows program info an available options 
	 */
	private void showInfo() {
		System.out.println("\n***** Available views *******\n");
		System.out.println(ViewStrategyFactory.getDescription());		
	}
}
