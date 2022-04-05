import java.io.IOException;

public class ContactInformation {
    private String homeAddress;
    private String workAddress;
    private String homePhone;
    private String homeWorkPhone;
    private String columbiaWorkPhone;

    public ContactInformation() throws IOException {
        homeAddress = DataLoader.loadContactInformation().get("homeAddress").toString();
        workAddress = DataLoader.loadContactInformation().get("workAddress").toString();
        homePhone = DataLoader.loadContactInformation().get("homePhone").toString();
        homeWorkPhone = DataLoader.loadContactInformation().get("homeWorkPhone").toString();
        columbiaWorkPhone = DataLoader.loadContactInformation().get("columbiaWorkPhone").toString();
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

    public String gethomeWorkPhone() {
        return homeWorkPhone;
    }

    public String getColumbiaWorkPhone() {
        return columbiaWorkPhone;
    }
}
