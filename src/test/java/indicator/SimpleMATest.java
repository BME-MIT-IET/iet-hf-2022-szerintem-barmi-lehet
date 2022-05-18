package indicator;

import io.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tseries.TimeSeries;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class SimpleMATest {

    private TimeSeries priceSeries = new TimeSeries();

    private CSVReader myReader = new CSVReader();

    private SimpleMA mySMA = new SimpleMA(20);


    @Before
    public void setUp() throws Exception {

        priceSeries = myReader.read("data/EURUSD_15m_2010-2016_v2.csv");

    }


    @Test
    public void checkCalc() {

        mySMA.calc(priceSeries, "Close");

        LocalDateTime testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 1, 4, 45, 00);

        Assert.assertEquals(1.432722, mySMA.getValues().get(testDate_01), 0.000001);

    }


    @Test(expected = IllegalArgumentException.class)
    public void checkArgument() {

        mySMA.calc(priceSeries, "High");

    }



}