package tseries;

import indicator.SimpleMA;
import io.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class TimeSeriesTest {

    /// Attributes

    private TimeSeries mySeries = new TimeSeries();

    private CSVReader myReader = new CSVReader();


    /// Methods

    @Before
    public void setUp() throws Exception {

        mySeries = myReader.read("data/EURUSD_15m_2010-2016_v2.csv");

    }


    @Test
    public void checkGetLength() {

        Assert.assertEquals(245388, mySeries.getLength(), 0.01);

    }


    @Test
    public void checkConvert() {

        TimeSeries newSeries = new TimeSeries();

        newSeries = mySeries.convert("H1");

        LocalDateTime testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 4, 4, 00, 00);

        Assert.assertEquals(1.42889, newSeries.getValues().get(testDate_01).getClose(), 0.01);

    }


    @Test(expected = IllegalArgumentException.class)
    public void checkArgument() {

        TimeSeries newSeries = new TimeSeries();

        newSeries = mySeries.convert("B1");

    }


}