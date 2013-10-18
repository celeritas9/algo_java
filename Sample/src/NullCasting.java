
public class NullCasting
{
	public static void main(String[] args)
	{
		String a = (String)null;
		System.out.println(a);
		
		Object o1 = new String("100");
		Object o2 = new Long(100);
		long o3 = 10;
		
		long tempAdminFee =Long.parseLong(String.valueOf(o1));
		
		System.out.println(tempAdminFee);
		tempAdminFee = Long.parseLong(String.valueOf(o2));
		
		System.out.println(tempAdminFee);
		
		tempAdminFee = Long.parseLong(String.valueOf(o3));
	}

}
