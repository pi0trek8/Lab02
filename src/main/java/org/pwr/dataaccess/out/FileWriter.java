package org.pwr.dataaccess.out;

import javax.inject.Named;
import java.util.List;

@Named
public interface FileWriter {

    void writeToFile(String fileName, List<String> data);
}
