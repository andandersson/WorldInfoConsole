package View;
import Model.*;
import Controller.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/*
 * The main GUI-part for the application, where everything
 * is put together
 * 
 * 
 */

public class Window extends JFrame{
	private JPanel actionButtons;
	private JPanel console;

	private DataButton DB;
	private ClearButton CB;
	private DataController controller;
	

	public Console townInfo; //instance of class Console, for dataoutput
	public ActionBox ab;	


	public Window(DataController contr) {
		controller = contr;
		setVisible(true);
		
		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		
		Dimension applicationSize = new Dimension(450, 800);
		setMinimumSize(applicationSize); //size for the whole app
		
		DB = new DataButton(controller, this); //instance of databutton, with reference to this class
		
		ab = new ActionBox(); //instance of the dropdownmenu
	
		CB = new ClearButton(controller, this); //instance of Cearbutton
		
		townInfo = new Console();  //creating the console
				
		c.gridx = 0; //placing the components
		c.gridy= 0;
		add(DB, c);
		
		c.gridx = 0;
		c.gridy= 1;
		add(CB, c);
					
		c.gridx = 0;
		c.gridy= 2;
		add(ab, c);
		
	
		c.gridx = 0;
		c.gridy= 3;
		add(townInfo.js, c);		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
	}

}
