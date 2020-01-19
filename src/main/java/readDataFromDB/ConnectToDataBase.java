package readDataFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDataBase {

	public Connection connect;
	public Statement statement;
	public String dbDriver = "com.mysql.cj.jdbc.Driver";
	public String dbURL = "jdbc:mysql://localhost:3306/customer";
	public String dbUserName = "root";
	public String dbUserPassword = "Jaga@2983";

	public Statement getConnectionStatement() throws ClassNotFoundException, SQLException {
		Class.forName(dbDriver);
		connect = DriverManager.getConnection(dbURL, dbUserName, dbUserPassword);
		statement = connect.createStatement();
		return statement;
	}

	public void putData(String query) throws ClassNotFoundException, SQLException {
		getConnectionStatement().executeUpdate(query);
	}

	public ResultSet getData(String query) throws ClassNotFoundException, SQLException {
		ResultSet data = getConnectionStatement().executeQuery(query);
		return data;
	}
}