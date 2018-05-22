package model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    String sourceFileName,destFileName;

    public FileHandler(String fileName) {
        sourceFileName = fileName;
    }

    List<String[]> csv;
    // Function to return everything in the csv file
    // Parse the csv file
    public List<String[]> parseCSV()
            throws FileNotFoundException {

        // Contains all data from the csv file
        // Nested Arraylist called csv for each row
        csv = new ArrayList<String[]>();
        try{
            FileReader filereader = new FileReader(sourceFileName);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            String line="";

            // While loop using scanner to fill up the csv arraylist
            // So we get csv file column structure

            while((line = bufferedReader.readLine()) != null) {
                String[] tokens=line.split(",");
                csv.add(tokens);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file" + sourceFileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file" + sourceFileName + "'");
        }
        return csv;
    }

    public void writeFile(String fileName)
    {
        destFileName=fileName;
        FileWriter fileWriter=null;

        try {
            fileWriter=new FileWriter(destFileName,true);
            final String COMMA_DELIMITER = ",";
            final String NEW_LINE_SEPARATOR = "\n";


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();            }

        }
    }


}
