package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBC() throws SQLException {
		Driver driverRef = new Driver();

		// Step 1: Register the driver
		DriverManager.registerDriver(driverRef);

		// Step 2: Get the connection to driver-database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm23db", "root", "root");

		// Step 3: Issue Create Statement
		Statement state = con.createStatement();

		// Step 4: Execute Query
		ResultSet result = state.executeQuery("select * from candidateInfo;");
		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getInt(2) + " " + result.getString(3));
		}

		// Step 5: Close db
		con.close();
		System.out.println("Database Closed");
	}

}
