package br.com.labdeinf.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.labdeinf.dao.AuthorDAO;
import br.com.labdeinf.modelo.Author;
import br.com.labdeinf.utils.ConectaBanco;

public class CadastraAuthorTeste {

	public static void main(String args[]) throws SQLException{
		
		Author author = new Author("Bryan","Bashan");
		
		try(Connection connection = new ConectaBanco().abreConexao()) {
			AuthorDAO dao = new AuthorDAO(connection);
			dao.salva(author);
			List<Author> authors = dao.lista();
			for (Author author2 : authors) {
				System.out.println("Autor cadastrado " +author2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
