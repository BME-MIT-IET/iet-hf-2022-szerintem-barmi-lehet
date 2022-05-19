package io;

import price.Price;
import tseries.TimeSeries;
import java.io.IOException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader extends PriceDataReader {

    public JSONReader(String file) {
        super(file);
    }

    public TimeSeries read() throws IOException {

        JSONParser jsonParser = new JSONParser();
        TimeSeries tseries = new TimeSeries();
        TreeMap<LocalDateTime, Price> tmap = new TreeMap<>();

        try {

            JSONObject input = (JSONObject) jsonParser.parse(new FileReader(filePath));

            JSONArray jsonArray = (JSONArray) input.get("candles");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.000000000Z'", Locale.US);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                String stringTime = (String)jsonObject.get("time");
                LocalDateTime time = LocalDateTime.parse(stringTime, formatter);

                JSONObject priceJsonObject = (JSONObject)jsonObject.get("mid");

                Price price = new Price();
                price.setOpen ( Double.parseDouble( (String) priceJsonObject.get("o")) );
                price.setHigh ( Double.parseDouble( (String) priceJsonObject.get("h")) );
                price.setLow  ( Double.parseDouble( (String) priceJsonObject.get("l")) );
                price.setClose( Double.parseDouble( (String) priceJsonObject.get("c")) );

                tmap.put(time, price);

            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        tseries.setValues(tmap);
        return tseries;
    }




}
