package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTML_Parser {

        public static void main(String[] args) throws IOException {

                // Connect to the website and parse it into a document
                Document doc = Jsoup
                                .connect("https://www.scstatehouse.gov/member.php?code=1697727069")
                                .get();

                /*
                 * Elements Element = doc.select("");
                 * String name = Element.first().text();
                 */

                Elements nameElement = doc.select("#contentsection > h2"); // Select Element
                String name = nameElement.first().text(); // Get the text of the first element

                Elements partyElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(1) > p:nth-child(3)");
                String party = partyElement.first().text().split(" - ")[0];
                String county = partyElement.first().text().split(" - ")[1];

                Elements districtElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(1) > p:nth-child(4)");
                String district = districtElement.first().text().split(" - ")[0];

                Elements homeAddressElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(2)");
                String homeAddress = homeAddressElement.first().text();

                Elements workAddressElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(3) > p:nth-child(2)");
                String workAddress = workAddressElement.first().text();

                Elements RHBusinessPhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(4)");
                String RHBusinessPhone = RHBusinessPhoneElement.first().text();

                Elements ColumbiaBusinessPhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(3) > p:nth-child(3)");
                String ColumbiaBusinessPhone = ColumbiaBusinessPhoneElement.first().text();

                Elements HomePhoneElement = doc
                                .select("#contentsection > div:nth-child(3) > div:nth-child(4) > p:nth-child(3)");
                String HomePhone = HomePhoneElement.first().text();
                /*
                 * ArrayList<String> PersonalInformation = new ArrayList<String>();
                 * Elements Element = doc.select(
                 * "#contentsection > div:nth-child(4) > div > table > tbody > tr > td:nth-child(1) > ul > li:nth-child(15)"
                 * );
                 * String test = Element.first().text();
                 * System.out.println(test);
                 * for (int i=1; doc.selectXpath(
                 * "//*[@id="contentsection"]/div[2]/div/table/tbody/tr/td[1]/ul/li[7]" != nul;
                 * i++){
                 * 
                 * }
                 */
                System.out.println("Name: " + name);
                System.out.println("Party: " + party);
                System.out.println("County: " + county);
                System.out.println("District: " + district);
                System.out.println("Home Address: " + homeAddress);
                System.out.println("Work Address: " + workAddress);
                System.out.println("Home Phone Number: " + HomePhone);
                System.out.println("Rock Hill Business Phone Number: " + RHBusinessPhone);
                System.out.println("Columbia Business Phone Number: " + ColumbiaBusinessPhone);

                /*
                 * for (String line : readFileLines("project\data\Portrait.txt")) {
                 * System.out.println(line);
                 * }
                 */

        }

        private static ArrayList<String> readFileLines(String filepath) throws FileNotFoundException, IOException {
                File fp = new File(filepath);
                FileReader fr = new FileReader(fp);
                BufferedReader br = new BufferedReader(fr);

                ArrayList<String> lines = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                        lines.add(line);
                }

                fr.close();
                return lines;
        }

}