/**
 * 
 */
package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author blessonm
 *
 */
public class ReadCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String file = "insurance.csv";
		String line = "";
		List<Insurance> list = new ArrayList<>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				String[] words = line.split(",");
				Insurance i = new Insurance();
				i.ID = words[0];
				i.state = words[1];
				i.county = words[2];
				i.construction = words[3];
				list.add(i);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		Collections.sort(list);
		for(Insurance i: list){
			System.out.println(i.ID);
		}
	}
	
	public static class Insurance implements Comparable<Insurance>{
		public String ID;
		public String state;
		public String county;
		public String construction;
		
		@Override
		public int compareTo(Insurance i){
			return this.ID.compareTo(i.ID);
		}
	}
}
