package jdbc.MySQL.A1._8_Lesson_BLOB_Binary_large_objects;

import jdbc.MySQL.ConnectionMySQL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Lesson8 {
    public static void main(String[] args) throws IOException, SQLException {

        Statement statement = ConnectionMySQL.getConnection().createStatement();
        statement.execute("USE JDBC");
        statement.execute("DROP TABLE IF EXISTS Books");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                "Books (id MEDIUMINT AUTO_INCREMENT NOT NULL PRIMARY KEY , name CHAR (25) NOT NULL, img BLOB)");
        BufferedImage image = ImageIO.read(new File("src/main/resources/smail.png"));
        Blob blob = ConnectionMySQL.getConnection().createBlob();
        try (OutputStream outputStream = blob.setBinaryStream(1)) {

            ImageIO.write(image, "jpg", outputStream);
        } catch (Exception e) {
            System.out.println("ye");
        }
        PreparedStatement preparedStatement =
                ConnectionMySQL.getConnection().prepareStatement("INSERT INTO Books (name , img) VALUES (?,?)");

        preparedStatement.execute("USE JDBC");
        preparedStatement.setString(1, "Pando Kynfy");
        preparedStatement.setBlob(2, blob);

        preparedStatement.execute();
//        System.out.println(preparedStatement);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
        while (resultSet.next()) {
            Blob blob1 = resultSet.getBlob("img");
            BufferedImage image1 = ImageIO.read(blob1.getBinaryStream());
            File file = new File("saved.png");
            ImageIO.write(image1, "png", file);

        }
    }
}
