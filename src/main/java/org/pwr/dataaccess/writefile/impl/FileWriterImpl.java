package org.pwr.dataaccess.writefile.impl;

import org.pwr.dataaccess.writefile.FileWriter;

import java.io.BufferedWriter;
import java.io.IOException;

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
