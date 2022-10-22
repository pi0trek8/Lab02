package org.pwr.dataaccess.impl;

import org.pwr.dataaccess.DataAccess;
import org.pwr.dataaccess.readfile.FileReader;
import org.pwr.dataaccess.writefile.FileWriter;

import java.util.List;

public class DataAccessImpl implements DataAccess {

    private final FileReader fileReader;

    private final FileWriter fileWriter;

    public DataAccessImpl(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    @Override
    public List<String> readFromFile(String fileName) {
        return fileReader.readFromFile(fileName);
    }

    @Override
    public void writeToFile(String fileName, String results) {
        fileWriter.writeToFile(fileName, results);
    }


}
