package org.pwr.dataaccess.readfile.impl;

import org.pwr.dataaccess.readfile.FileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            try (InputStream inputStream = getClass().getResourceAsStream(fileName);
                    BufferedReader scanner = new BufferedReader(new InputStreamReader(inputStream))){

                scanner.lines().forEach(lines::add);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    } catch (Exception e) {
            System.out.println("File " + fileName + " is not found!");
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
