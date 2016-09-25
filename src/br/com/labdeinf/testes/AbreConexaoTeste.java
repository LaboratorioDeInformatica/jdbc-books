package br.com.labdeinf.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.labdeinf.utils.ConectaBanco;

public class AbreConexaoTeste {
 
	    public static void main(String args[]){
	    	
	    	
	    	Statement statemant = null;
	    	
	    	try(Connection connection = new ConectaBanco().abreConexao()) {
	    		statemant = connection.createStatement();
	    		statemant.getConnection().createStatement();
	    		statemant.execute("SELECT *  FROM BOOKS.AUTHORS");
				ResultSet resultSet = statemant.getResultSet();
				while(resultSet.next()){
					int authorId = resultSet.getInt("authorId");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					System.out.println("authorId : "+authorId);
					System.out.println("firstName :"+firstName );
					System.out.println("lastName : " + lastName);
				}
				resultSet.close();
				statemant.close();
		    	
	    	} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	finally {
				try {
					statemant.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    }
	

}
