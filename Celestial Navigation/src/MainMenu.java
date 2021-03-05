import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class MainMenu {

	private JFrame frmCelestialNavigation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmCelestialNavigation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCelestialNavigation = new JFrame();
		frmCelestialNavigation.setTitle("Celestial Navigation");
		frmCelestialNavigation.setSize(600,400);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmCelestialNavigation.setJMenuBar(menuBar);
		
		JMenu mnLopCalculation = new JMenu("LOP Calculations");
		menuBar.add(mnLopCalculation);
		
		JMenuItem mntmSun = new JMenuItem("Sun");
		mntmSun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SunCalculation();
			}
		});
		mnLopCalculation.add(mntmSun);
		
		JSeparator separator = new JSeparator();
		mnLopCalculation.add(separator);
		
		JMenuItem mntmStar = new JMenuItem("Star");
		mnLopCalculation.add(mntmStar);
		
		JSeparator separator_1 = new JSeparator();
		mnLopCalculation.add(separator_1);
		
		JMenuItem mntmPlanet = new JMenuItem("Planet");
		mnLopCalculation.add(mntmPlanet);
		
		JSeparator separator_2 = new JSeparator();
		mnLopCalculation.add(separator_2);
		
		JMenuItem mntmMoon = new JMenuItem("Moon");
		mnLopCalculation.add(mntmMoon);
		
		JMenu mnMeridianAltitude = new JMenu("Meridian Altitude");
		menuBar.add(mnMeridianAltitude);
		
		JMenu mnStarFinder = new JMenu("Star Finder");
		menuBar.add(mnStarFinder);
	}

}
