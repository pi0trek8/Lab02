package org.pwr.dataaccess.readfile;

import java.util.List;


public interface FileReader {
    List<String> readFromFile(String fileName);
}
