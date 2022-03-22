import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class prog4 {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        Representative rep = new Representative();
        ArrayList<String> prompts = new ArrayList<String>();
        prompts.add("quit");
        prompts.add("q");
        prompts.add("hi");
        prompts.add("hello");
        prompts.add("who is my rep");
        prompts.add("tell me about my rep");
        prompts.add("how do i contact my rep");
        prompts.add("what is my reps name");
        prompts.add("where is my rep from");
        prompts.add("what is my reps politcal affiliation");
        prompts.add("where does my rep live");
        prompts.add("what is my reps business phone number");
        prompts.add("what is my reps work phone number");
        prompts.add("what is my reps home phone number");
        prompts.add("what is my reps personal information");
        prompts.add("tell me a fact about my rep");
        prompts.add("what are my reps committee assignments");
        prompts.add("what committees is my rep on");
        prompts.add("tell me everything");

        double[] confValues = new double[prompts.size()];

        System.out.println("Hello! How can I help you?");
        while (!input.equals("q") && !input.equals("quit")) {
            // format input to lowercase and remove '?' if there is one
            input = keyboard.nextLine().toLowerCase();
            if (input.charAt(input.length() - 1) == '?') {
                input = input.substring(0, input.length() - 1);
            }
            // calculate a confidence value for each possible defined input
            for (int i = 0; i < prompts.size(); i++) {
                if (input.length() < prompts.get(i).length()) {
                    confValues[i] = ((float) prompts.get(i).length() - (float) evalInput(prompts.get(i), input))
                            / (float) prompts.get(i).length();
                } else {
                    confValues[i] = (float) (input.length() - (float) evalInput(prompts.get(i), input))
                            / (float) input.length();
                }
            }
            // find the index of the highest confidence value
            int closestIndex = 0;
            for (int i = 0; i < confValues.length; i++) {
                if (confValues[i] > confValues[closestIndex]) {
                    closestIndex = i;
                }
            }
            if (confValues[closestIndex] >= 0.5) {
                System.out.println("I believe you mean: " + prompts.get(closestIndex) + " with "
                        + confValues[closestIndex] * 100.0 + " % confidence");
                if (prompts.get(closestIndex).equals("quit")) {
                    input = "quit";
                }
                output(prompts.get(closestIndex), rep);
            } else {
                System.out.println("I believe you mean: " + prompts.get(closestIndex) + " with "
                        + confValues[closestIndex] * 100.0 + " % confidence");
                System.out.println("Can you rephrase your question");
            }
        }
        keyboard.close();
    }

    static int evalInput(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                            + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

    public static void output(String input, Representative rep) {
        switch (input) {
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
                                + rep.getHomeWorkPhone() + " & " + rep.getColumbiaWorkPhone());
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
                                + rep.getHomeWorkPhone()
                                + " and when they are in their Columbia office you can reach them at "
                                + rep.getColumbiaWorkPhone());
                break;
            case "what is my reps home phone number":
                System.out.println("Your representative's home phone number is " + rep.gethomePhone());
                break;
            case "what is my reps personal information":
                for (String string : rep.getFacts()) {
                    System.out.println(string);
                }
                break;
            case "tell me a fact about my rep":
                int rnd = new Random().nextInt(rep.getFacts().size());
                System.out.println(rep.getFacts().get(rnd));
                break;
            case "what are my reps committee assignments":
            case "what committees is my rep on":
                System.out.println(
                        "Your representative's committee assignments are: " + rep.getCommitteeAssignments());
                break;
            case "quit":
            case "q":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("I do not know this information");
                break;
        }
    }
}
