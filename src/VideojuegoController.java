import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VideojuegoController {

    private Connection connection;
    private Scanner scanner;

    public VideojuegoController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);

    }

    public void creavideogame() {

        System.out.println("***********************************");
        System.out.println("*         CREANT VIDEOJOC         *");
        System.out.println("***********************************");
        System.out.println("* Nom del Videojoc:               *");
        System.out.print("* ");
        String nom = scanner.nextLine();
        System.out.println("***********************************");
        System.out.println("* Génere del joc:                 *");
        System.out.print("* ");
        String genere = scanner.nextLine();
        System.out.println("***********************************");
        System.out.println("* Fecha lanzamiento (yyyy-mm-dd): *");
        System.out.print("* ");
        String lanzamiento = scanner.nextLine();

        System.out.println("***********************************");
        System.out.println("* Plataforma:                     *");
        System.out.print("* ");
        String plataforma = scanner.nextLine();
        System.out.println("***********************************");


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date bDate = null;

        try {
            bDate = format.parse(lanzamiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO videojuegos VALUES (?,?,?,?) ";

        try {

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, nom);
            pst.setString(2, genere);
            pst.setDate(3, new java.sql.Date(bDate.getTime()));
            pst.setString(4, plataforma);


            pst.executeUpdate();

            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewvideogames() throws SQLException, IOException {

        Statement st = connection.createStatement();
        ResultSet rs;

        rs = st.executeQuery("SELECT * FROM videojuegos");
        while (rs.next()) {
            System.out.println("*****************************************");
            System.out.println("              " + rs.getString("nombre").toUpperCase() + "\n" +
                    "Género: " + rs.getString("género") + "\n" +
                    "Fecha de lanzamiento: " + rs.getString("fecha_lanzamiento") + "\n" +
                    "Plataforma: " + rs.getString("plataforma"));
            System.out.println("*****************************************\n");

        }

        rs.close();
        st.close();

    }
}
