package org.pwr.service;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;

import java.util.List;

public interface FileService {

    List<JugEto> getJugs(String fileName);

    List<PersonEto> getPeople(String fileName);

    boolean saveResults(String fileName, List<Object> results);

}
