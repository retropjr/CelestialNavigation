import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class SunSightDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLocalTimeOfSight;
	private JTextField textFieldTimeOfSightUTC;
	private JSpinner spinnerLocalTimeZone;
	private JSpinner spinnerTemperature;
	private JSpinner spinnerPressure;
	private JLabel lblObserverHeight;
	private JSpinner spinnerObserverHeight;
	private JLabel lblIndexError;
	private JTextField textFieldSextantIndexError;
	private JTextField textFieldGHA0;
	private JTextField textFieldGHA1;
	private JTextField textFieldDEC0;
	private JTextField textFieldDEC1;
	private JTextField textFieldDRLat;
	private JTextField textFieldDRLon;
	private JTextField textFieldSDSun;
	private JTextField textFieldHeightOfSun;
	private JTextField textFieldPlot;
	

	private Sight sight; 
	private Sun sun;
	private DRPosition DRPosn;
	private SunCalculation sunCalculation;
	private JButton btnMainMenu;
	
	

	/**
	 * Create the frame.
	 */
	public SunSightDetails() {
		setResizable(false);
		setTitle("Sun Sight Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 490);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblLocalTimeOfSight = new JLabel("Enter local time of sight:");
		lblLocalTimeOfSight.setBounds(20, 10, 300, 20);
		contentPane.add(lblLocalTimeOfSight);
		
		textFieldLocalTimeOfSight = new JTextField();
		textFieldLocalTimeOfSight.setBounds(320, 10, 150, 20);
		contentPane.add(textFieldLocalTimeOfSight);
		textFieldLocalTimeOfSight.setColumns(10);
		
		JLabel lblLocalTimeZone = new JLabel("Enter local time zone:");
		lblLocalTimeZone.setBounds(20, 35, 300, 20);
		contentPane.add(lblLocalTimeZone);
		
		spinnerLocalTimeZone = new JSpinner();
		spinnerLocalTimeZone.setModel(new SpinnerNumberModel(12, -13, 13, 1));
		spinnerLocalTimeZone.setBounds(320, 35, 60, 20);
		contentPane.add(spinnerLocalTimeZone);
		
		JLabel lblTemperature = new JLabel("Enter temperature in celsius:");
		lblTemperature.setBounds(20, 60, 300, 20);
		contentPane.add(lblTemperature);
		
		spinnerTemperature = new JSpinner();
		spinnerTemperature.setModel(new SpinnerNumberModel(15,-20, 50, 1));
		spinnerTemperature.setBounds(320, 60, 60, 20);
		contentPane.add(spinnerTemperature);
		
		JButton btnCalculateUTC = new JButton("Calculate UTC of sight");
		btnCalculateUTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sight = new Sight(getLocalTimeOfSight(), getTimeZone(), getTemperature(), getPressure(), getHt());
				textFieldTimeOfSightUTC.setText(sight.getUTCOfSightString());
			}
		});
		
		JLabel lblPressure = new JLabel("Enter atmospheric pressure in hPa:");
		lblPressure.setBounds(20, 85, 300, 20);
		contentPane.add(lblPressure);
		
		spinnerPressure = new JSpinner();
		spinnerPressure.setModel(new SpinnerNumberModel(1013, -940, 1060, 1));
		spinnerPressure.setBounds(320, 85, 60, 20);
		contentPane.add(spinnerPressure);
		
		lblObserverHeight = new JLabel("Enter observer height in metres to 1 DP:");
		lblObserverHeight.setBounds(20, 110, 300, 20);
		contentPane.add(lblObserverHeight);
		
		spinnerObserverHeight = new JSpinner();
		
		spinnerObserverHeight.setModel(new SpinnerNumberModel(2.0, 0.0, 100.0, 1.0));
		spinnerObserverHeight.setBounds(320, 110, 60, 20);
		contentPane.add(spinnerObserverHeight);
		
		lblIndexError = new JLabel("Enter sextant index error:");
		lblIndexError.setBounds(20, 135, 300, 20);
		contentPane.add(lblIndexError);
		
		textFieldSextantIndexError = new JTextField();
		textFieldSextantIndexError.setToolTipText("+DD MM.M (- on arc)");
		textFieldSextantIndexError.setBounds(320, 135, 150, 20);
		contentPane.add(textFieldSextantIndexError);
		textFieldSextantIndexError.setColumns(10);
		btnCalculateUTC.setBounds(20, 160, 450, 20);
		contentPane.add(btnCalculateUTC);
		
		
		JLabel lblTimeOfSightUTC = new JLabel("Time of sight UTC:");
		lblTimeOfSightUTC.setBounds(20, 185, 300, 20);
		contentPane.add(lblTimeOfSightUTC);
		
		textFieldTimeOfSightUTC = new JTextField();
		textFieldTimeOfSightUTC.setBounds(320, 185, 150, 20);
		contentPane.add(textFieldTimeOfSightUTC);
		textFieldTimeOfSightUTC.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 210, 450, 2);
		contentPane.add(separator);
		
		JLabel lblGHA0 = new JLabel("GHA0:");
		lblGHA0.setToolTipText("");
		lblGHA0.setBounds(20, 220, 100, 20);
		contentPane.add(lblGHA0);
		
		textFieldGHA0 = new JTextField();
		textFieldGHA0.setToolTipText("DDD MM.M");
		textFieldGHA0.setBounds(140, 220, 80, 20);
		contentPane.add(textFieldGHA0);
		textFieldGHA0.setColumns(10);
		
		JLabel lblGHA1 = new JLabel("GHA1:");
		lblGHA1.setBounds(280, 220, 100, 20);
		contentPane.add(lblGHA1);
		
		textFieldGHA1 = new JTextField();
		textFieldGHA1.setToolTipText("DDD MM.M");
		textFieldGHA1.setBounds(390, 220, 80, 20);
		contentPane.add(textFieldGHA1);
		textFieldGHA1.setColumns(10);
		
		JLabel lblDEC0 = new JLabel("DEC0:");
		lblDEC0.setBounds(20, 245, 100, 20);
		contentPane.add(lblDEC0);
		
		textFieldDEC0 = new JTextField();
		textFieldDEC0.setToolTipText("(-S) +DD MM.M");
		textFieldDEC0.setBounds(140, 245, 80, 20);
		contentPane.add(textFieldDEC0);
		textFieldDEC0.setColumns(10);
		
		JLabel lblDEC1 = new JLabel("DEC1:");
		lblDEC1.setToolTipText("");
		lblDEC1.setBounds(280, 245, 80, 20);
		contentPane.add(lblDEC1);
		
		textFieldDEC1 = new JTextField();
		textFieldDEC1.setToolTipText("(-S) +DD MM.M");
		textFieldDEC1.setText("");
		textFieldDEC1.setBounds(390, 245, 80, 20);
		contentPane.add(textFieldDEC1);
		textFieldDEC1.setColumns(10);
		
		JLabel lblDRLat = new JLabel("DR Latitude:");
		lblDRLat.setBounds(20, 270, 100, 20);
		contentPane.add(lblDRLat);
		
		textFieldDRLat = new JTextField();
		textFieldDRLat.setToolTipText("(-S) +DD MM.M");
		textFieldDRLat.setBounds(140, 270, 80, 20);
		contentPane.add(textFieldDRLat);
		textFieldDRLat.setColumns(10);
		
		JLabel lblDRLong = new JLabel("DR Longitude:");
		lblDRLong.setBounds(280, 270, 100, 20);
		contentPane.add(lblDRLong);
		
		textFieldDRLon = new JTextField();
		textFieldDRLon.setToolTipText("(-W) +DDD MM.M");
		textFieldDRLon.setBounds(390, 270, 80, 20);
		contentPane.add(textFieldDRLon);
		textFieldDRLon.setColumns(10);
		
		JLabel lblSDSun = new JLabel("SD Sun:");
		lblSDSun.setBounds(20, 295, 100, 20);
		contentPane.add(lblSDSun);
		
		textFieldSDSun = new JTextField();
		textFieldSDSun.setToolTipText("(-upper limb) MM.M");
		textFieldSDSun.setBounds(140, 295, 80, 20);
		contentPane.add(textFieldSDSun);
		textFieldSDSun.setColumns(10);
		
		JLabel lblSunHeight = new JLabel("Height:");
		lblSunHeight.setBounds(280, 295, 100, 20);
		contentPane.add(lblSunHeight);
		
		textFieldHeightOfSun = new JTextField();
		textFieldHeightOfSun.setToolTipText("Height of Sun DD MM.M");
		textFieldHeightOfSun.setBounds(390, 295, 80, 20);
		contentPane.add(textFieldHeightOfSun);
		textFieldHeightOfSun.setColumns(10);
		
		JButton btnCalculateLOP = new JButton("Calculate Line Of Position");
		btnCalculateLOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sight = new Sight(getLocalTimeOfSight(), getTimeZone(), getTemperature(), getPressure(), getHt(), getIndexError(), getSextantAltitude());
				sun = new Sun(getGHA0(), getGHA1(), getDEC0(), getDEC1(), getSD());
				DRPosn = new DRPosition(getDRLat(), getDRLon());
				sunCalculation = new SunCalculation(sight, sun, DRPosn);
				textFieldPlot.setText(sunCalculation.getPlot());
			}
		});
		btnCalculateLOP.setBounds(20, 320, 450, 20);
		contentPane.add(btnCalculateLOP);
		
		textFieldPlot = new JTextField();
		textFieldPlot.setBounds(160, 345, 200, 20);
		contentPane.add(textFieldPlot);
		textFieldPlot.setColumns(10);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnMainMenu.setBounds(353, 377, 117, 25);
		contentPane.add(btnMainMenu);
		
	}
	
	//getter methods
	public String getLocalTimeOfSight() {
		return textFieldLocalTimeOfSight.getText();
	}
	
	public int getTimeZone() {
		int lTZ = (int) spinnerLocalTimeZone.getValue();
		return lTZ;
	}
	
	public int getTemperature() {
		int temp = (int) spinnerTemperature.getValue();
		return temp;
	}
	
	public int getPressure() {
		int press = (int) spinnerPressure.getValue();
		return press;
	}
	
	public double getHt() {
		double height = (double) spinnerObserverHeight.getValue();
		return height;
	}
		
	public String getGHA0() {
		String GHA0 = textFieldGHA0.getText();
		return GHA0;
	}
	
	public String getGHA1() {
		String GHA1 = textFieldGHA1.getText();
		return GHA1;
	}
	
	public String getDEC0() {
		String DEC0 = textFieldDEC0.getText();
		return DEC0;
	}
	
	public String getDEC1() {
		String DEC1 = textFieldDEC1.getText();
		return DEC1;
	}
	
	public String getSD() {
		String SD = textFieldSDSun.getText();
		return SD;
	}
	
	public String getDRLat() {
		String lat = textFieldDRLat.getText();
		return lat;
	}
	
	public String getDRLon() {
		String lon = textFieldDRLon.getText();
		return lon;
	}
	
	public String getIndexError() {
		String error = textFieldSextantIndexError.getText();
		return error;
	}
	
	public String getSextantAltitude() {
		String alt = textFieldHeightOfSun.getText();
		return alt;
	}
}
