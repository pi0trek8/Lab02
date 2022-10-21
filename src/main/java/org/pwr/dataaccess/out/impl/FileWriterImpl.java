package org.pwr.dataaccess.out.impl;

import org.pwr.dataaccess.out.FileWriter;

import javax.inject.Named;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Named
public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String fileName, List<String> data) {
        try(PrintWriter printWriter
                    = new PrintWriter(new java.io.FileWriter(fileName)))
        {
            printWriter.println(" ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
