package com.topcoder;

import java.util.HashMap;
import java.util.Map;


/**
 * @author dshah
 * @since 
 */
public class Srm579Div1
{
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
		
		//Should return 14.
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
		int presses = 0;
		String buffer = "";
		String stringToParse = "";
		Map<String, String> undoHistory = new HashMap<String, String>();
		undoHistory.put(buffer, buffer);
		
		for(String line : lines)
		{
			if(line.startsWith(buffer))
			{
				stringToParse = line.substring(buffer.length());
			}
			else if(line.length() > 2 && undoHistory.containsValue(line))
			{
				//If the line is present in the undo history set then using double click just load the string. And the new string to parse would be "".
				buffer = undoHistory.get(line);
				stringToParse = "";
				presses += 2;
			}
			else
			{
				//If the line is present in the undoHistory then loan that string from the history only if the current buffer is not empty.
				if(undoHistory.containsValue(line) && buffer.length() > 0)
				{
					buffer = line;
					stringToParse = "";
				}
				//if the line is not present in the undo history set then load an empty string from the set so increased the presses by two.
				else
				{
					buffer = "";
					stringToParse = line;
				}
				presses += 2;
			}
			
			int maxLength = 0;
			for(int i = 1; i < line.length(); ++i)
			{
				String prefix = line.substring(0, i);
				if(buffer.length() == 0 && undoHistory.containsValue(prefix))
				{
					maxLength = Math.max(prefix.length(), maxLength);
				}
				undoHistory.put(prefix, prefix);
			}
			presses = presses - maxLength;
			
			presses += (line.equals(buffer) ? 0 : stringToParse.length()) + 1;
			buffer = line;
			undoHistory.put(line, line);
		}
		
		return presses;
	}
}
