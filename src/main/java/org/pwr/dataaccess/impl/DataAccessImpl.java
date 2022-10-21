package org.pwr.dataaccess.impl;

import org.pwr.dataaccess.DataAccess;
import org.pwr.dataaccess.file.FileReader;
import org.pwr.dataaccess.out.FileWriter;

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
    public void writeToFile(String fileName, List<String> data) {
        fileWriter.writeToFile(fileName, data);
    }


}
