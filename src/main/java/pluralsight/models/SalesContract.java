package pluralsight.models;

import pluralsight.userInterface.LoanCalculator;

public class SalesContract extends Contract {

    private String contractType;
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;



    //The contract only has the information that user would need, no business side.
    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {

        super(contractDate, customerName, customerEmail, vehicleSold);
        this.salesTax = getVehicleSold().getPrice() * 0.05; //sales tax is 5% of the Vehicles Price
        this.recordingFee = 100.00; //• Recording Fee ($100)
        this.processingFee = (vehicleSold.getPrice() < 10_000) ? 295 : 495 ; //• Processing fee ($295 for vehicles under $10,000 and $495 for all others
        this.finance = finance; //• Monthly payment (if financed)

    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override public double getMonthlyPayment(){
        //• All loans are at 4.25% for 48 months if the price is $10,000 or more
        //• Otherwise they are at 5.25% for 24 month
        //if you want to finance here are your options
        //if the vehicles price is more than 10,000 the loan is for 48 months at 4.25%
        //if NOT (else) The loan is for 24 months at 5.25%

        if(finance){
            if(getTotalPrice() >= 10_000){

               return LoanCalculator.calculateMonthlyPayment(4.25,getTotalPrice(),48);

            }else{

                return LoanCalculator.calculateMonthlyPayment(5.25,getTotalPrice(),24);

            }

        } else {

            return 0;

        }
    }

    @Override public double getTotalPrice(){
            // $295 or 495 + $100 + 5% of Vehicles price + Vehicles actual Price
        return processingFee + recordingFee + salesTax + getVehicleSold().getPrice();
    }
}
