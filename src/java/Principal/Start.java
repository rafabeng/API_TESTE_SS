/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Start {
// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "postgres";
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
              Connection conn = null;
              Statement stmt = null;
              
              Class.forName("org.postgresql.Driver");
            
		try {
                     System.out.println("Connecting to a selected database...");
                     conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     System.out.println("Connected database successfully...");
		
			CsvReader cliente = new CsvReader("src/resources/Cidades.csv");
		
			cliente.readHeaders();
                        
                        
			while (cliente.readRecord())
			{
				
                        
                                String ibge_id = cliente.get("ibge_id");
				String uf = cliente.get("uf");
                                String n = cliente.get("name");
                             
                                String name = n.replace("'", "");
                                
                               
				String capital = cliente.get("capital");
				String lon = cliente.get("lon");
                                String lat = cliente.get("lat");
                                String na = cliente.get("no_accents");
                                String no_accents = na.replace("'", "");
                                
                                String alternative_names = cliente.get("alternative_names");
                           
                                String mi = cliente.get("microregion");
                                String microregion = mi.replace("'", "");
                                
                                String me = cliente.get("mesoregion");
                                String mesoregion = me.replace("'", "");
				
				System.out.println(ibge_id + "|" + uf + "|" + name + "|" + capital
                                                   + "|" + lon + "|" + lat  + "|" + no_accents   
                                                   + "|" + alternative_names  + "|" + microregion
                                                   + "|" + mesoregion  );
                                
                        
                           
                                 stmt = conn.createStatement();

                                 String sql = "INSERT INTO public.cidade(ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion "+")         "+                                              
                                                 "VALUES ('"+ibge_id+"','"+uf+"','"+name+"','"+capital+"','"+lon+"','"+lat+"','"+no_accents+"','"+alternative_names+"','"+microregion+"','"+mesoregion+"')";







                                  stmt.executeUpdate(sql);
                                  stmt.close();
                                
			}
	
			cliente.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
