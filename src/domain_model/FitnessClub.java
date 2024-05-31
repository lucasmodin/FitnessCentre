package domain_model;

import data_source.Filehandler;

import java.util.ArrayList;

public class FitnessClub {

    private ArrayList<Member> clubMembers;
    Filehandler filehandler = new Filehandler();


    public FitnessClub() {
        this.clubMembers = new ArrayList<>();
        clubMembers.addAll(filehandler.loadData());
    }

    public void addMember(Member member) {
        clubMembers.add(member);
    }

    public void removeMember(Member member) {
        clubMembers.remove(member);
    }

    public ArrayList<Member> getClubMembers() {
        return clubMembers;
    }

    public void saveClub () {
        filehandler.saveData(this);
    }









}
