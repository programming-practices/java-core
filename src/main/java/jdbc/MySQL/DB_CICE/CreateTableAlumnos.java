package jdbc.MySQL.DB_CICE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAlumnos {
    public static void main(String[] args) {
        try {
            Statement statement = ConnectionMySQL_CICE.getConnection().createStatement();

            // Use dataBase CICE
            statement.execute("USE CICE");

            // Creacion de data base
//            statement.execute("DROP TABLE Alumnos");
//            statement.executeUpdate("CREATE TABLE Alumnos (Alumno_id INT AUTO_INCREMENT, Nombre VARCHAR(30) NOT NULL, " +
//                    "Apellido_1 VARCHAR(30) NOT NULL, Nacimiento TIMESTAMP, Sexo VARCHAR (3) NOT NULL, Nota FLOAT NOT NULL, PRIMARY KEY (Alumno_id))");

            // Rellena los datos
//            statement.executeUpdate("INSERT INTO Alumnos VALUES (1, 'Diana', 'Valero', '1985-06-05', 'M', 6.8)");
//            statement.executeUpdate("INSERT INTO Alumnos VALUES (2, 'Pedor', 'Valero', '1986-03-11', 'H', 7.1)");
//            statement.executeUpdate("INSERT INTO Alumnos VALUES (3, 'Luis', 'Gonzalez', '1979-02-24', 'H', 8.6)");
//            statement.executeUpdate("INSERT INTO Alumnos VALUES (4, 'Cristina', 'Vicaria', '1981-11-01', 'M', 6.8)");
//            statement.executeUpdate("INSERT INTO Alumnos VALUES (5, 'Antonio', 'Carcia', '1986-02-16', 'H', 5.7)");

            // Imprimir datos
//            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Alumnos WHERE Nota >= 7.0");
//            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Alumnos");
            ResultSet resultSet = statement.executeQuery("SELECT Nombre, Apellido_1 FROM Alumnos");
            while (resultSet.next()) {
//                System.out.println("Id: " + resultSet.getInt("Alumno_id"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Primer apellido: " + resultSet.getString("Apellido_1"));
//                System.out.println("Fecha de nacimiento: " + resultSet.getDate("Nacimiento"));
//                System.out.println("Sexo:" + resultSet.getString("Sexo"));
//                System.out.println("Nota: " + resultSet.getFloat("Nota"));
                System.out.println("-------------------------------------------------");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
