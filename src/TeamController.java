
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TeamController {

	private Connection connection;
	private Scanner scanner;

	public TeamController(Connection connection) {
		this.connection = connection;
		this.scanner = new Scanner(System.in);

	}

	public void showTeams() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM team");
		while (rs.next()) {
			System.out.println("Name: " + rs.getString("name") + " " +
							   "Type: " + rs.getString("type") + " " +
							   "Country: " + rs.getString("country") + " " +
							   "City: " + rs.getString("city") + " " +
							   "Court name: " + rs.getString("court_name"));
		}

		rs.close();
		st.close();
	}

	public void createTeam() {

		System.out.println("****************************");
		System.out.println("*       CREANT EQUIP       *");
		System.out.println("****************************");
		System.out.println("* Nombre:                  *");
		System.out.print("* ");
		String firstname = scanner.nextLine();
		System.out.println("****************************");
		System.out.println("* Tipo:(National Team/Club)*");
		System.out.print("* ");
		String type = scanner.nextLine();
		System.out.println("****************************");
		System.out.println("* Pais:                  *");
		System.out.print("* ");
		String country = scanner.nextLine();
		System.out.println("****************************");
		System.out.println("* City:                  *");
		System.out.print("* ");
		String city = scanner.nextLine();
		System.out.println("****************************");
		System.out.println("* Court Name:              *");
		System.out.print("* ");
		String courtname = scanner.nextLine();
		System.out.println("****************************");


		String sql = "INSERT INTO team VALUES (?,?,?,?,?) ";

		try {

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, firstname);
			pst.setString(2, type);
			pst.setString(3, country);
			pst.setString(4, city);
			pst.setString(5, courtname);

			pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
