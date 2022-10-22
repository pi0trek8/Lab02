package org.pwr.dataaccess.out.impl;

import org.pwr.dataaccess.out.FileWriter;

import javax.inject.Named;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Named
public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String fileName, String results) {
        try(BufferedWriter writer
                    = new BufferedWriter(new java.io.FileWriter(fileName)))
        {
            writer.write(results);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
