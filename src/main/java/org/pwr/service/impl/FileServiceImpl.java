package org.pwr.service.impl;

import org.pwr.dataaccess.DataAccess;
import org.pwr.dataaccess.impl.DataAccessImpl;
import org.pwr.dataaccess.file.impl.FileReaderImpl;
import org.pwr.dataaccess.out.impl.FileWriterImpl;
import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;
import org.pwr.mapper.AbstractMapper;
import org.pwr.service.FileService;

import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl extends AbstractMapper implements FileService {

//    @Inject
    private final DataAccess dataAccess = new DataAccessImpl(new FileReaderImpl(), new FileWriterImpl());

    @Override
    public List<JugEto> getJugs(String fileName) {
        List<String> dataFromFile = dataAccess.readFromFile(fileName);

        return dataFromFile.stream()
                .map(element ->  mapToJug(element.strip().split(";")))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonEto> getPeople(String fileName) {
        List<String> dataFromFile = dataAccess.readFromFile(fileName);

        List<PersonEto> people = dataFromFile.stream()
                .map(element -> mapToPerson(element.split(";")))
                .collect(Collectors.toList());

        return people;
    }

    @Override
    public void saveResults(String fileName, String results) {
        dataAccess.writeToFile(fileName, results);
    }
}
