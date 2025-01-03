import java.util.ArrayList;

public class functions {
    
    static ArrayList<PassangerDetails> booked = new ArrayList<>();
    static int totalTickets = 3;
    static int totalBerth = 3;
    static int lowerBerthTotal = 1;
    static int middleBerthTotal = 1;
    static int upperBerthTotal = 1;
    static int RACTotal = 1;
    static int racBerth = 1;
    static int racLowerBerth = 1;
    static int racMiddleBerth = 0;
    static int racUpperBerth = 0;
    static int waitingList = 1;

    public static void addPassanger(PassangerDetails details){
        // String name = details.getName();
        int age = details.getAge();
        // String gender = details.getGender();
        String berth = details.getBerth();
        String assignedBerth = "";
        if(age>5){
            if(totalTickets>0){
                totalTickets-=1;
                totalBerth-=1;
                if(berth=="L" && lowerBerthTotal>0){
                    assignedBerth = "L";
                    lowerBerthTotal-=1;
                }
                else if(berth=="U" && upperBerthTotal>0){
                    assignedBerth = "U";
                    upperBerthTotal-=1;
                }
                else if(berth=="M" && middleBerthTotal>0){
                    assignedBerth = "M";
                    middleBerthTotal-=1;
                }
                else if(upperBerthTotal>0){
                    assignedBerth = "U";
                    upperBerthTotal-=1;
                }
                else if(middleBerthTotal>0){
                    assignedBerth = "M";
                    middleBerthTotal-=1;
                }
                else{
                    assignedBerth = "L";
                    lowerBerthTotal-=1;
                }
            }
            else if (totalTickets<=0 && RACTotal>0){
                if(racBerth>0){
                    racBerth-=1;
                    RACTotal-=1;
                    if(berth=="L" && racLowerBerth>0){
                        assignedBerth = "RAC L";
                        racLowerBerth-=1;
                    }
                    else if(berth=="M" && racMiddleBerth>0){
                        assignedBerth = "RAC M";
                        racMiddleBerth-=1;
                    }
                    else if(berth=="U" && racUpperBerth>0){
                        assignedBerth =  "RAC U";
                        racUpperBerth-=1;
                    }
                    else if(racUpperBerth>0){
                        assignedBerth = "RAC U";
                        racUpperBerth-=1;
                    }
                    else if(racMiddleBerth>0){
                        assignedBerth = "RAC M";
                        racMiddleBerth-=1;
                    }
                    else if(racLowerBerth>0){
                        assignedBerth = "RAC L";
                        racLowerBerth-=1;
                    }
                    else if(RACTotal > 0){
                        assignedBerth = "RAC Seater";
                    }
                }
            }
            else if(RACTotal<=0 && waitingList>0){
                assignedBerth = "WL";
                waitingList-=1;
            }
            else{
                System.out.println("No tickets available");
                return;
            }
        }
        else{
            assignedBerth = "Free";
        }
        details.updateBerth(assignedBerth);
        booked.add(details);
        System.out.println("Ticket assigned Successfully");
    }

    public static void delete(String name, int Age, String gender){
        for(PassangerDetails pd : booked){
            if(pd.getName().equals(name) && pd.getAge()==Age && pd.getGender().equals(gender)){
                
                String bookedTicket = pd.assignedBerth();
                
                if(bookedTicket=="L"){
                    totalTickets+=1;
                    lowerBerthTotal+=1;
                }
                else if (bookedTicket == "U"){
                    totalTickets+=1;
                    upperBerthTotal+=1;
                }
                else if(bookedTicket == "M"){
                    totalTickets+=1;
                    middleBerthTotal+=1;
                }
                else if(bookedTicket=="RAC L"){
                    racBerth+=1;
                    racLowerBerth+=1;
                }
                else if(bookedTicket == "RAC U"){
                    racBerth+=1;
                    racUpperBerth+=1;
                }
                else if(bookedTicket == "RAC M"){
                    racBerth+=1;
                    racMiddleBerth+=1;
                }
                else if(bookedTicket == "RAC Seater"){
                    RACTotal+=1;
                }
                else if(bookedTicket == "WL"){
                    waitingList+=1;
                }

                booked.remove(pd);

                String rac ="";
                for(PassangerDetails searchRAC : booked){
                    if(searchRAC.assignedBerth().equals("RAC") || searchRAC.assignedBerth().equals("RAC L") || searchRAC.assignedBerth().equals("RAC M") || searchRAC.assignedBerth().equals("RAC U")|| searchRAC.assignedBerth().equals("RAC Seater")){
                        rac = searchRAC.assignedBerth();
                        searchRAC.updateBerth(bookedTicket);
                        if(bookedTicket=="RAC L"){
                            racBerth+=1;
                            racLowerBerth+=1;
                        }
                        else if(bookedTicket == "RAC U"){
                            racBerth+=1;
                            racUpperBerth+=1;
                        }
                        else if(bookedTicket == "RAC M"){
                            racBerth+=1;
                            racMiddleBerth+=1;
                        }
                        else if(bookedTicket == "RAC Seater"){
                            RACTotal+=1;
                        }
                        break;
                    }
                }
                if(rac!=""){
                    for (PassangerDetails searchWL : booked){
                        if(searchWL.assignedBerth()=="WL"){
                            searchWL.updateBerth(rac);
                            waitingList+=1;
                            if(bookedTicket=="RAC L"){
                                racBerth-=1;
                                racLowerBerth-=1;
                            }
                            else if(bookedTicket == "RAC U"){
                                racBerth-=1;
                                racUpperBerth-=1;
                            }
                            else if(bookedTicket == "RAC M"){
                                racBerth-=1;
                                racMiddleBerth-=1;
                            }
                            else if(bookedTicket == "RAC Seater"){
                                RACTotal-=1;
                            }
                            break;
                        }
                    }
                }

                System.out.println("Ticket has been canceled successfully!!!");
                break;
            }
        }
    }

    public static void Display(){
        for(PassangerDetails passangerDetails : booked){
            System.out.println(passangerDetails.getName()+" "+passangerDetails.getAge()+" "+passangerDetails.getGender()+" "+passangerDetails.assignedBerth());
            System.out.println("*********************************************************************");
        }
    }

    public static void availableTickets(){
        if(totalTickets>0){
            System.out.println("Total tickets available : "+totalTickets);
            if(totalBerth>0){
                System.out.println("Total berths available : "+totalBerth);
                System.out.println("Upper Berth : "+upperBerthTotal+"\n"+"Lower Berth : "+lowerBerthTotal+"\n"+"Middle berth : "+middleBerthTotal);
            }
        }
        if(RACTotal>0){
            System.out.println("RAC available : "+RACTotal);
            if(racBerth>0){
                System.out.println("Remaining Berths available in RAC : "+racBerth);
                System.out.println("RAC Lower berth : "+racLowerBerth+"\n"+"RAC Middle berth : "+racMiddleBerth+"\n"+"RAC Upper berth : "+racUpperBerth);
            }
            System.out.println("RAC Seater Available : "+RACTotal);
        }
        if(waitingList>0){
            System.out.println("Waiting List : "+waitingList);
        }
        else{
            System.out.println("No Tickets Available");
        }
    }
}
