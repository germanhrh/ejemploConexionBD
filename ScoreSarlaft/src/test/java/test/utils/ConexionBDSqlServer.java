package test.utils;

import java.sql.*;

public class ConexionBDSqlServer {

    private static Connection cn;

    public static Connection getConnection() {
        try {

            String url = "jdbc:sqlserver://Servidor;instanceName=instancia;DatabaseName=nombrebd";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn= DriverManager.getConnection(url,"Usurio","Passew");

        } catch (Exception e) {
            cn=null;

        }

        return cn;
    }


    public static ResultSet ejecutarConsulta(String consulta) throws SQLException {
        ResultSet rs = null;
        Connection connexionBD = ConexionBDSqlServer.getConnection();
        if(connexionBD!=null) {
            System.out.println("Conectados consulta");
            Statement stm = connexionBD.createStatement();
            rs = stm.executeQuery(consulta);
        }
        return rs;
    }

    public static int  ejecutarUpdate(String consulta) throws SQLException {

        int retorno = 0;
        Connection connexionBD = ConexionBDSqlServer.getConnection();
        if(connexionBD!=null) {
            System.out.println("Conectados update");
            Statement stm = connexionBD.createStatement();
            retorno =  stm.executeUpdate(consulta);
        }

        return retorno;
    }
}
