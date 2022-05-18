package io;

import tseries.TimeSeries;

import java.io.IOException;

public interface PriceDataReader {
    public TimeSeries read (String fileName) throws IOException;
}
