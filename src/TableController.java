import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableController {

    private Connection connection;
    private Scanner scanner;

    public TableController(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);

    }

    public void dropingvideogames() throws SQLException, IOException  {

        Statement st = connection.createStatement();

        st.executeQuery("DROP TABLE videojuegos");

            System.out.println("\n Tabla de videojuegos borrada");

        st.close();

    }

    public void dropingvalues() throws SQLException, IOException  {

        System.out.println("\nNombre de la tabla que quieres borrar: \n");
        String tabla = scanner.nextLine();


        Statement st = connection.createStatement();


        st.executeUpdate("DELETE FROM " + tabla);

        System.out.println("\nVALORES de la tabla " + tabla.toUpperCase() +" BORRADA \n");
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        st.close();

    }
}
