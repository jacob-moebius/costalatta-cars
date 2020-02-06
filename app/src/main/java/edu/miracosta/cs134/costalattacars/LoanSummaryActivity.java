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

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private TextView carPriceTextView;
    private TextView downPaymentEditText;

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
        carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        // Populate TextViews with data from carLoan Model
        // Wire up Views
        carPriceTextView = findViewById(R.id.carPriceTextView);
        carPriceTextView.setText(String.valueOf(carLoan.getPrice()));
        //downPaymentEditText = findViewById(R.id.downPaymentEditText);

    }

    // onClick returns to main screen
    public void returnToMain(View V) {
        // Done with LoanSummaryActivity, so "finish" it
        finish();
    }
}
