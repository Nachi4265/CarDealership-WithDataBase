package pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {



    @Test       //MethodYourTesting_StateUnderTest_TheExpectedBehavior
    public void GetAllVehicles_ReturnALLVehiclesInInventory_AllVehiclesAreDisplayed(){

        //arrange
        Dealership dealership = new Dealership("Guy Cars","123Road","703-290-3082");


        //act
        dealership.getAllVehicles();


        //assert
        assertArrayEquals(Vehicle);

    }



}