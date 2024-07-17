package JDBC_Demo;

import java.sql.*;

public class JDBC_Connection_ps {
        //data members
        static String dbname,username,password;
        static ResultSet rs=null;
        static Connection con=null;
        static PreparedStatement ps=null;
        //methods
        public static void setDatabaseDetails(String db,String user,String pass){
            dbname=db; username=user; password=pass;
        }

        public static ResultSet getResult(String query,String na) {
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, username, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
                ps = con.prepareStatement(query);
                ps.setString(1,na);
                rs = ps.executeQuery();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }

        public static void closeResources()
        {
            try {
                rs.close(); ps.close(); con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args){
            try{
                String query = "SELECT id, name FROM studentinfo where name=?";
                setDatabaseDetails("studentdemo","postgres","postgres");
                ResultSet rs=getResult(query,"om or 1=1");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.print("ID: " + id);
                    System.out.println(", Name: " + name);
                }

                closeResources();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}

