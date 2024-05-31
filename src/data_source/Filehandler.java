package data_source;
import domain_model.CentreLocations;
import domain_model.FitnessClub;
import domain_model.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Filehandler {

    String filepath = "Database.csv";
    Scanner sc;



    public void saveData(FitnessClub fitnessClub) {

        try {
            FileWriter fileWriter = new FileWriter(filepath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Member member : fitnessClub.getClubMembers()) {
                printWriter.println("");
                printWriter.print(member.saveFormat());
            }
            printWriter.close();

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> loadData() {
        ArrayList<Member> loadedData = new ArrayList<>();
        sc = null;
        try {
            sc = new Scanner(new File(filepath), StandardCharsets.UTF_8);
            sc.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while(sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(",");

            int memberId = Integer.parseInt(attributes[0]);
            String fullName = attributes[1];
            LocalDate birthDay = LocalDate.parse(attributes[2], formatter);
            String email = attributes[3];
            String phoneNumber = attributes[4];
            CentreLocations centreLocations = CentreLocations.valueOf(attributes[5]);
            double balance = Double.parseDouble(attributes[6]);

            int day = birthDay.getDayOfMonth();
            int month = birthDay.getMonthValue();
            int year = birthDay.getYear();


            Member memberData = new Member(
                    fullName, day, month, year, email, phoneNumber
            );

            memberData.setMemberID(memberId);
            memberData.addCentreLocations(centreLocations);
            memberData.getMemberAccount().setBalance(balance);

            loadedData.add(memberData);
        }

        sc.close();
        return loadedData;
    }




}
