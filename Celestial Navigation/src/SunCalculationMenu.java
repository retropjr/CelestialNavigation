import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

public class SunCalculationMenu {

	private JFrame frame;
	private JTextField textFieldPlot;
	private SunCalculation sunCalculation;
	private static JTextField textFieldSightLocalTime;
	private static JSpinner spinnerLocalTimeZone;
	private JTextField textFieldSightUTC;
	private Date localTimeOfSight;

	/**
	 * Create the menu.
	 */
	public SunCalculationMenu() {
		frame = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 678, 439);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sunCalculation = new SunCalculation();
				textFieldPlot.setText(sunCalculation.getPlot());
			}
		});
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		
	
		textFieldPlot = new JTextField();
		textFieldPlot.setColumns(10);
		
		JLabel lblLocalDatetimeOf = new JLabel("Enter local timeof sight:");
		
		textFieldSightLocalTime = new JTextField();
		textFieldSightLocalTime.setToolTipText("YYYY-MM-DD hh:mm:ss");
		textFieldSightLocalTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter local time zone:");
		
		spinnerLocalTimeZone = new JSpinner();
		spinnerLocalTimeZone.setModel(new SpinnerNumberModel(new Integer(12), new Integer(-13), new Integer(13), new Integer(1)));
		
		JLabel lblNewLabel_1 = new JLabel("Time of sight UTC:");
		
		textFieldSightUTC = new JTextField();
		textFieldSightUTC.setColumns(10);
		
			
		
		JButton btnCalculateUTC = new JButton("Calculate UTC of sight");
		btnCalculateUTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				try {
					localTimeOfSight = dateTimeFormat.parse(textFieldSightLocalTime.getText());
				}
				catch(Exception e) {
					
				}
				
			Date UTCOfSight = calculateUTCOfSight(localTimeOfSight, -(int) spinnerLocalTimeZone.getValue());
			String UTCOfSightString = buildUTCOfSightString(UTCOfSight.toString());
			textFieldSightUTC.setText(UTCOfSightString);	
			}
		});
			
			
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLocalDatetimeOf)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(spinnerLocalTimeZone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCalculateUTC))
						.addComponent(textFieldSightLocalTime, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(textFieldSightUTC))
					.addContainerGap(190, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnMainMenu)
						.addComponent(btnCalculate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
					.addGap(22))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(198)
					.addComponent(textFieldPlot, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(209, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalDatetimeOf)
						.addComponent(textFieldSightLocalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(spinnerLocalTimeZone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldSightUTC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldPlot, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMainMenu)
					.addGap(36))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(btnCalculateUTC)
					.addContainerGap(320, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public static String getLocalTimeOfSight() {
		return textFieldSightLocalTime.getText();
	}
	
	public static int getLocalTimeZone() {
		return (int) spinnerLocalTimeZone.getValue();
	}
	
	
	
	public SpinnerModel getSpinnerModel() {
		return spinnerLocalTimeZone.getModel();
	}
	
	public void setSpinnerModel(SpinnerModel model) {
		spinnerLocalTimeZone.setModel(model);
	}
	
	private Date calculateUTCOfSight(Date date, int hours) {
		final long hoursInMilliSec = hours * 60 * 60 * 1000;
		Date newDate = new Date(date.getTime() + hoursInMilliSec);
		
		return newDate;
	}
	
	private String buildUTCOfSightString(String str) {
		String year = str.substring(25, 29);
		String month = str.substring(4, 7);
		switch (month) {
		case "Jan": {
			month = "01";
			break;
		}
		case "Feb": {
			month = "02";
			break;
		}
		case "Mar": {
			month = "03";
			break;
		}
		case "Apr": {
			month = "04";
			break;
		}
		case "May": {
			month = "05";
			break;
		}
		case "Jun": {
			month = "06";
			break;
		}
		case "Jul": {
			month = "07";
			break;
		}
		case "Aug": {
			month = "08";
			break;
		}
		case "Sep": {
			month = "09";
			break;
		}
		case "Oct": {
			month = "10";
			break;
		}
		case "Nov": {
			month = "11";
			break;
		}
		case "Dec": {
			month = "12";
			break;
		}
		}
		String day = str.substring(8, 10);
		String time = str.substring(11,20);
		
		String string = (year + "-" + month + "-" + day + " " + time);
		return string;
	}
}
