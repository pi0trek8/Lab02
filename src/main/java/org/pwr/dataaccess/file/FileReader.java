package org.pwr.dataaccess.file;

import java.util.List;


public interface FileReader {
    List<String> readFromFile(String fileName);
}
