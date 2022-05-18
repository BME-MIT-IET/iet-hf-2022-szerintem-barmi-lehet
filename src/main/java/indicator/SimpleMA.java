package indicator;

import java.util.*;
import java.time.LocalDateTime;
import price.Price;
import tseries.TimeSeries;


public class SimpleMA extends MovingAverage{

    /// Attributes

    private Deque<Double> deque;

    private double sum;



    /// Methods

    // Constructor
    public SimpleMA(int size) {
        this.windowSize = size;
        this.deque = new ArrayDeque<>();
        this.sum = 0.0;
        this.values = new TreeMap<>();
    }


    public void calc(TimeSeries inputSeries, String appliedPrice) throws IllegalArgumentException {

        Set set = inputSeries.getValues().entrySet();
        Iterator it = set.iterator();

        double priceValue;


        while ( it.hasNext() ) {

            Map.Entry map_entry = (Map.Entry) it.next();

            LocalDateTime date = (LocalDateTime) map_entry.getKey();
            Price p = (Price) map_entry.getValue();

            if (appliedPrice.equals("Close"))
                priceValue = p.getClose();

            else {
                throw new IllegalArgumentException("Az eljárás egyelőre csak záróárra [Close] alkalmazható!");
            }

            if(deque.size() == this.windowSize)
                sum = sum - deque.removeFirst();
            sum = sum + priceValue;
            deque.add(priceValue);

            this.values.put(date, sum / deque.size());

        }

    }
}





