package trader;

import io.CSVReader;
import org.junit.Before;
import org.junit.Test;
import tseries.TimeSeries;

import java.io.IOException;

public class TraderTest {

    CSVReader testReader;

    TimeSeries testSeries;

    String testData = "data/EURUSD_15m_2010-2016_v2.csv";

    @Before
    public void init() {

        //abcd
        testReader = new CSVReader();
        testSeries = new TimeSeries();

        try {
            testSeries = testReader.read(testData);
        } catch (IOException e) {

        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void ctorTraderTest(){

        Trader myTrader = new Trader(testSeries, 20, 50, 150, "Arithmetic");

    }

}
