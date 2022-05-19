package steps;

import indicator.ExponentialMA;
import indicator.SimpleMA;
import io.CSVReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import optimizer.Optimizer;
import org.junit.Assert;
import trader.Trader;
import tseries.TimeSeries;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

public class MyStepdefs {
    private TimeSeries priceSeries = new TimeSeries();

    private CSVReader myReader = new CSVReader();

    private SimpleMA mySMA = new SimpleMA(20);
    private LocalDateTime testDate_01;

    private ExponentialMA myEMA = new ExponentialMA(20);
    private Optimizer myOptimizer;
    private TimeSeries mySeries;
    private TimeSeries newSeries;


    @Given("The reader reads")
    public void theReaderReads() throws IOException {
        priceSeries = myReader.read("data/EURUSD_15m_2010-2016_v2.csv");
    }

    @When("Calculate simpleMa with given time")
    public void calculateSimpleMaWithGivenTime() {
        mySMA.calc(priceSeries, "Close");
        testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 1, 4, 45, 00);
    }

    @Then("Calculated simple value equals expected")
    public void calculatedSimpleValueEqualsExpected() {
        Assert.assertEquals(1.432722, mySMA.getValues().get(testDate_01), 0.000001);
    }

    @When("Calculate exponentialMa with given time")
    public void calculateExponentialMaWithGivenTime() {
        myEMA.calc(priceSeries, "Close");
        testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 1, 7, 30, 00);
    }

    @Then("Calculated exponential value equals expected")
    public void calculatedExponentialValueEqualsExpected() {
        Assert.assertEquals(1.432941, myEMA.getValues().get(testDate_01), 0.000001);
    }

    @Given("Optimizer with parameters")
    public void optimizerWithParameters() {
        myOptimizer = new Optimizer(20,21, 50,50,150,150, "Simple");
        myOptimizer.importData("data/EURUSD_15m_2010-2016_v2.csv");
        myOptimizer.initTraders();
    }

    @When("Optimizer calculates max winning rate")
    public void optimizerCalculatesMaxWinningRate() {
        myOptimizer.maxWR();
    }

    @Then("Best win rate equals expected amount")
    public void bestWinRateEqualsExpectedAmount() {
        Trader myBestTrader = myOptimizer.getBestTrader();
        int[] params = myBestTrader.getParamValues();
        Assert.assertEquals(21, params[0]);
        Assert.assertEquals(50, params[1]);
        Assert.assertEquals(150, params[2]);

    }

    @Given("An Optimizer")
    public void anOptimizer() {
        myOptimizer = new Optimizer(11, 11, 54, 54, 201, 201, "Simple");
        myOptimizer.importData("data/EURUSD_15m_2010-2016_v2.csv");
    }

    @When("Optimizer works")
    public void optimizerWorks() {
        myOptimizer.initTraders();
        myOptimizer.maxProfit();
    }

    @Then("Net profit equals expected amount")
    public void netProfitEqualsExpectedAmount() {
        Assert.assertEquals(myOptimizer.getBestNetProfit(), 73056, 0.1);
    }

    @Given("A TimeSeries Object")
    public void aTimeSeriesObject() throws IOException {
        mySeries = new TimeSeries();
        mySeries = myReader.read("data/EURUSD_15m_2010-2016_v2.csv");
    }

    @When("The Series object converts")
    public void theSeriesObjectConverts() {
        newSeries = mySeries.convert("H1");
        testDate_01 = LocalDateTime.of(2010, Month.JANUARY, 4, 4, 00, 00);
        Assert.assertEquals(1.42889, newSeries.getValues().get(testDate_01).getClose(), 0.01);
    }

    @Then("Converted value equals expected")
    public void convertedValueEqualsExpected() {
        Assert.assertEquals(1.42889, newSeries.getValues().get(testDate_01).getClose(), 0.01);
    }
}
