/**
 * 
 */
package HashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author blessonm
 *
 */
public class PatternMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PatternMatch p = new PatternMatch();
		System.out.println(p.wordPattern("abba", "cat dog dog cat"));
	}
	
	public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length)
            return false;
        Map map = new HashMap();
        for(int i = 0; i < strArray.length; i++){
            if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(strArray[i], i)))
                return false;
        }
        return true;
    }

}
