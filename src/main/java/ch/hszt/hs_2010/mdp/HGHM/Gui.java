package ch.hszt.hs_2010.mdp.HGHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This class is used to display the main gui
 * 
 * @author Ramon Gamma
 */
public class Gui {

	private JFrame frame;
	private JPanel panel;
	private JScrollPane panel2;
	private JTextField ipField;
	private JLabel ipDesc;
	private JButton startTrace;
	private JTextArea traceOutput;
	
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.create(500,500);
	}
	
    /**
     * Initialize the gui
     * @param
     */
	public Gui() {
	}

    /**
     * This Method starts the gui and set the position in center of the screen
     * it initialize the fields with some data
     * @param w define the width of the gui
     * @param h define the height of the gui
     */
	public void create(int w, int h) {

		frame = new JFrame("Traceroute Analyzer");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				exit();
			}
		});
		createMenuBar();
		panel = new JPanel();
		
		ipDesc = new JLabel();
		ipField = new JTextField(20);
		startTrace = new JButton();
		traceOutput = new JTextArea();
		
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		ipDesc.setText("IP:");
		ipField.setText("0.0.0.0");
		startTrace.setText("Traceroute starten");
		traceOutput.setText("traceroute to oas.oagr.ch (217.26.54.155), 64 hops max, 52 byte packets\n"+
				"1  10.0.2.254 (10.0.2.254)  1.305 ms  0.932 ms  0.996 ms\n"+
				"2  * * *\n" + 
				"3  217-168-60-117.static.cablecom.ch (217.168.60.117)  14.055 ms  10.465 ms  11.452 ms\n"+
				"4  * 172.31.208.73 (172.31.208.73)  18.180 ms  12.778 ms\n"+
				"5  213.46.171.66 (213.46.171.66)  15.087 ms  11.027 ms  22.585 ms");
		
		panel.add(ipDesc);
		panel.add(ipField);
		panel.add(startTrace);
		
		panel2 = new JScrollPane(traceOutput);
		panel2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		panel2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.add(BorderLayout.NORTH, panel);
		frame.add(panel2);
		frame.setSize(w, h);
		frame.setResizable(false);
		
		// Get the size of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Determine the new location of the window
		int w1 = frame.getSize().width;
		int h1 = frame.getSize().height;
		int x = (dim.width - w1) / 2;
		int y = (dim.height - h1) / 2;

		// Move the window
		frame.setLocation(x, y);
		frame.setVisible(true);

	}

    /**
     * Close the program and delete all temporary data files
     * @throws Exception if a data file is open by the reader or writer it throws a Exception
     */
	public void exit() {
		Object[] options = { "Yes", "No" };
		int s = JOptionPane.showOptionDialog(frame, "Wirklich beenden?",
				"Beenden", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options);
		if (s == 0) {
			System.exit(0);
		}
	}

    /**
     * Create the Menu at the top that contain some commands
     */
	private void createMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();
		frame.setJMenuBar(jMenuBar);
		JMenu fileMenu = new JMenu("Datei");
		jMenuBar.add(fileMenu);
		JMenuItem newTraceItem = new JMenuItem("New Traceroute");
		fileMenu.add(newTraceItem);
		JMenuItem closeItem = new JMenuItem("Beenden");
		fileMenu.add(closeItem);
		closeItem.addActionListener(new ExitActionListener());
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

}
