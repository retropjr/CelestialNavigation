import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIMain implements ActionListener {

	private int count;
	private JFrame frame;
	private JPanel panel;
	private JButton sunSightButton;
	private JLabel sunSightLabel;
	
	public GUIMain() {
		
		frame = new JFrame();
		
		sunSightButton = new JButton("Sun Sight");
		sunSightButton.addActionListener(this);
		
		sunSightLabel = new JLabel();
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setPreferredSize(new Dimension(500,500));
		
		//panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 30));
		//panel.setLayout(new GridLayout(0,1));
		panel.add(sunSightButton);
		panel.add(sunSightLabel);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Menu");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//count++;
		//sunSightLabel.setText("Sun Calc: " + count);
		new SunCalculation();
	}
		
}
