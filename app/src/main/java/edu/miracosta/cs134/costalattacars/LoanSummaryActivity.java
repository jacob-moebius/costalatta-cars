package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {

    private final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Extract data from the
        double carPrice, downPayment;
        int loanTerm;

        Intent intent = getIntent();
        carPrice = intent.getDoubleExtra("CarPrice", 0.0);
        downPayment = intent.getDoubleExtra("DownPayment", 0.0);
        loanTerm = intent.getIntExtra("LoanTerm", 0);

        // Send data to the Model (CarLoan)
        CarLoan carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        // Populate TextViews with data from carLoan Model
        // Wire up Views
        TextView monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        monthlyPaymentTextView.setText(currency.format(carLoan.monthlyPayment()));
        TextView carPriceTextView = findViewById(R.id.carPriceTextView);
        carPriceTextView.setText(currency.format(carLoan.getPrice()));
        TextView salesRateTextView = findViewById(R.id.salesRateTextView);
        salesRateTextView.setText(String.valueOf(CarLoan.getOceansideTaxRate()));
        TextView taxAmountTextView = findViewById(R.id.taxAmountTextView);
        taxAmountTextView.setText(currency.format(carLoan.taxAmount()));
        TextView borrowedAmountTextView = findViewById(R.id.borrowedAmountTextView);
        borrowedAmountTextView.setText(currency.format(carLoan.borrowedAmount()));
        TextView interestAmountTextView = findViewById(R.id.interestAmountTextView);
        interestAmountTextView.setText(currency.format(carLoan.interestAmount()));
        TextView totalCostTextView = findViewById(R.id.totalCostTextView);
        totalCostTextView.setText(currency.format(carLoan.borrowedAmount()));
    }

    // onClick returns to main screen
    public void returnToMain(View V) {
        // Done with LoanSummaryActivity, so "finish" it
        finish();
    }
}
