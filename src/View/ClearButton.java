package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.DataController;

public class ClearButton extends JButton implements ActionListener {
	//this is class is for clearing the console.
	
	DataController dc; //instance of datacontroller, for accessing the class
	Window win;	
	private JLabel ClearData;
	ActionBox a;
	
	
	public ClearButton(DataController con, Window wow) {
		dc = con;
		win = wow;
		addActionListener(this);
		ClearData = new JLabel("Clear Console", JLabel.CENTER);
		this.add(ClearData, JButton.CENTER);
		this.setSize(50, 50);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dc.clearConsole();
		
	}

}
