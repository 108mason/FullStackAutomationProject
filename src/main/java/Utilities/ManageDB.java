package Utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

        /*
    ############################################################################
    Method Name: openConnection
    Method Description: This Method Opens DB Connection with passed Parameters.
    Method Parameters: 3 values of String
    Method Return Type: void
    ############################################################################
     */

    public static void openConnection(String dbURL, String user, String pass)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred While Connecting to DB, See Details: " + e);
        }
    }

        /*
    #######################################################
    Method Name: closeConnection
    Method Description: This Method Closes DB Connection.
    Method Parameters: void
    Method Return Type: void
    #######################################################
     */


    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred While closing DB, See Details: " + e);
        }
    }

}
