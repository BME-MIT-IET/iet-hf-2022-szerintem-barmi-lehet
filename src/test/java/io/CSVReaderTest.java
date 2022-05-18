package io;

import org.junit.Test;
import java.io.IOException;

public class CSVReaderTest {

    @Test(expected = IOException.class)
    public void checkRead() throws Exception {
        CSVReader myReader = new CSVReader();
        myReader.read("abc.txt");
    }
}