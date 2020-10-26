// Java II
// Homework IV Solution
// 10/04/2019

package currency;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This project will use a simple JavaFX GUI form to process currency
 * conversions.
 *
 * The class with the Main Form.
 *
 * @author Nathan C. Sellars
 */
public class MainForm
        extends Application {

    /**
     * The list of Currency objects from the CurrencySet Object.
     */
    private final List<Currency> currencies = new ArrayList<>();

    /**
     * The currency combo box graphical user interface widget for this form.
     */
    private ComboBox<Currency> currencyComboBox = new ComboBox<>();

    /**
     * The conversion amount text field graphical user interface widget for this form.
     */
    private TextField conversionAmountTextField = new TextField();

    /**
     * The conversion result text field graphical user interface widget for this form.
     */
    private TextField conversionsResultTextField = new TextField();

    /**
     * The localized number formatter for this Currency object.
     */
    private NumberFormat numberFormat = NumberFormat.getInstance();

    /**
     * Clears the given text fields on the graphical user interface form.
     */
    private void clearForm() {
        this.conversionAmountTextField.clear();
        this.conversionsResultTextField.clear();
    }

    /**
     * Gets a Currency object. The Currency object will have a country name,
     * currency name, currency code, currency exchange rate, currency start
     * date, and currency end date.
     *
     * @param type the type parameter for the switch case.
     *
     * @param countryName the country name of the Currency object.
     *
     * @param currencyName the currency name of the Currency object.
     *
     * @param currencyCode the currency code of the Currency object.
     *
     * @param exchangeRate the currency exchange rate of the Currency object.
     *
     * @param startDate the currency start date of the Currency object.
     *
     * @param endDate the currency end date of the Currency object.
     *
     * @return the new Currency object.
     */
    private Currency getCurrency(
            int type,
            String countryName,
            String currencyName,
            String currencyCode,
            double exchangeRate,
            LocalDate startDate,
            LocalDate endDate) {
        switch (type) {
            case 0:
                throw new UnsupportedOperationException("The class was not implemented correctly.");
            case 1:
                return new Currency(
                        countryName,
                        currencyName,
                        currencyCode,
                        exchangeRate,
                        startDate,
                        endDate);
            default:
                throw new IllegalArgumentException("Invalid type, try again.");
        }
    }

    /**
     * Verifies if a valid double currency exchange rate value has been
     * entered into the given text field.
     *
     * @param textField the text field to verify if we have a valid double.
     *
     * @return true if we have a valid double value for our currency exchange
     * rate, otherwise, false if not, and a warning for an invalid currency amount.
     *
     * @throws NullPointerException if value in the text field is <code>null</code>.
     */
    private boolean hasDouble(TextField textField) {
        Objects.requireNonNull(textField);
        try {
            Double.parseDouble(textField.getText());
            return true;
        } catch (NumberFormatException nFEx) {
            var alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Entry");
            alert.setHeaderText("You entered an incorrect value for the currency exchange rate.");
            alert.setContentText("The currency exchange rate must be a valid number value.");
            alert.showAndWait();
            return false;
        }
    }

    /**
     * The click event handler for converting Currency objects on the form.
     */
    private void convertClickHandler() {
        if (this.hasDouble(this.conversionAmountTextField)) {
            var currencyAmount = Double.parseDouble(this.conversionAmountTextField.getText());
            var selectedCurrency = this.currencyComboBox.getSelectionModel().getSelectedItem();

            var convertTo = (currencyAmount * selectedCurrency.getExchangeRate());
            this.conversionsResultTextField.setText(this.numberFormat.format(convertTo));

            var convertBackTo = (currencyAmount / selectedCurrency.getExchangeRate());
            this.conversionsResultTextField.setText(this.numberFormat.format(convertBackTo));
        } else {
            this.conversionsResultTextField.setText("Invalid value.");
        }
    }

    /**
     * The click event handler for saving Currency objects to a file.
     */
    private void saveToFileClickHandler() {
        CurrencyUtil.saveCurrencies();
    }

    /**
     * Starts the show for this graphical user interface application.
     *
     * @param stage the stage to set for the show.
     */
    @Override
    public void start( Stage stage ) {

        var pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        this.currencies.addAll(CurrencyUtil.getCurrencies());
        this.currencyComboBox.getItems().addAll(this.currencies);
        this.currencyComboBox.getSelectionModel().selectFirst();

        pane.add(this.currencyComboBox, 1, 0);

        pane.add(new Label("Amount:"), 0,1);
        pane.add(conversionAmountTextField, 1,1);

        pane.add(new Label("Result:"), 0, 2);
        pane.add(conversionsResultTextField, 1, 2);

        var clearButton = new Button("Clear");
        clearButton.setOnAction(event -> this.clearForm());
        pane.add(clearButton, 1, 3);

        var submitButton = new Button("Convert");
        submitButton.setOnAction(event -> this.convertClickHandler());
        pane.add(submitButton, 0, 3);

        var saveButton = new Button("Save to file");
        saveButton.setOnAction(event -> this.saveToFileClickHandler());
        pane.add(saveButton, 0, 0);

        Scene scene = new Scene(pane);

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The starting point for this application.
     *
     * @param args optional command line arguments (unused in this application).
     */
    public static void main( String[] args ) {
        launch();
    }
}