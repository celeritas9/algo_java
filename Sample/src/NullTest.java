public class NullTest {

	public static void main(String[] args) {
		
		/*XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		try
		{
			XPathExpression expr = xpath.compile("//CDR/DYNPARTITION");
			System.out.println(expr.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		/*Long[] longObjectArray = new Long[]{(long)2, (long)3, (long)5, (long)7, null};
		long[] longPrimitiveArray = ArrayUtils.toPrimitive(longObjectArray);
		
		for(long l : longPrimitiveArray)
		{
			System.out.println(l);
		}*/
		
		
		String a = "devang1";
		Object b = null;
		System.out.println(a + b);
		
	}

}
