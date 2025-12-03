package pluralsight.userInterface;

public class LoanCalculator {

    public static double calculateMonthlyPayment(double interestRate , double principle , int loanTerm){

        //principle = the loan amount dollars
        //interest rate = the  annual interest rate as a percent
        //loan term  = the loan term in months (how long is it)

        //Turn interest rate from percent to decimal so we can work with it
        interestRate = interestRate/100;

        //Interest Rate per month (12 months in a year)
        double monthlyInterestRate = interestRate / 12;

        //shorthand for our equation
        //1+ monthlyInterestRate = 0.05 + 1 = 1.05
        //loanTerm is passed to us but could be 48 months
        double powerTerm = Math.pow((1 + monthlyInterestRate), loanTerm);

        return principle * (monthlyInterestRate * powerTerm / (powerTerm - 1));

    }

}
