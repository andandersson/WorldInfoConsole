package View;

import Controller.*;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ActionBox extends JComboBox {

	/*
	 * 
	 * This is a class for creating the JCombobox dropdownmenu on the application
	 */

	final String[] countryInfo;
	private JComboBox<String> OutputBox;
	public MysqlCon my;
	
	public ActionBox() {

		my = new MysqlCon();
		countryInfo = new String[] { "---------", "city", "country", "countrylanguage" };
		for (int i = 0; i < countryInfo.length; i++) {
			addItem(countryInfo[i]);
		}
		addActionListener(this);
	}

	public StringBuffer getData(Object choice) {
//		This method is acceccing the mySQLcon-class, and fetching the data.
		choice = getSelectedItem();
		if (choice.equals("city")) {
			String city = my.getCity();
			return my.getDataBaseData(city);

		} else if (choice.equals("country")) {
			String country = my.getCountry();
			return my.getDataBaseData(country);
			
		} else if (choice.equals("countrylanguage")) {
			String countryLanguage = my.getCountryLanguage();
			return my.getDataBaseData(countryLanguage);
			
		} else {
			StringBuffer consoleOutput = new StringBuffer(null);
			return null;
		}
	}
}
