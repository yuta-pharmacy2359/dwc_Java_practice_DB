package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test4 {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
	static String sql = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();

			statement.executeUpdate("update user set money = money - 1000 where id = 1");
			statement.executeUpdate("update user set money = money + 1000 where id = 2");

			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
}
