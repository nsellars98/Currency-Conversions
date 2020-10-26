// Java II
// Homework IV Solution
// 10/04/2019

package currency;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The class with the Currency Object.
 *
 * A simple Currency object with a country name, currency name, currency code, exchange
 * rate, start date, and end date. Each Currency object is immutable with the
 * country name, currency name, currency code, exchange rate, start date and
 * end date being set at the time of instantiation. The Currency object contains
 * methods to get the country name, currency name, currency code, exchange rate,
 * start date, and end date.
 *
 * @author Nathan C. Sellars
 */
public class Currency
        implements Comparable<Currency> {

    /**
     * The country name of this Currency object. The country name cannot be <code>null</code> nor can it
     * be empty. It must be a valid {@link String} object value.
     */
    private String countryName;

    /**
     * The currency name of this Currency object. The currency name cannot be <code>null</code> nor can it
     * be empty. It must be a valid {@link String} object value.
     */
    private String currencyName;

    /**
     * The currency code of this Currency object. The currency code cannot be <code>null</code> nor can it
     * be empty. It must be a valid {@link String} object value.
     */
    private String currencyCode;

    /**
     * The currency exchange rate of this Currency object. The currency exchange rate must be a valid
     * floating point {@link Double} value, Q > 0.0 .
     */
    private double exchangeRate;

    /**
     * The currency start date of this Currency object. The currency start date cannot be <code>null</code>
     * nor can it be empty. It must be a valid {@link LocalDate} object value.
     */
    private LocalDate startDate;

    /**
     * The currency end date of this Currency object. The currency end date cannot be <code>null</code>
     * nor can it be empty. It must be a valid {@link LocalDate} object value.
     */
    private LocalDate endDate;

    /**
     * Constructs and initializes a new {@link Currency} object with the given countryName, currencyName,
     * currencyCode, exchangeRate, startDate, and endDate values.
     *
     * @param countryName the country name of this Currency object.
     *
     * The country name of the Currency object must be a valid, non-null and non-empty {@link String}
     * object value.
     *
     * @param currencyName the currency name of this Currency object.
     *
     * The currency name of the Currency object must be a valid, non-null and non-empty {@link String}
     * object value.
     *
     * @param currencyCode the currency code of this Currency object.
     *
     * The currency code of the Currency object must be a valid, non-null and non-empty {@link String}
     * object value.
     *
     * @param exchangeRate the currency exchange rate of this Currency object.
     *
     * The exchange rate of the Currency object must be a valid floating point {@link Double}
     * value, Q > 0.0 .
     *
     * @param startDate the currency start date of this Currency object.
     *
     * The currency start date of the Currency object must be a valid, non-null and non-empty
     * {@link LocalDate} object value.
     *
     * @param endDate the currency end date of this Currency object.
     *
     * The currency end date of the Currency object must be a valid, non-null and non-empty
     * {@link LocalDate} object value.
     */
    public Currency(
            String countryName,
            String currencyName,
            String currencyCode,
            double exchangeRate,
            LocalDate startDate,
            LocalDate endDate) {
        this.setCountryName(countryName);
        this.setCurrencyName(currencyName);
        this.setCurrencyCode(currencyCode);
        this.setExchangeRate(exchangeRate);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    /**
     * Gets the country name associated with this Currency object.
     *
     * @return the country name of this Currency object.
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * Sets the country name of this Currency object. The given country name can neither be
     * <code>null</code> or empty. It must be a valid {@link String} object value.
     *
     * @param countryName the country name to be set.
     *
     * @throws NullPointerException if the country name is <code>null</code>.
     *
     * @throws IllegalArgumentException if the country name is empty.
     */
    private void setCountryName(String countryName) {
        Objects.requireNonNull(countryName, "The country name cannot be null.");

        if (countryName.length() == 0) {
            throw new IllegalArgumentException("The country name cannot be empty.");
        } // else, countryName is fine, doNothing();

        this.countryName = countryName;
    }

    /**
     * Gets the currency name associated with this Currency object.
     *
     * @return the currency name of this Currency object.
     */
    public String getCurrencyName() {
        return this.currencyName;
    }

    /**
     * Sets the currency name of this Currency object. The given currency name can neither be
     * <code>null</code> or empty. It must be a valid {@link String} object value.
     *
     * @param currencyName the currency name to be set.
     *
     * @throws NullPointerException if the currency name is <code>null</code>.
     *
     * @throws IllegalArgumentException if the currency name is empty.
     */
    private void setCurrencyName(String currencyName) {
        Objects.requireNonNull(currencyName, "The currency name cannot be null.");

        if (currencyName.length() == 0) {
            throw new IllegalArgumentException("The currency name cannot be empty.");
        } // else, currencyName is fine, doNothing();

        this.currencyName = currencyName;
    }

    /**
     * Gets the currency code associated with this Currency object.
     *
     * @return the currency code of this Currency object.
     */
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * Sets the currency code of this Currency object. The given currency code can neither be
     * <code>null</code> or empty. It must be a valid {@link String} object value.
     *
     * @param currencyCode the currency code to be set.
     *
     * @throws NullPointerException if the currency code is <code>null</code>.
     *
     * @throws IllegalArgumentException if the currency code is empty.
     */
    private void setCurrencyCode(String currencyCode) {
        Objects.requireNonNull(currencyCode, "The currency code cannot be null.");

        if (currencyCode.length() == 0) {
            throw new IllegalArgumentException("The currency code cannot be empty.");
        } // else, currencyCode is fine, doNothing();

        this.currencyCode = currencyCode;
    }

    /**
     * Gets the currency exchange rate associated with this Currency object.
     *
     * @return the currency exchange rate of this Currency object.
     */
    public double getExchangeRate() {
        return this.exchangeRate;
    }

    /**
     * Sets the currency exchange rate of this Currency object. The given currency exchange rate
     * must be a valid floating point {@link Double} value, Q > 0.0 .
     *
     * @param exchangeRate the currency exchange rate to be set.
     *
     * @throws IllegalArgumentException if the currency exchange rate is an invalid value.
     */
    private void setExchangeRate(double exchangeRate) {
        if (Double.compare(exchangeRate, 0.0) < 0) {
            throw new IllegalArgumentException("Invalid exchange rate, must be Q > 0.0.");
        } // else, exchangeRate is valid, doNothing();

        this.exchangeRate = exchangeRate;
    }

    /**
     * Gets the currency start date associated with this Currency object.
     *
     * @return the currency start date of this Currency object.
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the currency start date of this Currency object. The given currency start
     * date can neither be <code>null</code> or empty. It must be a valid {@link LocalDate}
     * object value.
     *
     * @param startDate the currency start date to be set.
     *
     * @throws NullPointerException if the currency start date is <code>null</code>.
     */
    private void setStartDate(LocalDate startDate) {
        Objects.requireNonNull(startDate, "The currency start date cannot be null.");

        this.startDate = startDate;
    }

    /**
     * Gets the currency end date associated with this Currency object.
     *
     * @return the currency end date of this Currency object.
     */
    public LocalDate getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the currency end date of this Currency object. The given currency end
     * date can neither be <code>null</code> or empty. It must be a valid {@link LocalDate}
     * object value.
     *
     * @param endDate the currency end date to be set.
     *
     * @throws NullPointerException if the currency end date is <code>null</code>.
     */
    private void setEndDate(LocalDate endDate) {
        Objects.requireNonNull(endDate, "The currency end date cannot be null.");

        this.endDate = endDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                this.countryName,
                this.currencyName,
                this.currencyCode,
                this.exchangeRate,
                this.startDate,
                this.endDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Currency)) return false;
        final var that = (Currency) obj;
        return Objects.equals(this.countryName, that.countryName) &&
                Objects.equals(this.currencyName, that.currencyName) &&
                Objects.equals(this.currencyCode, that.currencyCode) &&
                Double.compare(this.exchangeRate, that.exchangeRate) == 0 &&
                Objects.equals(this.startDate, that.startDate) &&
                Objects.equals(this.endDate, that.endDate);
    }

    /**
     * Takes the country name and currency code of this Currency object with the
     * given values and puts them into a formatted string representation on the form.
     *
     * @return the formatted string representation of this Currency object.
     */
    @Override
    public String toString() {
        return String.format(
                "%s, %s",
                this.getCountryName(),
                this.getCurrencyCode());
    }

    /**
     * Compares Currency objects based on their name attribute and checks for
     * natural ordering with a checker variable.
     *
     * @param currency the checker variable for this Currency object.
     *
     * @return the currency name of this Currency object compared to the checker
     * variable.
     */
    @Override
    public int compareTo(Currency currency) {
        Objects.requireNonNull(currency);
        return this.getCurrencyName().compareTo(currency.getCurrencyName());
    }
}