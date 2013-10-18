package com.topcoder;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 *
 * @author dshah
 * @since 
 */
public class Srm579Div1_Sol
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Should return 10.
		String[] lines = {"a", "ab", "abac", "abacus"};
		System.out.println("Total presses " +minPresses(lines));
		
		//Should return 6.
		String[] lines1 = {"a", "b"};
		System.out.println("Total presses " +minPresses(lines1));
		
		//Should return 12.
		String[] lines2 = {"psf", "qrpsf"};
		System.out.println("Total presses " +minPresses(lines2));
		
		String[] lines3 = {"psf", "qrpsfdr"};
		System.out.println("Total presses " +minPresses(lines3));
		
		//Should return 39.
		String[] lines4 = {"pyramid", "sphinx", "sphere"/*};*/, "python", "serpent"};
		System.out.println("Total presses " +minPresses(lines4));
		
		//Should return 13.
		String[] lines5 = {"ba", "a", "a", "b", "ba"};
		System.out.println("Total presses " +minPresses(lines5));
		
		//Should return 11.
		String[] lines6 = {"ba", "a", "a", "b"};
		System.out.println("Total presses " +minPresses(lines6));
	}
	
    public static int minPresses(String[] lines)
    {
		Set<String> history = new HashSet<String>();
		int res = 0;
		String buffer = "";
		for (String line : lines)
		{
			int best = Integer.MAX_VALUE;
			if (line.startsWith(buffer))
				best = Math.min(best, line.length() - buffer.length());
			for (int i = 0; i <= line.length(); ++i)
				if (history.contains(line.substring(0, i)))
					best = Math.min(best, line.length() - i + 2);
			res += best + 1;
			for (int i = 0; i <= line.length(); ++i)
			{
				history.add(line.substring(0, i));
			}
			buffer = line;
		}
		return res;
    }


}
