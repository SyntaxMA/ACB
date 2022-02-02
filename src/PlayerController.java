import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.util.logging.Level.parse;

public class PlayerController {

	private Connection connection;
	private Scanner scanner;

	public PlayerController(Connection c) {
		this.connection = c;
		this.scanner = new Scanner(System.in);
	}

	public void createPlayer() {

			System.out.println("****************************");
			System.out.println("*     CREANT JUGADOR       *");
			System.out.println("****************************");
			System.out.println("* Federation License Code: *");
			System.out.print("* ");
			String flc = scanner.nextLine();
			System.out.println("****************************");
			System.out.println("* Nombre:                  *");
			System.out.print("* ");
			String firstname = scanner.nextLine();
			System.out.println("****************************");
			System.out.println("* Apellido:                *");
			System.out.print("* ");
			String lastname = scanner.nextLine();
			System.out.println("****************************");
			System.out.println("* Cumpleaños(año-mes-dia): *");
			System.out.print("* ");

			String birthdayDate = scanner.nextLine();

			System.out.println("****************************");
			System.out.println("* Género:                  *");
			System.out.print("* ");
			String gender = scanner.nextLine();
			System.out.println("****************************");
			System.out.println("* Height:                  *");
			System.out.print("* ");
			int height = scanner.nextInt();
			System.out.println("****************************");
			System.out.println("* Team:                    *");
			System.out.print("* ");
		String xd = scanner.nextLine();
		String teamname = scanner.nextLine();
			System.out.println("****************************");
			System.out.println("* MVP Total:               *");
			System.out.print("* ");
			int mvpTotal = scanner.nextInt();
			System.out.println("****************************");
		String xq = scanner.nextLine();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date bDate = null;
			try {
				bDate = format.parse(birthdayDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String sql = "INSERT INTO player VALUES (?,?,?,?,?,?,?,?) ";

			try {

				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, flc);
				pst.setString(2, firstname);
				pst.setString(3, lastname);
				pst.setDate(4, new java.sql.Date(bDate.getTime()));
				pst.setString(5, gender);
				pst.setInt(6, height);
				pst.setString(7, teamname);
				pst.setInt(8, mvpTotal);

				pst.executeUpdate();

				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
}

