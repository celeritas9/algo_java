
public class Split {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String toSplit = ";";
		
		String[] split = toSplit.split(";");
		System.out.println(split.length);
		for(String s : split)
		{
			System.out.println(s);
		}
	}

}
