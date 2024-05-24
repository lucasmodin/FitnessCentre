package domain_model;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

public class Member implements Comparable<Member>{

    //**************** ATTRIBUTES ******************//

    private static int memberIdCounter = 0;

    private int memberID;
    private String fullName;
    private LocalDate birthDay;
    private String email;
    private String phoneNumber;
    private Set<CentreLocations> centreLocations;

    private final MemberAccount memberAccount;


    //**************** CONSTRUCTOR ******************//

    public Member(String fullName, int day, int month, int year,
                  String email, String phoneNumber) {
        this.memberID = ++memberIdCounter;
        this.fullName = fullName;
        this.birthDay = LocalDate.of(year,month,day);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.memberAccount = new MemberAccount(this);
        this.centreLocations = EnumSet.noneOf(CentreLocations.class);

    }

    //**************** GETTERS ******************//

    public int getMemberID() {
        return memberID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDay() {
        return birthDay.getDayOfMonth() + "/" + birthDay.getMonthValue() + "/" + birthDay.getYear();
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MemberAccount getMemberAccount() {
        return memberAccount;
    }

    public Set<CentreLocations> getCentreLocations() {
        return centreLocations;
    }

    //**************** SETTERS ******************//

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDay(int day, int month, int year) {
        this.birthDay = LocalDate.of(year,month,day);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addCentreLocations (CentreLocations locations) {
        this.centreLocations.add(locations);
    }

    public void removeCentreLocations (CentreLocations locations) {
        this.centreLocations.remove(locations);
    }



    //**************** METHODS ******************//
    @Override
    public int compareTo(Member o) {
    return this.getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        String locations = centreLocations.isEmpty() ? "None" :
                String.join(", ", centreLocations.stream().map(c1 -> c1.location).toArray(String[]::new));

        return String.format(
                        "Member ID: %d%n" +
                        "Full Name: %s%n" +
                        "Birthday: %s%n" +
                        "Email: %s%n" +
                        "Phone Number: %s" +
                                "Centre Locations: %s",
                memberID, fullName, getBirthDay(), email, phoneNumber, locations
        );
   }





}
