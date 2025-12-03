//package pluralsight.userInterface;

//public class AdminUserInterface {
//
//    public void adminDisplay() {
//
//        if(enterPassword()){
//
//            while (true){
//                System.out.println("========| Admin Menu |========");
//                System.out.println("Please choose and option");
//                System.out.println("1) List all Contracts");
//                System.out.println("2) List Last 10 Contracts");
//                System.out.println("3) Return to Dealership Menu");
//
//                int command = InputCollector.promptForInt("Enter command");
//
//                switch (command){
//                    case 1:
//                        listAllContracts();
//                        break;
//                    case 2:
//                        listLast10Contracts();
//                        break;
//                    case 3:
//                        return;
//                    default:
//                        System.out.println("Invalid command!");
//                }
//            }
//        } Z
//            //Return to Dealership UI
//        }
//    }
//
//    public boolean enterPassword(){
//        System.out.println("Welcome to Dealership Admin terminal");
//        System.out.println("------------------------------------");
//
//        String correctPassword = "Car123";
//        int attempts = 3;
//        boolean authenticated = false;
//
//
//        while (!authenticated){
//            String passwordEntered = InputCollector.promptForString("Enter password");
//
//            if(passwordEntered.equalsIgnoreCase(correctPassword)){
//                authenticated = true;
////                adminDisplay();
//
//            }else if(attempts>1){
//                attempts -= 1 ;
//                System.out.println("Incorrect password Access denied");
//                System.out.println("You have " + attempts + " attempts left");
//            }else{
//                System.out.println("YOU ARE OUT OF ATTEMPTS RETURNING TO DEALERSHIP!");
//                return false;
//            }
//        }
//        return authenticated;
//    }
//
//    private void listLast10Contracts() {
//    }
//
//    private void listAllContracts() {
//    }


//}
