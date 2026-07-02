package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        LOGGER.info("START");

        SpringApplication.run(SpringLearnApplication.class, args);

        SpringLearnApplication app = new SpringLearnApplication();

        app.displayDate();
        app.displayCountry();
        app.displayCountries();

        LOGGER.info("END");
    }

    // Hands-on 2
    public void displayDate() {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context = null;

        try {

            context = new ClassPathXmlApplicationContext("date-format.xml");

            SimpleDateFormat format =
                    context.getBean("dateFormat", SimpleDateFormat.class);

            Date date = format.parse("31/12/2018");

            LOGGER.debug("Date : {}", date);

        } catch (Exception e) {

            LOGGER.error("Exception occurred", e);

        } finally {

            if (context != null) {
                context.close();
            }
        }

        LOGGER.info("END");
    }

    // Hands-on 4 & 5
    public void displayCountry() {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country", Country.class);

        LOGGER.debug("Country : {}", country);

        // Hands-on 5 (Singleton / Prototype Scope)
        Country anotherCountry =
                context.getBean("country", Country.class);

        LOGGER.debug("Another Country : {}", anotherCountry);

        context.close();

        LOGGER.info("END");
    }

    // Hands-on 6
    @SuppressWarnings("unchecked")
    public void displayCountries() {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        LOGGER.debug("Countries : {}", countries);

        context.close();

        LOGGER.info("END");
    }
}