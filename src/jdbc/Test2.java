package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		try (Connection connection = DriverManager.getConnection(URL);
			PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (?, ?)")) {
				statement.setString(1, "bbb@bbb.bbb");
				statement.setString(2, "Jiro Yamada");
				statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
