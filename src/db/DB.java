package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	// Conectar um Banco de Dados com o JDBC é instanciar um objeto do tipo Connection
	// Quando instanciado, todas as propriedades estão na variável "conn"
	// Após conectado, o teste if falha e retorna a conexão
	
	private static Connection conn = null; //objeto de conexão do Banco de Dados do JDBC
	
	// método para criar uma conexão com o banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties(); // chamada do metodo LoadProperties para carregar as propriedades do arquivo db.properties
				String url = props.getProperty("dburl"); //acessar o caminho descrito na propriedade "dburl" do arquivo db.properties
				conn = DriverManager.getConnection(url, props); //DriveManager é uma classe do JDBC para conexão do Banco de dados
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
			
		return conn;
	}
	
	// método para fechar a conexão com o banco de Dados
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Carregar propriedades da conexão do Banco de Dados que estao no arquivo "db.propoerties"		
	private static Properties loadProperties() {		
		
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// método para fechar o Statement no programa principal para não ter que tratar a exceção
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	
	// método para fechar o ResultSet no programa principal para não ter que tratar a exceção
	public static void closeResultSet(ResultSet rt) {
		if (rt != null) {
			try {
				rt.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	
	
	
	

}
