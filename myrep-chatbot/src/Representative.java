import java.io.IOException;
import java.util.ArrayList;

public class Representative {
    private String homeAddress;
    private String workAddress;
    private String homePhone;
    private String homeWorkPhone;
    private String columbiaWorkPhone;
    private String name;
    private String party;
    private String county;
    private String district;
    private ArrayList<String> facts;
    private String committeeAssignments;

    public Representative() throws IOException {
        Extractor.Run();

        ContactInformation contactInformation = new ContactInformation();
        PersonalInformation personalInformation = new PersonalInformation();
        CommitteeAssignments committeeAssignments = new CommitteeAssignments();

        homeAddress = contactInformation.getHomeAddress();
        workAddress = contactInformation.getWorkAddress();
        homePhone = contactInformation.gethomePhone();
        homeWorkPhone = contactInformation.gethomeWorkPhone();
        columbiaWorkPhone = contactInformation.getColumbiaWorkPhone();

        name = personalInformation.getName();
        party = personalInformation.getParty();
        county = personalInformation.getCounty();
        district = personalInformation.getDistrict();
        facts = personalInformation.getFacts();

        this.committeeAssignments = committeeAssignments.getCommitteeAssignments();
    }

    public String getCommitteeAssignments() {
        return committeeAssignments;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public String gethomePhone() {
        return homePhone;
    }

    public String getHomeWorkPhone() {
        return homeWorkPhone;
    }

    public String getColumbiaWorkPhone() {
        return columbiaWorkPhone;
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
