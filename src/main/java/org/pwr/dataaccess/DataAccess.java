package org.pwr.dataaccess;

import org.pwr.dataaccess.in.FileReader;
import org.pwr.dataaccess.out.FileWriter;

import javax.inject.Named;

public interface DataAccess
        extends FileReader, FileWriter {
}
