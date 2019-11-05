package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener() {
            calculateLoan()
        }
    }

    private fun calculateLoan() {

        if (editTextCarPrice.text.isEmpty()) {
            editTextCarPrice.setError(getString(R.string.input_error))
            return
        } else if (editTextDownPayment.text.isEmpty()) {
            editTextDownPayment.setError((getString(R.string.input_error)))
            return
        } else if (editTextInterestRate.text.isEmpty()) {
            editTextInterestRate.setError((getString(R.string.input_error)))
            return
        } else if (editTextLoanPeriod.text.isEmpty()) {
            editTextLoanPeriod.setError((getString(R.string.input_error)))
            return
        }

        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        if (downPayment > carPrice) {
            editTextDownPayment.setError((getString(R.string.downPayment_error)))
            return
        }
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val interestRate: Float = editTextInterestRate.text.toString().toFloat()
        val carLoan: Int = carPrice - downPayment
        val interest: Float = carLoan * interestRate/100 * loanPeriod
        val monthlyRepayment: Float = (carLoan + interest) / loanPeriod / 12

        textViewLoan.text = String.format("%s %d",getString(R.string.loan),carLoan)
        textViewInterest.text = String.format("%s %.2f",getString(R.string.interest), interest)
        textViewMonthlyRepayment.text = String.format("%s %.2f",getString(R.string.monthly_repayment), monthlyRepayment)

    }

    fun reset(view: View) {

    }
}
