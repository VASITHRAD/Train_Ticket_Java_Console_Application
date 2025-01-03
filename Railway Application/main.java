import java.util.Scanner;
class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("TRAIN TICKET BOOKING");
            System.out.println("Please select an option from below :");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Print Available Tickets");
            System.out.println("5. Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Please fill the below details");
                    System.out.println("Enter number of passangers :");
                    int noOfPassanger = sc.nextInt();
                    for(int i = 1; i<=noOfPassanger; i++){
                        System.out.println("Enter the name of Passanger "+i);
                        String passangerName = sc.next().toUpperCase();
                        System.out.println("Enter the age of Passanger "+i);
                        int Age = sc.nextInt();
                        while(Age<=0){
                            System.out.println("Enter a valid age");
                            Age = sc.nextInt();
                        }
                        System.out.println("Enter the gender of Passanger "+i);
                        String gender = sc.next().toUpperCase();
                        System.out.println("Enter the prefered berth (L  or M or U) for Passanger "+i);
                        String preferedBerth = sc.next().toUpperCase();
                        PassangerDetails pd = new PassangerDetails("", 0, "", "");
                        pd.setName(passangerName);
                        pd.setAge(Age);
                        pd.setGender(gender);
                        pd.setBerth(preferedBerth);
                        String ticketCheck = functions.addPassanger(pd);
                        if(ticketCheck.equals("0")){
                            break;
                        }
                        
                    }
                    break;
                case 2:
                    System.out.println("Enter the details of the ticket which needs to be deleted ");
                    System.out.println("Enter the name under which the ticket was booked : ");
                    String name = sc.next().toUpperCase();
                    System.out.println("Enter the Age of the passanger :");
                    int age = sc.nextInt();
                    System.out.println("Enter the Gender of the passanger :");
                    String gender = sc.next().toUpperCase();
                    functions.delete(name, age, gender);
                    break;
                case 3:
                    System.out.println("Displaying the Booked Tickets");
                    functions.Display();
                    break;
                case 4:
                    System.out.println("Printing Available Tickets");
                    functions.availableTickets();
                    break;
                case 5:
                    System.out.println("Visit Again!!! BYE.....");
                    System.exit(1);
                default:
                    break;
            }
        }
    }
}