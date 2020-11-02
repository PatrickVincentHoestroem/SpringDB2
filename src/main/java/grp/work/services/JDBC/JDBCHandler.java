package grp.work.services.JDBC;

import java.sql.*;

public class JDBCHandler {

    Connection connection = null;
    String url;

    public JDBCHandler() {
        url = "jdbc:mysql://localhost:3306/urlread?serverTimezone=UTC";
        setConnection(url);
    }

    public String setConnection(String url) {
        String msg;
        try {
            connection = DriverManager.getConnection(url, "DB", "333");
            msg = "Connection to: " + url + ": Was established.";
        } catch (SQLException sqlException) {
            msg = "Connection to: " + url + ": Has sadly failed, try and reconnect.";
        }
        return msg;
    }

}
