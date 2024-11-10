package com.jdbc.automation.executor.AA_Clone_70_Users.Common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatusOutput {
    public static void writeInText(String filePath,String status) {
        BufferedWriter writer = null;

        try {
            // Specify the file path
//            String filePath = "D://Gurukul_test//output.txt";

            // Create a BufferedWriter object to write to the file
            writer = new BufferedWriter(new FileWriter(filePath));

            // Write some data to the file

            writer.write(status);
            writer.write("\n");

            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    // Close the BufferedWriter
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

