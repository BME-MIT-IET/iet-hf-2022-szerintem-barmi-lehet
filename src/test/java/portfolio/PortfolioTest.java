package portfolio;

import optimizer.Optimizer;
import io.CSVReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PortfolioTest {

    /// Attributes

    private Optimizer myOptimizer;



    /// Methods

    @Before
    public void setUp() throws Exception {

        myOptimizer = new Optimizer(11, 11, 54, 54, 201, 201, "Simple", new CSVReader("data/EURUSD_15m_2010-2016_v2.csv"));

        myOptimizer.importData();

        myOptimizer.initTraders();

        myOptimizer.maxProfit();

    }


    @Test
    public void checkWinnigRatio() {
        Assert.assertEquals(myOptimizer.getBestWR(), 36.13053, 0.01);
    }


    @Test
    public void checkNetProfit() {
        Assert.assertEquals(myOptimizer.getBestNetProfit(), 73056, 0.1);

    }


}