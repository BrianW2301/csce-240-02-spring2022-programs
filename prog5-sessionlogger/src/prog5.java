import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class prog5 {

    public static void runChatBot() throws IOException {
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

        File csv = new File("prog5-sessionlogger\\data\\chat_sessions\\chat_statistics.csv");
        int numLines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(csv))) {

            while (lnr.readLine() != null)
                ;

            numLines = lnr.getLineNumber();

        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        String sessionDate = formatter.format(date);
        String filePath = "prog5-sessionlogger\\data\\chat_sessions\\" + sessionDate + ".txt";
        System.out.println(filePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

        double[] confValues = new double[prompts.size()];

        int numUserUtterance = 0;
        int numSystemUtterance = 0;
        System.out.println("Hello! How can I help you?");
        // start session timer
        long startTime = System.currentTimeMillis();
        while (!input.equals("q") && !input.equals("quit")) {
            // format input to lowercase and remove '?' if there is one
            input = keyboard.nextLine().toLowerCase();
            writer.write(input);
            numUserUtterance++;

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
            String output = "";
            if (confValues[closestIndex] >= 0.5) {
                numSystemUtterance++;
                output = "I believe you mean: " + prompts.get(closestIndex) + " with "
                        + confValues[closestIndex] * 100.0 + " % confidence\n";
                if (prompts.get(closestIndex).equals("quit")) {
                    input = "quit";
                }
                output += output(prompts.get(closestIndex), rep);
            } else {
                output = "I believe you mean: " + prompts.get(closestIndex) + " with "
                        + confValues[closestIndex] * 100.0 + " % confidence\n";
                output += "Can you rephrase your question\n";
            }
            System.out.println(output);
            writer.write("\n" + output + "\n\n");

        }
        // end session timer
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        keyboard.close();
        writer.close();

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("prog5-sessionlogger\\data\\chat_sessions\\chat_statistics.csv", true));
        bw.write("\n" + numLines + ", " + sessionDate + ".txt, " + numUserUtterance + ", "
                + numSystemUtterance + ", " + duration);
        bw.close();

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

    public static String output(String input, Representative rep) {
        String output = "";
        switch (input) {
            case "hi":
            case "hello":
                return "Hello!";
            case "who is my rep":
                return "Your representative is " + rep.getName() + ", a " + rep.getParty() + " from "
                        + rep.getCounty() + " county";
            case "tell me about my rep":
                output += "Your representative's name is " + rep.getName();
                output += "\nYour representative is a " + rep.getParty() + " from " + rep.getCounty()
                        + " county, " + rep.getDistrict();
                output += "\nYou can reach your representative during business hours with these two numbers: "
                        + rep.getHomeWorkPhone() + " & " + rep.getColumbiaWorkPhone();
                output += "\nYour representative's home phone number is " + rep.gethomePhone();
                output += "\nYour representative lives at " + rep.getHomeAddress() + " and works at "
                        + rep.getWorkAddress();

                return output;
            case "how do i contact my rep":
                return "You can call your representative at " + rep.getColumbiaWorkPhone() + " or send mail to "
                        + rep.getWorkAddress();
            case "what is my reps name":
                return "Your representative's name is " + rep.getName();
            case "where is my rep from":
                return "Your representative is from district " + rep.getDistrict() + ", "
                        + rep.getCounty() + " county";
            case "what is my reps politcal affiliation":
                return "Your representative is a " + rep.getParty();
            case "where does my rep live":
                return "Your representative lives at " + rep.getHomeAddress();
            case "what is my reps business phone number":
            case "what is my reps work phone number":
                return "Your representative has two business phone numbers. When they are at their home office, you can reach them at "
                        + rep.getHomeWorkPhone()
                        + " and when they are in their Columbia office you can reach them at "
                        + rep.getColumbiaWorkPhone();
            case "what is my reps home phone number":
                return "Your representative's home phone number is " + rep.gethomePhone();
            case "what is my reps personal information":

                for (String string : rep.getFacts()) {
                    output += (string + "\n");
                }
                return output;
            case "tell me a fact about my rep":
                int rnd = new Random().nextInt(rep.getFacts().size());
                return rep.getFacts().get(rnd);
            case "what are my reps committee assignments":
            case "what committees is my rep on":
                return "Your representative's committee assignments are: " + rep.getCommitteeAssignments();
            case "quit":
            case "q":
                return "Goodbye!";
            case "tell me everything":
                return "";
            default:
                return "I do not know this information";
        }
    }

    public static void main(String[] args) throws IOException {
        File csv = new File("prog5-sessionlogger\\data\\chat_sessions\\chat_statistics.csv");
        BufferedReader br = new BufferedReader(new FileReader(csv));
        if (args.length == 0) {
            runChatBot();
        } else if (args.length == 1) {
            if (args[0].toLowerCase().equals("-summary")) {
                int numLines = 0;
                int numUserUtterance = 0;
                int numSystemUtterance = 0;
                int totalTime = 0;
                br.readLine();
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    numLines = Integer.parseInt(line.split(", ")[0]);
                    numUserUtterance += Integer.parseInt(line.split(", ")[2]);
                    numSystemUtterance += Integer.parseInt(line.split(", ")[3]);
                    totalTime += Integer.parseInt(line.split(", ")[4]);
                }
                System.out.println("There are " + numLines + " chats to date with the user asking " + numUserUtterance
                        + " times and the system responding " + numSystemUtterance + " times. Total duration is "
                        + totalTime + " miliseconds.");
                br.close();
            } else
                System.out.println("Input Error");
        } else if (args.length == 2) {
            if (args[0].toLowerCase().equals("-showchat-summary")) {
                int numUserUtterance = 0;
                int numSystemUtterance = 0;
                int totalTime = 0;
                br.readLine();
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    if (Integer.parseInt(args[1]) == Integer.parseInt(line.split(", ")[0])) {
                        numUserUtterance = Integer.parseInt(line.split(", ")[2]);
                        numSystemUtterance = Integer.parseInt(line.split(", ")[3]);
                        totalTime = Integer.parseInt(line.split(", ")[4]);
                    }
                }
                if (numUserUtterance == 0) {
                    System.out.println("Error: Chat session number is higher than max");
                } else
                    System.out.println(
                            "Chat " + args[1] + " has user asking " + numUserUtterance + " times and system responding "
                                    + numSystemUtterance + " times. Total duration is " + totalTime + " miliseconds.");
            } else if (args[0].toLowerCase().equals("-showchat")) {
                int numUserUtterance = 0;
                String fileName = "";
                br.readLine();
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    if (Integer.parseInt(args[1]) == Integer.parseInt(line.split(", ")[0])) {
                        numUserUtterance = Integer.parseInt(line.split(", ")[2]);
                        fileName = "prog5-sessionlogger\\data\\chat_sessions\\" + line.split(", ")[1];
                    }
                }
                if (numUserUtterance == 0) {
                    System.out.println("Error: Chat session number is higher than max");
                } else {
                    System.out.println("Chat " + args[1] + " chat is:");
                    BufferedReader fileReader = new BufferedReader(
                            new FileReader(fileName));
                    String line;
                    while ((line = fileReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    fileReader.close();
                    System.out.println("");
                }

            }
        } else {
            System.out.println("Error: Too many arguments");
        }
    }
}