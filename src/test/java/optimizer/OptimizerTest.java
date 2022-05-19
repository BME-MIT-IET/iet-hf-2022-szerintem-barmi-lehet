package optimizer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trader.Trader;


public class OptimizerTest {

    Optimizer myOptimizer;


    @Before
    public void init(){

        myOptimizer = new Optimizer(20,21, 50,50,150,150, "Simple");

        myOptimizer.importData("data/EURUSD_15m_2010-2016_v2.csv");

        myOptimizer.initTraders();

    }


    @Test
    public void maxProfitTest(){

        // Arrange

        // Act
        myOptimizer.maxProfit();

        // Assert

        Trader myBestTrader = myOptimizer.getBestTrader();

        int[] params = myBestTrader.getParamValues();

        Assert.assertEquals(21, params[0]);
        Assert.assertEquals(50, params[1]);
        Assert.assertEquals(150, params[2]);

    }


    @Test
    public void maxProfitValueTest(){

        // Arrange

        // Act
        myOptimizer.maxProfit();

        // Assert
        Assert.assertEquals(-2792, myOptimizer.getBestNetProfit(), 10e-2);

    }


    @Test
    public void maxWRTest(){

        // Arrange

        // Act
        myOptimizer.maxWR();

        // Assert
        Trader myBestTrader = myOptimizer.getBestTrader();

        int[] params = myBestTrader.getParamValues();

        Assert.assertEquals(21, params[0]);
        Assert.assertEquals(50, params[1]);
        Assert.assertEquals(150, params[2]);

    }


    @Test
    public void maxWRValueTest(){

        // Arrange

        // Act
        myOptimizer.maxWR();

        // Assert
        Assert.assertEquals(33.19, myOptimizer.getBestWR(), 10e-1);

    }




}
