import domain_model.CentreLocations;
import domain_model.FitnessClub;
import domain_model.Member;

public class Main {
    public static void main(String[] args) {

        FitnessClub fitnessClub = new FitnessClub();
//        Member member = new Member("John Hansen", 27, 8, 1998, "Johnhansen@gmail.com", "+45 41 82 89 93");
//        member.addCentreLocations(CentreLocations.ADDRESS9);
//        fitnessClub.addMember(member);
//        fitnessClub.saveClub();

        for (Member member : fitnessClub.getClubMembers()) {
            System.out.println(member.toString());
        }
    }
}
