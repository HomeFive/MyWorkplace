package com.db;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.*;

public class DBUtils {
    private static String USERNAME = "";
    private static String PASSWORD = "";
    private static String DRIVERCLASS = "";
    private static String URL = "";

    static {
        Properties p = new Properties();
        try {
            p.load(DBUtils.class.getResourceAsStream("db.properties"));
            USERNAME = p.getProperty("username");
            PASSWORD = p.getProperty("password");
            DRIVERCLASS = p.getProperty("driverClass");
            URL = p.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVERCLASS);
            return conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConn(Connection conn, Statement st, ResultSet rs){
        try {
            if (rs!=null)
                rs.close();
            if (st!=null)
                st.close();
            if (conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement setParamsToPreparedStatement(Connection conn, String sql, Map<String,Object> params) throws SQLException {
        PreparedStatement pst = null;
        if (params!=null){
            StringBuffer sb = new StringBuffer(sql);
            sb.append(" where 1=1");
            if (params!=null)
                for (String key : params.keySet()){
                    sb.append(" and ");
                    sb.append(key);
                    sb.append(" = ?");
                }
            pst = conn.prepareStatement(sb.toString());
            int count = 0;
            for (Object value : params.values())
                pst.setObject(count++,value);
        }
        return pst;
    }

    public static <T> T setRowByReflection(ResultSet rs, Class<T> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
            T t = clazz.getDeclaredConstructor().newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            Field[] fields = clazz.getDeclaredFields();
            for (int i=0,j=metaData.getColumnCount();i<j;){
                String column = metaData.getColumnName(++i);
                Object value = rs.getObject(column);
                for (int k = 0; k < fields.length; k++) {
                    if (fields[k].getName().equalsIgnoreCase(column)){
                        if (!Modifier.isPublic(fields[k].getModifiers()))
                            fields[k].setAccessible(true);
                        fields[k].set(t,value);
                        break;
                    }
                }
            }
            return t;
    }

    public static void closeConn(Connection conn, Statement st){
        closeConn(conn,st,null);
    }

    public static <T> List<T> executeQuery(String sql, Map<String,Object> params, Class<T> clazz){
        Connection conn = getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            pst = setParamsToPreparedStatement(conn,sql,params);
            rs = pst.executeQuery();
            while (rs.next()){
                list.add(setRowByReflection(rs,clazz));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst,rs);
        }
        return null;
    }

    public static int executeUpdate(String sql, Object... params){
        Connection conn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            conn = getConnection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            result = pst.executeUpdate();
            System.out.println("受影响行数："+result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(conn,pst,null);
        }
        return result;
    }
}
