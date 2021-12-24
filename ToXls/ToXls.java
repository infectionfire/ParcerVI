package TestPackage.ToXls;



import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ToXls {
    public static void DelimitedToXls(String fileName) {

        String csvFileName = "csvFile.csv";


        try (BufferedReader br = new BufferedReader(new FileReader(fileName));

             Writer writer = new FileWriter(csvFileName)) {
            String line;
            while ((line = br.readLine()) != null) {
                String csvLine = Arrays.stream(line.split("[|]")) // split on pipes
                        .map(token -> token.contains(",") ? "\""+token+"\"" : token) // surround with double quotes if there is a comma in the value
                        .collect(Collectors.joining(",", "", "\n")); // join with commas
                writer.append(csvLine);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
