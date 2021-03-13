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
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class MeridianAltitudeDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLocalTimeOfSight;
	private JSpinner spinnerLocalTimeZone;
	private JSpinner spinnerTemperature;
	private JSpinner spinnerPressure;
	private JLabel lblObserverHeight;
	private JSpinner spinnerObserverHeight;
	private JLabel lblIndexError;
	private JTextField textFieldSextantIndexError;
	private JTextField textFieldGHA0;
	private JTextField textFieldDEC1;
	private JTextField textFieldDRLon;
	private JTextField textFieldSDSun;
	private JTextField textFieldHeightOfSun;
	private JTextField textFieldPlot;
	

	private Sight sight; 
	private Sun sun;
	private DRPosition DRPosn;
	private SunCalculation sunCalculation;
	private JButton btnMainMenu;
	private JTextField textFieldPassageUTC;
	private JTextField textFieldPassageLocal;
	private JLabel lblUTC;
	private JLabel lblLocal;
	
	

	/**
	 * Create the frame.
	 */
	public MeridianAltitudeDetails() {
		setResizable(false);
		setTitle("Meridian Altitude Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 502);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblAlmanacTimeOfPassage = new JLabel("Enter Almanac time of meridian passage:");
		lblAlmanacTimeOfPassage.setBounds(30, 32, 300, 20);
		contentPane.add(lblAlmanacTimeOfPassage);
		
		textFieldLocalTimeOfSight = new JTextField();
		textFieldLocalTimeOfSight.setBounds(320, 32, 150, 20);
		contentPane.add(textFieldLocalTimeOfSight);
		textFieldLocalTimeOfSight.setColumns(10);
		
		JLabel lblLocalTimeZone = new JLabel("Enter local time zone:");
		lblLocalTimeZone.setBounds(30, 51, 300, 20);
		contentPane.add(lblLocalTimeZone);
		
		spinnerLocalTimeZone = new JSpinner();
		spinnerLocalTimeZone.setModel(new SpinnerNumberModel(12, -13, 13, 1));
		spinnerLocalTimeZone.setBounds(320, 52, 60, 20);
		contentPane.add(spinnerLocalTimeZone);
		
		
		
		JButton btnCalculateUTC = new JButton("Calculate meridian passage UTC and Local:");
		btnCalculateUTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sight = new Sight(getLocalTimeOfSight(), getTimeZone(), getTemperature(), getPressure(), getHt());
				textFieldTimeOfSightUTC.setText(sight.getUTCOfSightString());
			}
		});
		
		
		JLabel lblTemperature = new JLabel("Enter temperature in celsius:");
		lblTemperature.setBounds(30, 158, 300, 20);
		contentPane.add(lblTemperature);
		
		spinnerTemperature = new JSpinner();
		spinnerTemperature.setModel(new SpinnerNumberModel(15,-20, 50, 1));
		spinnerTemperature.setBounds(340, 149, 60, 20);
		contentPane.add(spinnerTemperature);
		
		JLabel lblPressure = new JLabel("Enter atmospheric pressure in hPa:");
		lblPressure.setBounds(30, 180, 300, 20);
		contentPane.add(lblPressure);
		
		spinnerPressure = new JSpinner();
		spinnerPressure.setModel(new SpinnerNumberModel(1013, -940, 1060, 1));
		spinnerPressure.setBounds(340, 181, 60, 20);
		contentPane.add(spinnerPressure);
		
		lblObserverHeight = new JLabel("Enter observer height in metres to 1 DP:");
		lblObserverHeight.setBounds(30, 201, 300, 20);
		contentPane.add(lblObserverHeight);
		
		spinnerObserverHeight = new JSpinner();
		
		spinnerObserverHeight.setModel(new SpinnerNumberModel(2.0, 0.0, 100.0, 1.0));
		spinnerObserverHeight.setBounds(340, 202, 60, 20);
		contentPane.add(spinnerObserverHeight);
		
		lblIndexError = new JLabel("Enter sextant index error:");
		lblIndexError.setBounds(30, 223, 300, 20);
		contentPane.add(lblIndexError);
		
		textFieldSextantIndexError = new JTextField();
		textFieldSextantIndexError.setToolTipText("+DD MM.M (- on arc)");
		textFieldSextantIndexError.setBounds(320, 224, 150, 20);
		contentPane.add(textFieldSextantIndexError);
		textFieldSextantIndexError.setColumns(10);
		btnCalculateUTC.setBounds(12, 83, 437, 20);
		contentPane.add(btnCalculateUTC);
		
		textFieldGHA0 = new JTextField();
		textFieldGHA0.setToolTipText("DDD MM.M");
		textFieldGHA0.setBounds(138, 352, 80, 20);
		contentPane.add(textFieldGHA0);
		textFieldGHA0.setColumns(10);
		
		JLabel lblDEC0 = new JLabel("DEC0:");
		lblDEC0.setBounds(20, 319, 100, 20);
		contentPane.add(lblDEC0);
		
		JLabel lblDEC1 = new JLabel("DEC1:");
		lblDEC1.setToolTipText("");
		lblDEC1.setBounds(256, 319, 80, 20);
		contentPane.add(lblDEC1);
		
		textFieldDEC1 = new JTextField();
		textFieldDEC1.setToolTipText("(-S) +DD MM.M");
		textFieldDEC1.setText("");
		textFieldDEC1.setBounds(390, 320, 80, 20);
		contentPane.add(textFieldDEC1);
		textFieldDEC1.setColumns(10);
		
		JLabel lblDRLong = new JLabel("DR Longitude:");
		lblDRLong.setBounds(33, 10, 100, 20);
		contentPane.add(lblDRLong);
		
		textFieldDRLon = new JTextField();
		textFieldDRLon.setToolTipText("(-W) +DDD MM.M");
		textFieldDRLon.setBounds(320, 10, 80, 20);
		contentPane.add(textFieldDRLon);
		textFieldDRLon.setColumns(10);
		
		JLabel lblSDSun = new JLabel("SD Sun:");
		lblSDSun.setBounds(20, 352, 100, 19);
		contentPane.add(lblSDSun);
		
		textFieldSDSun = new JTextField();
		textFieldSDSun.setToolTipText("(-upper limb) MM.M");
		textFieldSDSun.setBounds(138, 320, 80, 20);
		contentPane.add(textFieldSDSun);
		textFieldSDSun.setColumns(10);
		
		JLabel lblSunHeight = new JLabel("Height:");
		lblSunHeight.setBounds(30, 249, 100, 20);
		contentPane.add(lblSunHeight);
		
		textFieldHeightOfSun = new JTextField();
		textFieldHeightOfSun.setToolTipText("Height of Sun DD MM.M");
		textFieldHeightOfSun.setBounds(138, 255, 80, 15);
		contentPane.add(textFieldHeightOfSun);
		textFieldHeightOfSun.setColumns(10);
		
		JButton btnCalculateLOP = new JButton("Calculate Latitude");
		btnCalculateLOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sight = new Sight(getLocalTimeOfSight(), getTimeZone(), getTemperature(), getPressure(), getHt(), getIndexError(), getSextantAltitude());
				sun = new Sun(getGHA0(), getGHA1(), getDEC0(), getDEC1(), getSD());
				DRPosn = new DRPosition(getDRLat(), getDRLon());
				sunCalculation = new SunCalculation(sight, sun, DRPosn);
				textFieldPlot.setText(sunCalculation.getPlot());
			}
		});
		btnCalculateLOP.setBounds(20, 383, 450, 20);
		contentPane.add(btnCalculateLOP);
		
		textFieldPlot = new JTextField();
		textFieldPlot.setBounds(180, 415, 200, 20);
		contentPane.add(textFieldPlot);
		textFieldPlot.setColumns(10);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnMainMenu.setBounds(393, 440, 117, 25);
		contentPane.add(btnMainMenu);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("North");
		chckbxNewCheckBox.setBounds(191, 277, 129, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("South");
		chckbxNewCheckBox_1.setBounds(320, 277, 129, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel = new JLabel("Bearing of body:");
		lblNewLabel.setBounds(20, 281, 175, 15);
		contentPane.add(lblNewLabel);
		
		textFieldPassageUTC = new JTextField();
		textFieldPassageUTC.setBounds(116, 109, 114, 19);
		contentPane.add(textFieldPassageUTC);
		textFieldPassageUTC.setColumns(10);
		
		textFieldPassageLocal = new JTextField();
		textFieldPassageLocal.setBounds(340, 109, 114, 19);
		contentPane.add(textFieldPassageLocal);
		textFieldPassageLocal.setColumns(10);
		
		lblUTC = new JLabel("UTC:");
		lblUTC.setBounds(30, 105, 70, 15);
		contentPane.add(lblUTC);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(260, 111, 70, 15);
		contentPane.add(lblLocal);
		
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
