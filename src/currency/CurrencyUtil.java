// Java II
// Homework IV Solution
// 10/04/2019

package currency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * The class with the CurrencySet object.
 *
 * The CurrencySet object handles and stores the Set of Currency objects
 * from the given imported file.
 *
 * @author Nathan C. Sellars
 */
public final class CurrencyUtil {

    /**
     * The Currency URL for this Currency object.
     */
    private static final String CURRENCY_URL =
            "https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/821421/exrates-monthly-0819.csv?_ga=2.78586135.2020714709.1566697421-543342572.1565882375";

    /**
     * The save file name for this Currency object.
     */
    private static final String SAVE_FILE_NAME = "currency_conversions.dat";

    /**
     * The tab delimiter for the tab delimited save file.
     */
    private static final char SAVE_FILE_DELIMITER = '\t';

    /**
     * The parse delimiter for this Currency object.
     */
    private static final char PARSE_DELIMITER = ',';

    /**
     * The date format for parsing {@link LocalDate} objects and
     * for formatting those objects in the save file.
     */
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * The save file format for this Currency object.
     */
    private static final String SAVE_FILE_FORMAT = "%s%c%s%c%s%c%f%c%s%c%s";

    /**
     * The CurrencySet object to store and handle Currency objects.
     */
    private static final Set<Currency> currencies = new LinkedHashSet<>();

    /**
     * If this {@link CurrencyUtil} class fails to instantiate, an
     * {@link UnsupportedOperationException} will be thrown.
     *
     * @throws UnsupportedOperationException if the class cannot be created.
     */
    private CurrencyUtil() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot create this class");
    }

    /**
     * Parses a line read from the {@link CurrencyUtil#CURRENCY_URL} and
     * returns a new Currency object.
     *
     * @param line the line to parse from the {@link CurrencyUtil#CURRENCY_URL}.
     *
     * @return the new Currency object.
     *
     * @throws NullPointerException if the line is <code>null</code>.
     */
    private static Currency parseCurrency(String line) {
        Objects.requireNonNull(line, "Line cannot be null.");
        var tokens = line.split(Character.toString(PARSE_DELIMITER));
        var countryName = tokens[0];
        var currencyName = tokens[1];
        var currencyCode = tokens[2];
        var exchangeRate = Double.parseDouble(tokens[3]);
        var startDateString = tokens[4];
        var formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        var startDate = LocalDate.parse(startDateString, formatter);
        var endDateString = tokens[5];
        var endDate = LocalDate.parse(endDateString, formatter);
        return new Currency(
                countryName,
                currencyName,
                currencyCode,
                exchangeRate,
                startDate,
                endDate);
    }

    /**
     * Takes the country name, currency name, currency code, exchange rate,
     * start date, and end date of the Currency object and puts them into
     * a formatted file string representation for the save file,
     * {@link CurrencyUtil#SAVE_FILE_NAME}.
     *
     * @param currency the Currency object to format.
     *
     * @return the formatted file string of the Currency object.
     */
    private static String toFileString(Currency currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        return String.format(
                SAVE_FILE_FORMAT,
                currency.getCountryName(),
                SAVE_FILE_DELIMITER,
                currency.getCurrencyName(),
                SAVE_FILE_DELIMITER,
                currency.getCurrencyCode(),
                SAVE_FILE_DELIMITER,
                currency.getExchangeRate(),
                SAVE_FILE_DELIMITER,
                currency.getStartDate(),
                SAVE_FILE_DELIMITER,
                currency.getEndDate());
    }

    /**
     * Gets Currency objects from the given {@link CurrencyUtil#CURRENCY_URL}.
     */
    public static Set<Currency> getCurrencies() {
        try (var input = new Scanner(
                new BufferedReader(
                        new InputStreamReader(
                                new URL(CURRENCY_URL).openStream())))) {
            input.nextLine();
            while (input.hasNextLine()) {
                var line = input.nextLine();
                currencies.add(parseCurrency(line));
            }
        } catch (IOException iOEx) {
            System.err.println(iOEx.getMessage());
        }
        return currencies;
    }

    /**
     * Saves Currency objects to a file, {@link CurrencyUtil#SAVE_FILE_NAME}.
     */
    public static void saveCurrencies() {
        try (var output =
                     new PrintWriter(
                             new BufferedWriter(
                                     new FileWriter(SAVE_FILE_NAME)))) {
            for (var currency : currencies) {
                output.println(toFileString(currency));
            }
        } catch (IOException iOEx) {
            System.err.println(iOEx.getMessage());
            System.out.println("Unable to save items to file, try again.");
        }
        System.out.println("File written and items saved successfully.");
    }
}