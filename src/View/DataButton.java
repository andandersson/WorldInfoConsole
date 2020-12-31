package View;
import Controller.*;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


/*
 * 
 * The button where we are fetching data
 * When Pressing databutton, it 
 * is checking the marked field in class ActionBox,
 * and is according to that fetching from the Database
 */

public class DataButton extends JButton implements ActionListener {
	DataController dc; //instance of datacontroller, for accessing the class
	Window win;			//instance of Window

	private JLabel GetData;
	ActionBox a;
	
	public DataButton(DataController con, Window wow) {
		
		dc = con;
		win = wow;
		addActionListener(this);
		GetData = new JLabel("Fetch Data", JLabel.CENTER);
		this.add(GetData, JButton.CENTER);
		this.setSize(50, 50);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//When pressing the button, it is actitvating the getChosenData()
		//in DataController-class
		
		dc.getChosenData();
	}

}
