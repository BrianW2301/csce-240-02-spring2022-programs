import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class prog2 {

    public static void main(String[] args) throws IOException {
        String input = "";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                input += args[i] + " ";
            }
        }
        input = input.substring(0, input.length() - 1);
        System.out.println("input: " + input);
        // Read input text file lines into an array
        FileReader fileReader = new FileReader("prog2-processor\\data\\Prog1Output.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        String name = "";
        String party = "";
        String county = "";
        String district = "";
        String homeAddress = "";
        String workAddress = "";
        String homePhone = "";
        String rockHillWorkPhone = "";
        String columbiaWorkPhone = "";
        String committeeAssignment = "";
        ArrayList<String> personalInformation = new ArrayList<>();
        for (String string : lines) {
            if (string.split(": ")[0].equals("Name")) {
                name = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Party")) {
                party = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("County")) {
                county = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("District")) {
                district = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Home Address")) {
                homeAddress = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Work Address")) {
                workAddress = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Home Phone Number")) {
                homePhone = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Rock Hill Business Phone Number")) {
                rockHillWorkPhone = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Columbia Business Phone Number")) {
                columbiaWorkPhone = string.split(": ")[1];
            }
            if (string.split(": ")[0].equals("Committee Assignment")) {
                committeeAssignment = string.split(": ")[1];
            }
            if (string.split("- ")[0].equals(" ")) {
                personalInformation.add(string.split("- ")[1]);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("prog2-processor\\data\\output.txt"));
        switch (input) {
            case "Contact Information":
                writer.write("My name is " + name + "\n");
                writer.write("I am a " + party + " from " + county + " county, " + district + "\n");
                writer.write("You can reach me during business hours with these two numbers: "
                        + rockHillWorkPhone + " & " + columbiaWorkPhone + "\n");
                writer.write("My home phone number is " + homePhone + "\n");
                writer.write("I live at " + homeAddress + " and work at " + workAddress + "\n");
                break;
            case "Contact Information:name":
                writer.write("My name is " + name + "\n");
                break;
            case "Contact Information:region":
                writer.write("I am from district " + district + ", " + county + " county" + "\n");
                break;
            case "Contact Information:Business Phone":
                writer.write(
                        "I have two business phone numbers. When I am at my home office, you can reach me at "
                                + rockHillWorkPhone
                                + " and when I am in my Columbia office you can reach me at " + columbiaWorkPhone
                                + "\n");
                break;
            case "Contact Information:Home Phone":
                writer.write("My home phone number is " + homePhone + "\n");
                break;
            case "Personal Information":
                for (String string : personalInformation) {
                    writer.write(string + "\n");
                }
                break;
            case "Personal Information:random":
                int rnd = new Random().nextInt(personalInformation.size());
                writer.write(personalInformation.get(rnd) + "\n");
                break;
            case "Committee Assignments":
                writer.write("My committee assignments are: " + "\n");
                writer.write(committeeAssignment + "\n");
                break;
        }
        writer.close();
    }
}
