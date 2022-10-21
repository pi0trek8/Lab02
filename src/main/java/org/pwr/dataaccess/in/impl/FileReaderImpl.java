package org.pwr.dataaccess.in.impl;

import org.pwr.dataaccess.in.FileReader;

import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Named
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
            System.out.println("An error occurred!");
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
