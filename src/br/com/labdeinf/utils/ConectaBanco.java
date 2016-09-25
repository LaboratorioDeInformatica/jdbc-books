package br.com.labdeinf.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco {

	private static final String USUARIO = "root";
    private static final String SENHA = "admin";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/books";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    
    // Conectar ao banco
    public static Connection abreConexao() throws Exception {
    	
    	
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
    
        // Retorna a conexao aberta
        return conn;


    }
}
