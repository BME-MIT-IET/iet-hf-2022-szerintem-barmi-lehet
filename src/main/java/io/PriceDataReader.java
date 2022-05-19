package io;

import tseries.TimeSeries;

import java.io.IOException;

public abstract class PriceDataReader {
    protected String filePath;

    PriceDataReader(String file) {
        this.filePath = file;
    }
    public abstract TimeSeries read() throws IOException;
}
