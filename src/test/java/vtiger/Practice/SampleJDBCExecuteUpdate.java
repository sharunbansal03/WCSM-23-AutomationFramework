package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	@Test
	public void sampleJDBC() throws SQLException {

		Driver driverRef = new Driver();

		// Step 1: Register the driver
		DriverManager.registerDriver(driverRef);

		// Step 2: Connect to driver-database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm23db", "root", "root");

		// Step3: Issue createStatement
		Statement state = con.createStatement();

		// Step4: Execute the query
		int result = state
				.executeUpdate("insert into candidateInfo values('javaProg',333,'IDE');");
		if(result==1) {
			System.out.println("Data added successfully");
		}
		
		ResultSet r = state.executeQuery("select * from candidateInfo;");
		while (r.next()) {
			System.out.println(r.getString(1) + " " + r.getInt(2) + " " + r.getString(3));
		}
		// Step 5: Close the db
		con.close();

	}

}
