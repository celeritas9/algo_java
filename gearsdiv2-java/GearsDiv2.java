public class GearsDiv2{

	public int getmin(String Directions) {
		
		char[] dirs = Directions.toCharArray();
		int lengthOfDirs = dirs.length;
		int minRemoval = 0;
		
		for(int i = 0; i < lengthOfDirs; i++) {
			char current = dirs[i];
			char next = i == lengthOfDirs - 1 ? dirs[0] : dirs[i + 1];
			
			if (next == current) {
				minRemoval++;
				i++;
			}
		}
		
		return minRemoval;
	}
}
