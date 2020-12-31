package Controller;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.*;
import View.*;

public class DataController {
	
	Window w = new Window(this);
	private String city = w.ab.my.getCity();
	private String country = w.ab.my.getCountry();
	private String countryLanguage = w.ab.my.getCountryLanguage();
	private JOptionPane j;
	private JFrame f;

	
	public void getChosenData() {
		
//		this method is called whenever the "fetch"-button is pressed
		try {
//			try-catch block for handling the case when the user has not chosen a value in the JCOmboBox
			clearConsole();

			w.townInfo.printData(w.ab.getData(w.ab.getSelectedItem()));
			
		}
		catch(NullPointerException e) {
			
			//in case the user has not chosen a value, a Joptionpane will pop up.
			f = new JFrame();
			j = new JOptionPane();
			j.setVisible(true);
			j.showMessageDialog(f, "Please choose a parameter from the dropdownmenu!");
			
		}
	

		
	
	}
	public void clearConsole() {
//		This method is called whener the "clear-Button" is pressed
		w.townInfo.clearData();
		
	}

}
