import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvParser {
	
	public static void main(String[] args){
		String csvFile = "GeoLiteCity-Location.csv";
		String line = "";
		String cvsSplitBy = ",";
	
		int count = 0;
		
		BufferedReader br = null;
		
		String check = "wut";
		
		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

            	if(count>2){
                // use comma as separator
                String[] city = line.split(cvsSplitBy);

                System.out.println("City [id= " + city[0] + " , country="+city[1]+ "]"+
                		"[region= " + city[2] + " , city="+city[3]+ "]"+
                		"[postalcode= " + city[4] + " , latitutude="+city[5]+ "]"+
                		"[longitude= " + city[6]);
            	}
            	
            	count++;
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
