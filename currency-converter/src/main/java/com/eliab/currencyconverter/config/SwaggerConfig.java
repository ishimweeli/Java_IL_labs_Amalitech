package com.eliab.currencyconverter.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@Info(title = "CURRENCY CONVERTER", version = "3.0", description = "CURRENCY CONVERTER API documentation:" +
        " \"EUR\": \"Euro\", \"USD\": \"US Dollar\", \"JPY\": \"Japanese Yen\", \"BGN\": \"Bulgarian Lev\", " +
        "\"CZK\": \"Czech Koruna\"," +
        " \"DKK\": \"Danish Krone\", \"GBP\": \"British Pound\", \"HUF\": \"Hungarian Forint\", " +
        "\"PLN\": \"Polish Zloty\", \"RON\": \"Romanian Leu\", \"SEK\": \"Swedish Krona\", " +
        "\"CHF\": \"Swiss Franc\", \"NOK\": \"Norwegian Krone\", \"HRK\": \"Croatian Kuna\", " +
        "\"RUB\": \"Russian Ruble\", \"TRY\": \"Turkish Lira\", \"AUD\": \"Australian Dollar\"," +
        " \"BRL\": \"Brazilian Real\", \"CAD\": \"Canadian Dollar\", \"CNY\": \"Chinese Yuan Renminbi\", " +
        "\"HKD\": \"Hong Kong Dollar\", \"IDR\": \"Indonesian Rupiah\", \"ILS\": \"Israeli Shekel\"," +
        " \"INR\": \"Indian Rupee\", \"KRW\": \"South Korean Won\", \"MXN\": \"Mexican Peso\", \"MYR\": " +
        "\"Malaysian Ringgit\", \"NZD\": \"New Zealand Dollar\", \"PHP\": \"Philippine Peso\", \"SGD\":" +
        " \"Singapore Dollar\", \"THB\": \"Thai Baht\", \"ZAR\": \"South African Rand\""))


public class SwaggerConfig {

}
