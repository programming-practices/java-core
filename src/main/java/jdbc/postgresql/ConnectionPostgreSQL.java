package jdbc.postgresql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionPostgreSQL {

    private static String appConfigPath = "core/src/main/resources/JDBCConfiguration/PostgreSQL.properties";
    private static Connection connection;

    private ConnectionPostgreSQL() {
    }

    /**
     * @return Connection of database.
     * @throws ExceptionParameterNotExist Throws an exception if at least one parameter does not coincide
     *                                    with the setting parameters in the configuration file. Settings file is in 'resources/JDBCConfiguration'.
     */
    public static Connection getConnection(String url, String user, String password) throws ExceptionParameterNotExist {

        Properties configurations = getConfigurations(url, user, password);

        try {
            connection = DriverManager.getConnection(
                    configurations.getProperty(url),
                    configurations.getProperty(user),
                    configurations.getProperty(password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Close this connection of Database.
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Properties getConfigurations(String url, String user, String password) throws ExceptionParameterNotExist {

        String[] argParameters = {url, user, password};
        Properties connectionProperties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)) {
            connectionProperties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        checkParameters(argParameters, connectionProperties);

        return (Properties) connectionProperties.clone();
    }

    private static void checkParameters(String[] parameters, Properties connectionProperties) throws ExceptionParameterNotExist {

        for (String parameter : parameters) {
            if (!connectionProperties.containsKey(parameter)) {
                throw new ExceptionParameterNotExist("Parameter '" + parameter + "' not exist. \n Check this name of parameter.");
            }
        }
    }
}