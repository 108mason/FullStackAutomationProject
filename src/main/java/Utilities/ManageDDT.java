package Utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {

    /*
    ###################################################################################
    Method Name: getDataObject (DDT Web)
    Method Description: This Method defines the original CSV File and passes received
                        2D Object Array to Data Provider.
    Method Parameters: void
    Method Return Type: 2D Object Array
    ###################################################################################
     */

    @DataProvider(name = "data-provider-web")
    public Object[][] getDataObjectWeb() {
        return getDataFromCSV(getData("DDTFile-WEB"));
    }


    /*
    #################################################################################
    Method Name: getDataFromCSV
    Method Description: This Method parses Fields from received CSV File to
                        2D Object Array.
    Method Parameters: String
    Method Return Type: 2D Object Array
    #################################################################################
     */
    public static Object[][] getDataFromCSV(String filePath) {
        List<String> csvData = readCSV(filePath);
        int columnNum = csvData.get(0).split(",").length;
        Object[][] data = new Object[csvData.size()][columnNum];
        for (int i = 0; i < csvData.size(); i++) {
            for (int j=0; j<columnNum; j++) {
                data[i][j] = csvData.get(i).split(",")[j];
            }
        }
        return data;
    }


        /*
    ################################################################################################
    Method Name: readCSV
    Method Description: This Method receives CSV File and returns it's lines as List of String.
    Method Parameters: String
    Method Return Type: List of String
    ################################################################################################
     */


    public static List<String> readCSV(String csvFilePath) {
        List<String> lines = null;
        File file = new File(csvFilePath);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error reading from CSV File, see details: " + e);
        }
        return lines;
    }



}
