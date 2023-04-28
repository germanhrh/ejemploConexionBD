package test.utils;

//import oracle.jdbc.driver.OracleDriver;

import java.sql.*;


public class ConexionBDOracle {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void registrarDriver() throws SQLException {
       // OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
      //  DriverManager.registerDriver(oracleDriver);
    }

    public static Connection conectarQA() throws SQLException {
        String url = "10.120.18.145";
        if (connection == null || connection.isClosed()) {
            String cadenaConexion = "jdbc:oracle:thin:@" + url + ":" + "1541"  + "/" + "ADMICERT";
            registrarDriver();
            connection = DriverManager.getConnection(cadenaConexion, "QACERTIFICO", "QACERTIFICO");
        }
        return connection;
    }

    public static ResultSet ejecutarConsulta(String consulta) throws SQLException {
        ResultSet rs = null;
        Connection connexionBD = ConexionBDOracle.conectarQA();
        if(connexionBD!=null) {
            System.out.println("Conectados consulta");
            Statement stm = connexionBD.createStatement();
            rs = stm.executeQuery(consulta);
        }
        return rs;
    }

    public void cerrar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
