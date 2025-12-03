package pluralsight.models;

import pluralsight.userInterface.LoanCalculator;

import java.util.PrimitiveIterator;

public class LeaseContract extends Contract {

    private int contractID;
    private double endingValue; //(50% of the original price)
    private double leaseFee; // (7% of the original price)

    public LeaseContract(int contractID, String contractDate, String customerName, String customerEmail,
                         Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);

        this.contractID = contractID;
        this.endingValue = vehicleSold.getPrice() / 2; // (50% of the original price)
        this.leaseFee = vehicleSold.getPrice() * 0.07; // (7% of the original price)
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    @Override public double getMonthlyPayment(){

        return LoanCalculator.calculateMonthlyPayment(4,getTotalPrice(),36);

    }

    @Override public double getTotalPrice() {

        return (getVehicleSold().getPrice() - endingValue) + leaseFee;
    }
}
