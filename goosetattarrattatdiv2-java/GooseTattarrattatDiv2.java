import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GooseTattarrattatDiv2 {

	public int getmin(String S) {
		
		return S.length() - getMaxFrequency(new Character('-'), getFrequencies(S));
	}

	public Map<Character, Integer> getFrequencies(String S) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = S.toCharArray();
		
		for(char c : chars) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		return map;
	}
	
	public int getMaxFrequency(Character c, Map<Character, Integer> map) {
		
		int max = 0;
		
		for(Entry<Character, Integer> pair : map.entrySet()) {
			if (pair.getValue() > max) {
				max = pair.getValue();
				c = pair.getKey();
			}
		}
		
		return max;
	}
}
