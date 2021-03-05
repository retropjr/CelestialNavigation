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

public class SunSightDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLocalTimeOfSight;
	private JTextField textFieldTimeOfSightUTC;
	private JTextField textFieldInterpFactor;
	private JSpinner spinnerLocalTimeZone;
	private JSpinner spinnerTemperature;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public SunSightDetails() {
		setTitle("Sun Sight Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 447);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblLocalTimeOfSight = new JLabel("Enter local time of sight:");
		lblLocalTimeOfSight.setBounds(20, 10, 200, 20);
		contentPane.add(lblLocalTimeOfSight);
		
		textFieldLocalTimeOfSight = new JTextField();
		textFieldLocalTimeOfSight.setBounds(270, 10, 300, 20);
		contentPane.add(textFieldLocalTimeOfSight);
		textFieldLocalTimeOfSight.setColumns(10);
		
		JLabel lblLocalTimeZone = new JLabel("Enter local time zone:");
		lblLocalTimeZone.setBounds(20, 35, 200, 20);
		contentPane.add(lblLocalTimeZone);
		
		spinnerLocalTimeZone = new JSpinner();
		spinnerLocalTimeZone.setModel(new SpinnerNumberModel(new Integer(12), new Integer(-13), new Integer(+13), new Integer(1)));
		spinnerLocalTimeZone.setBounds(270, 35, 40, 20);
		contentPane.add(spinnerLocalTimeZone);
		
		
		JLabel lblTimeOfSightUTC = new JLabel("Time of sight UTC:");
		lblTimeOfSightUTC.setBounds(20, 60, 200, 20);
		contentPane.add(lblTimeOfSightUTC);
		
		textFieldTimeOfSightUTC = new JTextField();
		textFieldTimeOfSightUTC.setBounds(270, 60, 300, 20);
		contentPane.add(textFieldTimeOfSightUTC);
		textFieldTimeOfSightUTC.setColumns(10);
		
		JButton btnCalculateUTC = new JButton("Calculate UTC of sight");
		btnCalculateUTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sight sight;
				sight = new Sight(getLocalTimeOfSight(), getTimeZone());
				textFieldTimeOfSightUTC.setText(sight.getUTCOfSightString());
				SunCalculation sunCalculation = new SunCalculation(sight);
				
			}
		});
		btnCalculateUTC.setBounds(318, 35, 250, 20);
		contentPane.add(btnCalculateUTC);
		
		JLabel lblInterpFactor = new JLabel("Interpolation factor:");
		lblInterpFactor.setBounds(20, 85, 200, 20);
		contentPane.add(lblInterpFactor);
		
		textFieldInterpFactor = new JTextField();
		textFieldInterpFactor.setBounds(270, 85, 60, 20);
		contentPane.add(textFieldInterpFactor);
		textFieldInterpFactor.setColumns(10);
		
		JLabel lblTemperature = new JLabel("Enter temperature in celsius:");
		lblTemperature.setBounds(20, 110, 250, 20);
		contentPane.add(lblTemperature);
		
		spinnerTemperature = new JSpinner();
		spinnerTemperature.setModel(new SpinnerNumberModel(new Integer(15), new Integer (-20), new Integer (50), new Integer(1)));
		spinnerTemperature.setBounds(270, 110, 60, 20);
		contentPane.add(spinnerTemperature);
	}
	
	//getter methods
	 String getLocalTimeOfSight() {
		return textFieldLocalTimeOfSight.getText();
	}
	
	int getTimeZone() {
		
		
		int lTZ = (int) spinnerLocalTimeZone.getValue();
		
		return lTZ;
		
	}
}
