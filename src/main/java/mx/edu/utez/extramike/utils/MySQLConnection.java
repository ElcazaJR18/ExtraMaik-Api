package mx.edu.utez.extramike.utils;

import java.sql.*;

public class MySQLConnection {

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Error en la conexion! de MySQL");
            e.printStackTrace();
        }
        return DriverManager.getConnection( "jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC ","root","root");

    }
    public static void main (String[] args) throws SQLException{
        Connection con = getConnection();
        System.out.println("Conexion exitosa con MySQL!     " + con);
        con.close();
    }

    public void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
            if (pstm != null)
                pstm.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


