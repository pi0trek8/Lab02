package org.pwr.dataaccess.impl;

import org.pwr.dataaccess.DataAccess;
import org.pwr.dataaccess.in.FileReader;
import org.pwr.dataaccess.out.FileWriter;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DataAccessImpl implements DataAccess {

    @Inject
    private FileReader fileReader;

    @Inject
    private FileWriter fileWriter;

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
