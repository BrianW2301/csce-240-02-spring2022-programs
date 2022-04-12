import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataLoader {
    public final static String inputFile = "myrep-chatbot\\data\\rep_info.txt";

    public static HashMap<String, String> loadContactInformation() throws IOException {
        HashMap<String, String> contactInformation = new HashMap<String, String>();

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        for (String string : lines) {
            if (string.split(": ")[0].equals("Home Address")) {
                contactInformation.put("homeAddress", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("Work Address")) {
                contactInformation.put("workAddress", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("Home Phone Number")) {
                contactInformation.put("homePhone", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("Rock Hill Business Phone Number")) {
                contactInformation.put("homeWorkPhone", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("Columbia Business Phone Number")) {
                contactInformation.put("columbiaWorkPhone", string.split(": ")[1]);
            }
        }
        return contactInformation;
    }

    public static HashMap<String, Object> loadPersonalInformtion() throws IOException {
        HashMap<String, Object> personalInformation = new HashMap<String, Object>();

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        ArrayList<String> facts = new ArrayList<>();
        for (String string : lines) {
            if (string.split(": ")[0].equals("Name")) {
                personalInformation.put("name", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("Party")) {
                personalInformation.put("party", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("County")) {
                personalInformation.put("county", string.split(": ")[1]);
            }
            if (string.split(": ")[0].equals("District")) {
                personalInformation.put("district", string.split(": ")[1]);
            }
            if (string.split("- ")[0].equals(" ")) {
                facts.add(string.split("- ")[1]);
            }
        }
        personalInformation.put("facts", facts);
        return personalInformation;
    }

    public static HashMap<String, String> loadCommitteeAssignments() throws IOException {
        HashMap<String, String> committeeAssignments = new HashMap<String, String>();

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();

        for (String string : lines) {
            if (string.split(": ")[0].equals("Committee Assignment")) {
                committeeAssignments.put("committeeAssignment", string.split(": ")[1]);
            }
        }
        return committeeAssignments;
    }
}
