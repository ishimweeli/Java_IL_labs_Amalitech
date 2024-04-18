package com.eliab.currencyconverter.services.impl.utils.datafetcher;

import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

@Component
public class ECBDataFetcher implements DataFetcher {
    // Chosen this as this can be the most reliable source of data.
    private final String ECB_DATA_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    private HashMap<String, Double> currencyMap = new HashMap<>(40);

    private HashMap<String, Double> getECBConversionDataMap() {
        currencyMap.clear();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean inCube = false;

                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes) throws SAXException {
                        inCube = true;
                        String currency = attributes.getValue("currency");
                        String rate = attributes.getValue("rate");
                        if (currency != null && rate != null) {
                            try {
                                currencyMap.put(currency, Double.parseDouble(rate));

                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    }

            };
            URL url = new URL(ECB_DATA_URL);
            saxParser.parse(new InputSource(url.openStream()), handler);
            currencyMap.put("EUR", 1.0);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return currencyMap;
    }


    public Double getConversionRate(String fromCurrency, String toCurrency) {

            HashMap<String, Double> currencyMap = getECBConversionDataMap();
            Double conversionRate = currencyMap.get(toCurrency) / currencyMap.get(fromCurrency);
            return conversionRate;





    }
}
