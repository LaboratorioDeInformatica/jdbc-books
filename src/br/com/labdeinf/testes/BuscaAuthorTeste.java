package br.com.labdeinf.testes;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.labdeinf.utils.ConectaBanco;

public class BuscaAuthorTeste {

	public static void main (String args[]){
		
		Statement stm ;
		 
		try {
			stm = (Statement) ConectaBanco.abreConexao().createStatement();
			stm.getConnection().createStatement();
			stm.execute("SELECT *  FROM BOOKS.AUTHORS");
			ResultSet resultSet = stm.getResultSet();
			while(resultSet.next()){
				int authorId = resultSet.getInt("authorId");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				System.out.println("authorId : "+authorId);
				System.out.println("firstName :"+firstName );
				System.out.println("lastName : " + lastName);
			}
			resultSet.close();
			stm.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
