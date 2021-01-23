package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/java_aula04?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

	}

}
