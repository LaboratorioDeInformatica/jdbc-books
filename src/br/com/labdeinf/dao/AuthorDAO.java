package br.com.labdeinf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.labdeinf.modelo.Author;

public class AuthorDAO {
	
	private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

	public  void salva(Author author) throws SQLException {
		String sql =" INSERT INTO BOOKS.AUTHORS (firstName, lastName) values (?,?);";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1,author.getFirstName());
			statement.setString(2,author.getLastname());
			statement.execute();
			
			
		}
		
		System.out.println("Author cadastrado com sucesso "+author);
	}
	
	public List<Author> lista() throws SQLException{
		List<Author> authors = new ArrayList<>();
		String sql ="SELECT authorID, firstName , lastName  FROM  BOOKS.AUTHORS ;" ;
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.execute();
			try(ResultSet rs = statement.getResultSet()){
				while(rs.next()){
					
					Integer authorID = rs.getInt("authorID");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					Author author = new Author(firstName,lastName);
					author.setAuthorId(authorID);
					authors.add(author);
				}
			}
		}
		return authors;
		
	}
}
