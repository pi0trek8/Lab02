package org.pwr.dataaccess.in;

import javax.inject.Named;
import java.util.List;


public interface FileReader {

    List<String> readFromFile(String fileName);

}
