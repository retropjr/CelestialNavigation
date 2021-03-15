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
import javax.swing.JCheckBox;

public class MeridianAltitudeDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAlmanacTimeOfPassage;
	private JSpinner spinnerLocalTimeZone;
	private JSpinner spinnerTemperature;
	private JSpinner spinnerPressure;
	private JLabel lblObserverHeight;
	private JSpinner spinnerObserverHeight;
	private JLabel lblIndexError;
	private JTextField textFieldSextantIndexError;
	private JTextField textFieldDEC0;
	private JTextField textFieldDEC1;
	private JTextField textFieldDRLon;
	private JTextField textFieldSDSun;
	private JTextField textFieldHeightOfBody;
	private JTextField textFieldLatitude;
	private JCheckBox chckbxNorth;
	private JCheckBox chckbxSouth;
	

	
	private MeridianAltitudeCalculation meridianAltitudeCalculation;
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
		
		textFieldAlmanacTimeOfPassage = new JTextField();
		textFieldAlmanacTimeOfPassage.setBounds(320, 32, 150, 20);
		contentPane.add(textFieldAlmanacTimeOfPassage);
		textFieldAlmanacTimeOfPassage.setColumns(10);
		
		JLabel lblLocalTimeZone = new JLabel("Enter local time zone:");
		lblLocalTimeZone.setBounds(30, 51, 300, 20);
		contentPane.add(lblLocalTimeZone);
		
		spinnerLocalTimeZone = new JSpinner();
		spinnerLocalTimeZone.setModel(new SpinnerNumberModel(12, -13, 13, 1));
		spinnerLocalTimeZone.setBounds(320, 52, 60, 20);
		contentPane.add(spinnerLocalTimeZone);
		
		textFieldPassageUTC = new JTextField();
		textFieldPassageUTC.setBounds(80, 109, 150, 19);
		contentPane.add(textFieldPassageUTC);
		textFieldPassageUTC.setColumns(10);
		
		textFieldPassageLocal = new JTextField();
		textFieldPassageLocal.setBounds(320, 109, 150, 19);
		contentPane.add(textFieldPassageLocal);
		textFieldPassageLocal.setColumns(10);
		
		lblUTC = new JLabel("UTC:");
		lblUTC.setBounds(30, 105, 70, 15);
		contentPane.add(lblUTC);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(260, 111, 70, 15);
		contentPane.add(lblLocal);
		
		
		JButton btnCalculateUTC = new JButton("Calculate meridian passage UTC and Local:");
		btnCalculateUTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				meridianAltitudeCalculation = new MeridianAltitudeCalculation(getDRLon(), getTimeZone(), getAlmanacTimeOfPassage());
				textFieldPassageUTC.setText(meridianAltitudeCalculation.getPassageUTC());
				textFieldPassageLocal.setText(meridianAltitudeCalculation.getPassageLocal());
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
		lblIndexError.setBounds(30, 212, 300, 20);
		contentPane.add(lblIndexError);
		
		textFieldSextantIndexError = new JTextField();
		textFieldSextantIndexError.setText("+00 00.0");
		textFieldSextantIndexError.setToolTipText("+DD MM.M (- on arc)");
		textFieldSextantIndexError.setBounds(320, 224, 150, 20);
		contentPane.add(textFieldSextantIndexError);
		textFieldSextantIndexError.setColumns(10);
		btnCalculateUTC.setBounds(12, 83, 437, 20);
		contentPane.add(btnCalculateUTC);
		
		JLabel lblDEC0 = new JLabel("DEC0:");
		lblDEC0.setBounds(20, 319, 100, 20);
		contentPane.add(lblDEC0);
		
		textFieldDEC0 = new JTextField();
		textFieldDEC0.setToolTipText("(-S) +DD MM.M");
		textFieldDEC0.setBounds(116, 320, 80, 20);
		contentPane.add(textFieldDEC0);
		textFieldDEC0.setColumns(10);
		
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
		textFieldSDSun.setBounds(116, 352, 80, 20);
		contentPane.add(textFieldSDSun);
		textFieldSDSun.setColumns(10);
		
		JLabel lblBodyHeight = new JLabel("Height of body:");
		lblBodyHeight.setBounds(30, 249, 150, 20);
		contentPane.add(lblBodyHeight);
		
		textFieldHeightOfBody = new JTextField();
		textFieldHeightOfBody.setToolTipText("Height of Sun DD MM.M");
		textFieldHeightOfBody.setBounds(228, 252, 80, 15);
		contentPane.add(textFieldHeightOfBody);
		textFieldHeightOfBody.setColumns(10);
		
		JCheckBox chckbxNorth = new JCheckBox("North");
		chckbxNorth.setBounds(191, 277, 129, 23);
		chckbxNorth.setSelected(true);
		contentPane.add(chckbxNorth);
	
		JCheckBox chckbxSouth = new JCheckBox("South");
		chckbxSouth.setBounds(320, 277, 129, 23);
		chckbxSouth.setSelected(false);
		contentPane.add(chckbxSouth);
		
		JLabel lblNewLabel = new JLabel("Bearing of body:");
		lblNewLabel.setBounds(20, 281, 175, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnCalculateLOP = new JButton("Calculate Latitude");
		btnCalculateLOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				meridianAltitudeCalculation = new MeridianAltitudeCalculation(getDRLon(), getTimeZone(), getAlmanacTimeOfPassage(),
																			getDEC0(), getDEC1(), getHt(), getSextantAltitude(), getIndexError(),
																			getSD(), getTemperature(), getPressure(), getNameOfMZD());
				
				textFieldLatitude.setText(meridianAltitudeCalculation.getLatitude());
			}
		});
		
		btnCalculateLOP.setBounds(20, 383, 450, 20);
		contentPane.add(btnCalculateLOP);
		
		textFieldLatitude = new JTextField();
		textFieldLatitude.setBounds(180, 415, 200, 20);
		contentPane.add(textFieldLatitude);
		textFieldLatitude.setColumns(10);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnMainMenu.setBounds(393, 440, 117, 25);
		contentPane.add(btnMainMenu);
		
		
		
		
	}
	
	//getter methods
	public String getAlmanacTimeOfPassage() {
		return textFieldAlmanacTimeOfPassage.getText();
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
		String alt = textFieldHeightOfBody.getText();
		return alt;
	}
	
	public String getNameOfMZD() {
		
		String name = "S";
		/*
		if (chckbxNorth.isSelected()) {
			name = "S";	
		}
		else if (chckbxSouth.isSelected()) {
			name = "N";
		}
		*/
		return name;
	}
}
