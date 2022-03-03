import java.io.IOException;

public class CommitteeAssignments {
    private String committeeAssignments;

    public CommitteeAssignments() throws IOException {
        committeeAssignments = DataLoader.loadCommitteeAssignments().get("committeeAssignment").toString();
    }

    public String getCommitteeAssignments() {
        return committeeAssignments;
    }
}
