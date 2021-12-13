package pers.Donovan.hr.db;

import java.sql.*;

public class BaseDao {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orclyz";
    private static final String USERNAME = "SYSTEM";
    private static final String PWD = "Donovan0116";


    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open(){
        try {
            this.conn = DriverManager.getConnection(URL,USERNAME,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        if(rs!=null){
            try {
                this.rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                this.rs = null;
            }
        }
        if(ps!=null){
            try {
                this.ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                this.ps = null;
            }
        }
        if(conn!=null){
            try {
                this.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                this.conn = null;
            }
        }
    }


    public int execDML(String sql,Object...param){
        this.makeStatement(sql,param);
        try {
            return this.ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;

    }

    private void makeStatement(String sql, Object[] param) {
        try {
            this.ps = this.conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                this.ps.setObject(i+1,param[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ResultSet execDQL(String sql, Object...param){
        this.makeStatement(sql,param);
        try {
            return this.ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}


