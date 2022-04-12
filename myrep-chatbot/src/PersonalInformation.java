import java.io.IOException;
import java.util.ArrayList;

public class PersonalInformation {
    private String name;
    private String party;
    private String county;
    private String district;
    private ArrayList<String> facts;

    public PersonalInformation() throws IOException {
        name = DataLoader.loadPersonalInformtion().get("name").toString();
        party = DataLoader.loadPersonalInformtion().get("party").toString();
        county = DataLoader.loadPersonalInformtion().get("county").toString();
        district = DataLoader.loadPersonalInformtion().get("district").toString();
        facts = (ArrayList) DataLoader.loadPersonalInformtion().get("facts");
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public String getCounty() {
        return county;
    }

    public String getDistrict() {
        return district;
    }

    public ArrayList<String> getFacts() {
        return facts;
    }
}
