# Currency-Conversions
A JFX GUI form app to process currency conversions.

Disclaimer: This app does NOT have up-to-date currency values for the conversions. The values outlined in the corresponding Excel document were sampled from an online source within the 1/8/2019 - 31/08/2019 date time frame and were used for testing purposes only.

Link: https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/821421/exrates-monthly-0819.csv?_ga=2.78586135.2020714709.1566697421-543342572.1565882375

For more accurate conversions, a different Currency URL String may be used with the CurrencySet object.

The "libraries" folder contains the JavaFX jar files needed for compilation and runtime.

The "src" folder contains the core functionality of this JavaFX GUI form app. When running the app, the user, through a graphical interface, should be able to convert an amount of money between British pounds (GBP) and another currency provided in the corresponding Excel document.

The user interface contains two sets of labels/text boxes; one for entering the amount to be converted and the other to show the result, a drop-down menu (combo box) to allow the user to select the currency to which they wish to convert, and buttons to make the conversion, clear the amount in the amount text box, and to allow the user to export all the currency data to a tab delimited file.

A warning displays if the user enters an invalid amount for the currency via a dialog box and the results text box. The dialog box must be closed and the text box cleared before proceeding. Only valid numbers are accepted for the conversions.

Proof of test cases can be found in the corresponding Word document.

This app was developed with JetBrains IntelliJ IDEA (various versions) and ultilizes the JavaFX Library set (various versions).

Thanks for looking!
