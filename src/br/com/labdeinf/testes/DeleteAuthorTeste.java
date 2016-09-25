package br.com.labdeinf.testes;

import java.sql.SQLException;
import java.sql.Statement;

import br.com.labdeinf.utils.ConectaBanco;

public class DeleteAuthorTeste {

	public static void main(String args[]){
		//stmt.execute("delete from Produto where id>3");
		Statement stm;
		
		try {
			stm = (Statement) ConectaBanco.abreConexao().createStatement();
			stm.getConnection().createStatement();
			stm.execute("DELETE FROM BOOKS.AUTHORS WHERE authorId >= 10; ");
			int count = stm.getUpdateCount();
	        System.out.println(count + " linhas atualizadas");
			stm.close();
			System.out.println("Delete executado");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
