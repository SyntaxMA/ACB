import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MatchController {

    private Connection connection;
    private Scanner scanner;

    public MatchController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);

    }

    public void createMatch() {

        System.out.println("****************************");
        System.out.println("*      CREANT PARTIT       *");
        System.out.println("****************************");
        System.out.println("* Equipo de casa:          *");
        System.out.print("* ");
        String home = scanner.nextLine();
        System.out.println("****************************");
        System.out.println("* Equipo de visita         *");
        System.out.print("* ");
        String visitor = scanner.nextLine();
        System.out.println("****************************");
        System.out.println("* Fecha del partido:       *");
        System.out.print("* ");
        String matchDate = scanner.nextLine();

        System.out.println("****************************");
        System.out.println("* Numero de aforo:         *");
        System.out.print("* ");
        String attendance = scanner.nextLine();
        System.out.println("****************************");
        System.out.println("* Jugador MVP:             *");
        System.out.print("* ");
        String mvp = scanner.nextLine();
        System.out.println("****************************");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date bDate = null;

        try {
            bDate = format.parse(matchDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO team VALUES (?,?,?,?,?) ";

        try {

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, home);
            pst.setString(2, visitor);
            pst.setDate(4, new java.sql.Date(bDate.getTime()));
            pst.setString(4, attendance);
            pst.setString(5, mvp);

            pst.executeUpdate();

            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
