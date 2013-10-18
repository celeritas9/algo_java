import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNumbersSolution
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		long startTime = System.currentTimeMillis();
		System.out.println("StartTime: "+startTime);
		int n = 0;
		String input[] = null;
		int A, B = 0;
		
		File f = new File("E:\\code\\recycledNumbers\\C-large.in");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		
		String testcases = reader.readLine();
		n = Integer.parseInt(testcases);
		
		FileWriter fw = new FileWriter("E:\\code\\recycledNumbers\\outputSolution");
		
		for(int j = 0; j < n; j++)
		{
			input = reader.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			
			int power = /*1*/(int)Math.pow(10, String.valueOf(A).length() - 1), temp = A;
			/*while (temp >= 10)
			{
				power *= 10;
				temp /= 10;
			}*/
			int result = 0;
			for (int i = A; i <= B; ++i)
			{
				temp = i;
				while (true)
				{
					temp = (temp / 10) + ((temp % 10) * power);
					if (temp == i)
						break;
					if (temp > i && temp <= B)
						result++;
				}
			}
			fw.write("Case #"+(j+1)+": "+result+"\n");
		}
		
		reader.close();
		fw.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("EndTime: "+endTime);
		
		System.out.println("it took:"+(endTime - startTime)+" millis");
	}
}
