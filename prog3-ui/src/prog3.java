import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class prog3 {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String answer = " ";
        Representative rep = new Representative();
        ArrayList<String> personalInformation = rep.getFacts();
        while (!answer.equals("q") && !answer.equals("quit")) {

            answer = keyboard.nextLine().toLowerCase();
            if (answer.charAt(answer.length() - 1) == '?') {
                answer = answer.substring(0, answer.length() - 1);
            }
            switch (answer) {
                case "hi":
                case "hello":
                    System.out.println("Hello!");
                    break;
                case "who is my rep":
                    System.out
                            .println("Your representative is " + rep.getName() + ", a " + rep.getParty() + " from "
                                    + rep.getCounty() + " county");
                    break;
                case "tell me about my rep":
                    System.out.println("Your representative's name is " + rep.getName());
                    System.out
                            .println("Your representative is a " + rep.getParty() + " from " + rep.getCounty()
                                    + " county, " + rep.getDistrict());
                    System.out
                            .println("You can reach your representative during business hours with these two numbers: "
                                    + rep.gethomeWorkPhone() + " & " + rep.getColumbiaWorkPhone());
                    System.out.println("Your representative's home phone number is " + rep.gethomePhone());
                    System.out.println("Your representative lives at " + rep.getHomeAddress() + " and works at "
                            + rep.getWorkAddress());
                    break;
                case "how do i contact my rep":
                    System.out.println(
                            "You can call your representative at " + rep.getColumbiaWorkPhone() + " or send mail to "
                                    + rep.getWorkAddress());
                    break;
                case "what is my reps name":
                    System.out.println("Your representative's name is " + rep.getName());
                    break;
                case "where is my rep from":
                    System.out.println("Your representative is from district " + rep.getDistrict() + ", "
                            + rep.getCounty() + " county");
                    break;
                case "what is my reps politcal affiliation":
                    System.out.println("Your representative is a " + rep.getParty());
                case "where does my rep live":
                    System.out.println("Your representative lives at " + rep.getHomeAddress());
                    break;
                case "what is my reps business phone number":
                case "what is my reps work phone number":
                    System.out.println(
                            "Your representative has two business phone numbers. When they are at their home office, you can reach them at "
                                    + rep.gethomeWorkPhone()
                                    + " and when they are in their Columbia office you can reach them at "
                                    + rep.getColumbiaWorkPhone());
                    break;
                case "what is my reps home phone number":
                    System.out.println("Your representative's home phone number is " + rep.gethomePhone());
                    break;
                case "what is my reps personal information":
                    for (String string : personalInformation) {
                        System.out.println(string);
                    }
                    break;
                case "tell me a fact about my rep":
                    int rnd = new Random().nextInt(personalInformation.size());
                    System.out.println(personalInformation.get(rnd));
                    break;
                case "what are my reps committee assignments":
                case "what committees is my rep on":
                    System.out.println(
                            "Your representative's committee assignments are: " + rep.getCommitteeAssignments());
                    break;
                case "quit":
                case "q":
                    break;
                default:
                    System.out.println("I do not know this information");
                    break;
            }
        }
        keyboard.close();
    }
}
