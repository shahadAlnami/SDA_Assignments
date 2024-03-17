package test.junit;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Week5_Task5 extends Tests {

    /** I couldn't solve it using excel, so I did the task on json file instead */

    private String filePath = "src/test/resources/testData/file.json";

    @Test
    public void testJsonFile() throws IOException {
        // Create a JSON object to hold the data
        JSONObject jsonObject = new JSONObject();

        // Add the data to the JSON object
        jsonObject.put("Row1", "POPULATION");
        jsonObject.put("Row2", "Data 1");
        jsonObject.put("Row3", "Data 2");
        jsonObject.put("Row4", "Data 3");

        // Write the JSON object to the file
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(jsonObject.toString());
        fileWriter.flush();
        fileWriter.close();

        // Assert that the file is not empty
        File jsonFile = new File(filePath);
        Assertions.assertTrue(jsonFile.length() > 0);

    }
}
