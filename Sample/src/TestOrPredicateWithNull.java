
public class TestOrPredicateWithNull
{
	public static void main(String[] args)
	{
		String a = null;
		
		if(a == null || a.equals(""))
		{
			System.out.println("Value of a is " + a);
		}
	}
}
