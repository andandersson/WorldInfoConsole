package Model;
import java.sql.*;  

/*
 * The purpose of this class is to connect with the mySQL-database, 
 * and transfer information
 */

 //this is from https://www.javatpoint.com/example-to-connect-to-the-mysql-database
public class MysqlCon {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/world";
	   static final String USER = "root";
	   static final String PASS = "TerkaBalo712!"; 
	   private StringBuffer dataStore = new StringBuffer();
	   private final String city = "select * from city"; //querycommandos
	   private final String country = "select * from country";  //querycommandos
	   private final String countryLanguage = "select * from countrylanguage";   //querycommandos

	  
	   private final String cityColumns ="ID     NAME     COUNTRYCODE     DISTRICT     POPULATION \n";
	   private final String countryColumns ="CODE     NAME     CONTINENT     REGION     SURFACEAREA \n";
	   private final String countrylanCol ="COUNTRY     LANGUAGE     IS OFFICIAL (TRUE / FALSE)     PERCENTAGE \n";
	 
  
	   private String dataChoice;
	   private StringBuffer sqlColumns = new StringBuffer(); //storing the sqlColumn in a Stringbuffer
	   
	   public String getCity() { 
		   //getter
		   return this.city;
	   }
	   
	   public String getCountry() {
		   return this.country;
	   }
	   public String getCountryLanguage() {
		   return this.countryLanguage;
	   }


	public StringBuffer getDataBaseData(String choice) {
		
		//the String "choice" represents what we choose from the JComboBox in the applicatioion
		dataChoice = choice;
		
		try{  
			Class.forName(JDBC_DRIVER);  
			 Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
		
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(dataChoice);  
			while(rs.next())  {  
				if(dataChoice.equals(city)) {
					if(dataStore.length()==0) {
						dataStore.append(cityColumns + "\n");
					}
					
					dataStore.append( rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+ rs.getString(4)+ "    "+ rs.getString(5)+"\n");

				}
				
				
				else if(dataChoice.equals(country)) {
					if(dataStore.length()==0) {
						dataStore.append(countryColumns + "\n");
					
					}
					dataStore.append( rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+ rs.getString(4)+ "    "+ rs.getString(5)+"\n");

				}
				else {
					if(dataStore.length()==0) {
						dataStore.append(countrylanCol + "\n");
					
					}
					dataStore.append( rs.getString(1)+"       "+rs.getString(2)+"       "+rs.getString(3)+"       "+ rs.getString(4)+ "\n");

				
				}
			}
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
	
		} 
		return dataStore;
		
	}
	
}
