package indicator;

import io.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tseries.TimeSeries;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class ExponentialMATest {

    // Attributes

    private TimeSeries priceSeries = new TimeSeries();

    private CSVReader myReader = new CSVReader("data/EURUSD_15m_2010-2016_v2.csv");

    private ExponentialMA myEMA = new ExponentialMA(20);



    // Methods

    @Before
    public void setUp() throws Exception {

        priceSeries = myReader.read();

    }


    @Test
    public void checkSmooth() {

        Assert.assertEquals(0.095238, myEMA.getAlpha(), 0.000001);

    }


    @Test
    public void checkCalc() {

        myEMA.calc(priceSeries, "Close");

        LocalDateTime testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 1, 7, 30, 00);

        Assert.assertEquals(1.432941, myEMA.getValues().get(testDate_01), 0.000001);


    }


    @Test(expected = IllegalArgumentException.class)
    public void checkArgument() {

        myEMA.calc(priceSeries, "Min");

    }


}