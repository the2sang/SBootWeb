package com.kdn.sbootweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {

    public JdbcConfig() { }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            String DB_HOST = "jdbc:oracle:thin:@localhost:21152:XE"; // 아이피, 포트, 서비스(SID) 정보를 수정
            String DB_USER = "EBXMLWEB"; // 아이디(유저) - 11g 이상시 대소문자 구분 확인
            String DB_PASS = "ebxmlweb"; // 패스워 - 11g 이상시 대소문자 구분 확인

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);

            System.out.println("연결성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("연결 드라이버 없음");
        } catch (SQLException e) {
            System.out.print("연결실패 : ");
            if(e.getMessage().indexOf("ORA-28009") > -1)
                System.out.println("허용되지 않는 접속 권한 없음");
            else if(e.getMessage().indexOf("ORA-01017") > -1)
                System.out.println("유저/패스워드 확인");
            else if(e.getMessage().indexOf("IO") > -1)
                System.out.println("IO - 연결확인!");
            else
                System.out.println("기본 연결확인!");

        } finally {
            if(conn != null)
                conn.close();
        }

        return conn;
    }
}
