package View;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Controller.*;
import Model.*;

public class Console {
	
	//The output console, it is added to the Window
	StringBuffer sql;
	String menuChoice;
	JTextArea text;
	JScrollPane js;
	
	
	public void clearData() {
		text.setText("");
	}
	public void printData(StringBuffer sqlData) {
		sql = sqlData;
		String consoleOutput = sql.toString();
		text.append(consoleOutput);
		sql.delete(0, sql.length());
		
	
	}
	
	//the outputconsole for the Data we are fetching from the database
	
	public Console(){
		
		Dimension conDim = new Dimension(400, 500);
		
		text = new JTextArea();
		text.setVisible(true);
		
		js = new JScrollPane(text);

		js.setVisible(true);
		text.setEditable(true);
		
		js.setPreferredSize(conDim);
		
		
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
	}
		
	
		
	

	
	
}
