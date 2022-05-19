package trader;

import io.CSVReader;
import org.junit.Before;
import org.junit.Test;
import tseries.TimeSeries;

import java.io.IOException;

public class TraderTest {

    CSVReader testReader;

    TimeSeries testSeries;

    @Before
    public void init() {

        //abcd
        testReader = new CSVReader("data/EURUSD_15m_2010-2016_v2.csv");
        testSeries = new TimeSeries();

        try {
            testSeries = testReader.read();
        } catch (IOException e) {

        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void ctorTraderTest(){

        Trader myTrader = new Trader(testSeries, 20, 50, 150, "Arithmetic");

    }

}
