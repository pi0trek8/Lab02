package org.pwr.dataaccess.file.impl;

import org.pwr.dataaccess.file.FileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    public List<String> readFromFile(String fileName)
    {
        List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            String line;

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " is not found!");
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
