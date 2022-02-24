//package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class prog1 {

        public static void Run() throws IOException {
                File input = new File("prog1-extractor\\data\\South_Carolina_Legislature_Online_Member_Biography.html");
                Document doc = Jsoup.parse(input, "UTF-8", "https://www.scstatehouse.gov/member.php?code=1697727069");
                // Name
                Elements nameElement = doc.select("#contentsection > h2");
                String name = nameElement.first().text();
                // Political party
                Elements partyElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(1) > p:nth-child(3)");
                String party = partyElement.first().text().split(" - ")[0];
                String county = partyElement.first().text().split(" - ")[1];
                // District number
                Elements districtElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(1) > p:nth-child(4)");
                String district = districtElement.first().text().split(" - ")[0];
                // Home address
                Elements homeAddressElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(2)");
                String homeAddress = homeAddressElement.first().text();
                // Work address
                Elements workAddressElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(3) > p:nth-child(2)");
                String workAddress = workAddressElement.first().text();
                // Rock Hill business number
                Elements RHBusinessPhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(4)");
                String RHBusinessPhone = RHBusinessPhoneElement.first().text();
                // Columbia business number
                Elements ColumbiaBusinessPhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(3) > p:nth-child(3)");
                String ColumbiaBusinessPhone = ColumbiaBusinessPhoneElement.first().text();
                // Home phone number
                Elements HomePhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(3)");
                String HomePhone = HomePhoneElement.first().text();
                // Committee Assignment
                Elements CommitteeElement = doc
                                .select("#contentsection > div:nth-child(4) > div > table > tbody > tr > td:nth-child(3) > ul:nth-child(2) > li > a");
                String Committee = CommitteeElement.first().text();
                // Array of personal information
                ArrayList<String> PersonalInformation = new ArrayList<String>();
                int i = 1;
                String path = "#contentsection > div:nth-child(4) > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(";
                Elements PersonalInformationElement;
                while (i <= 14) {
                        PersonalInformationElement = doc.select(path + i + ")");
                        PersonalInformation.add(PersonalInformationElement.first().text());
                        i++;
                }
                // Write to text file
                BufferedWriter writer = new BufferedWriter(new FileWriter("prog1-extractor\\data\\output.txt"));
                writer.write("Name: " + name + "\n");
                writer.write("Party: " + party + "\n");
                writer.write("County: " + county + "\n");
                writer.write("District: " + district + "\n");
                writer.write("Home Address: " + homeAddress + "\n");
                writer.write("Work Address: " + workAddress + "\n");
                writer.write("Home Phone Number: " + HomePhone + "\n");
                writer.write("Rock Hill Business Phone Number: " + RHBusinessPhone + "\n");
                writer.write("Columbia Business Phone Number: " + ColumbiaBusinessPhone + "\n");
                writer.write("Committee Assignment: " + Committee + "\n");
                writer.write("Personal Information: " + "\n");
                for (String string : PersonalInformation)
                        writer.write(" - " + string + "\n");
                writer.close();
        }

        public static void main(String[] args) throws IOException {
                if (args.length == 0) {
                        System.out.println("Enter a district number as an argument");
                } else {
                        if (args[0].equals("46")) {
                                Run();
                        } else
                                System.out.println("Invalid district input. Only 46 is valid input.");
                }
        }

}