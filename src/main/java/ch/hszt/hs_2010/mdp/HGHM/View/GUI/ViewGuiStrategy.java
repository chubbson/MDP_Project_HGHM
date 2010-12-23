package main.java.ch.hszt.hs_2010.mdp.HGHM.View.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.util.HashMap;

import javax.swing.*;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Common;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.AbstractController;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Controller.Controller;
import main.java.ch.hszt.hs_2010.mdp.HGHM.View.IViewStrategy;

/**
 * Gui view class which implements the interface IViewStrategy. 
 * This class is added in the ViewStrategyFactory. 
 * Hanldles the usability in the controller
 * @author david
 */
public class ViewGuiStrategy implements IViewStrategy{

	private JFrame frameMain;
	private JPanel pnlMain;
	private JScrollPane pnTraceField;
	private JTextField tfHostIp;
	private JLabel lblDesc;
	private JButton btnStartTrace;
	private JTextArea taTraceField;
	
	private Controller controller; 
	
	/**
	 * Default Constructor is used in the ViewStrategyFactory for adding to available view strategies
	 * Note: If an instance would be used by the ViewStrategyFactory, a controller should be set once. 
	 */
	public ViewGuiStrategy(){
	}
	
	/**
	 * This Constructor should be used if you would instantiate this class without the factory
	 * @param controller
	 */
	public ViewGuiStrategy(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Initialize Gui Components
	 */
	public void InitComponents(){
		frameMain = new JFrame(Common.APPLICATION_NAME);
		frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMain.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exit();
			}
		});
		createMenuBar();
		pnlMain = new JPanel();
		
		lblDesc = new JLabel();
		tfHostIp = new JTextField(20);
		btnStartTrace = new JButton();
		taTraceField = new JTextArea();
		
		
		pnlMain.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lblDesc.setText("IP:");
		tfHostIp.setText("0.0.0.0");
		btnStartTrace.setText("Traceroute starten");
		//taTraceField.setText(Common.DEFAULT_TRACEROUTE);
		
		pnlMain.add(lblDesc);
		pnlMain.add(tfHostIp);
		pnlMain.add(btnStartTrace);
		
		pnTraceField = new JScrollPane(taTraceField);
		pnTraceField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frameMain.add(BorderLayout.NORTH, pnlMain);
		frameMain.add(pnTraceField);
		frameMain.setSize(500, 500);
		frameMain.setResizable(false);
		
		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Determine the new location of the window
		int w1 = frameMain.getSize().width;
		int h1 = frameMain.getSize().height;
		int x = (dim.width - w1) / 2;
		int y = (dim.height - h1) / 2;

		// Move the window
		frameMain.setLocation(x, y);
		frameMain.setVisible(true);
		
		tfHostIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	tfHostIpActionPerformed(evt);
            }
        });
		tfHostIp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
            	tfHostIpFocusLost(evt);
            }
        });
		btnStartTrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnStartTraceActionPerformed(evt);
            }
		});
	}
	
	/**
	 * Sets local view stored hostIp
	 * @param hostIp
	 */
	private void setHostIp(String hostIp)
	{
		this.tfHostIp.setText(hostIp); 
	}

	/**
	 * Gets local view stored hostIp
	 * @return hostIp
	 */
	private String getHostIp()
	{
		return this.tfHostIp.getText();
	}
	
	/**
	 * shutting down called, 
	 * handle gui part of shutting down
	 */
	private void shutDown()
	{
		//Do nothing atm. 
		// Perhap clear and free some vars
	}
	
	/**
	 * Event Function, happens if ipField lost his focus
	 * @param evt
	 */
	private void tfHostIpFocusLost(java.awt.event.FocusEvent evt) {
        try {
            controller.changeElementHostIp(tfHostIp.getText());
        } catch (Exception e) {
            //  Handle exception ...... NOT!!
        }
    }

	/**
	 * Event Function, happens if an action perform on ipField
	 * @param evt
	 */
    private void tfHostIpActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.changeElementHostIp(tfHostIp.getText());
        } catch (Exception e) {
            //  Handle exception ...... NOT!!
        }
    }

	/**
	 * Event Function, happens if an action perform on ipField
	 * @param evt
	 */
    private void btnStartTraceActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.requestTraceRoute();
        } catch (Exception e) {
            //  Handle exception ...... NOT!!
        }
    }
	
    /**
     * Create the Menu at the top that contain some commands
     */
	private void createMenuBar() {
		JMenuBar jmbMain = new JMenuBar();
		frameMain.setJMenuBar(jmbMain);
		JMenu menuFile = new JMenu("Datei");
		jmbMain.add(menuFile);
		JMenuItem miNewTraceItem = new JMenuItem("Neuer Traceroute");
		menuFile.add(miNewTraceItem);
		JMenuItem miCloseItem = new JMenuItem("Beenden");
		menuFile.add(miCloseItem);
		miNewTraceItem.addActionListener(new NewTracerouteActionListener());
		miCloseItem.addActionListener(new ExitActionListener());
	}
	
    /**
     * The listener for new Trace rout command
     * @param ActionEvent from the gui
     */
	private class NewTracerouteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newTraceRoute();
		}
	}
	
    /**
     * The listener for the close command
     * @param ActionEvent from the gui
     */
	private class ExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			exit();
		}
	}
	
    /**
     * request a new TraceRoute
     * @throws Exception if a data file is open by the reader or writer it throws a Exception
     */
	public void newTraceRoute() {
		controller.requestTraceRoute();
	}
	
    /**
     * Close the program and delete all temporary data files
     * @throws Exception if a data file is open by the reader or writer it throws a Exception
     */
	public void exit() {
		Object[] options = { "Yes", "No" };
		int s = JOptionPane.showOptionDialog(frameMain, "Wirklich beenden?",
				"Beenden", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options);
		if (s == 0) {
			controller.requestQuit();
		}
	}

    /**
     * Called by the controller when it needs to pass along a property change
     * from a model. Note that the method checks each GUI parameter to determine
     * if the current value is already equal to the incoming value. If it is, 
     * the method will not reset the value. This is done to prevent looping from
     * occurring when a model property is reset.
     * @param evt The property change event
     */
	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				Controller.ELEMENT_HOSTIP_PROPERTY)) {
			String newStringValue = evt.getNewValue().toString();
			if (getHostIp() == null || !getHostIp().equals(newStringValue))
                setHostIp(newStringValue);
		}
		else if 
			(evt.getPropertyName().equals(
      			Controller.REQUEST_QUIT_PROPERTY)) {
			boolean newBoolValue = ((java.lang.Boolean)(evt.getNewValue()));
			if (newBoolValue)
			{
				shutDown();
			}
		}	
		else if 
			(evt.getPropertyName().equals(
	  			Controller.RESPONSE_TRACEROUTE_PROPERTY)) {
			String newTraceRouteResponse = evt.getNewValue().toString();
			if (newTraceRouteResponse != null)
			{
				showTraceResponse(newTraceRouteResponse);
			}
		}
		//Further vars will be handled here
		//else if ....
	}

	/**
	 * Show Traceroute Response
	 * @param traceRouteString
	 */
	private void showTraceResponse(String traceRouteString) {
		taTraceField.setText(traceRouteString);
	}

	/**
	 * Sets the controller of this view. Must be used for view instances which would be load by the ViewStrategyFactory
	 * @param controller 
	 */
	@Override
	public void setController(AbstractController controller) {
		this.controller = (Controller)controller;
		InitComponents();
	}

}