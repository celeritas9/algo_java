import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


class HelloObj
{
        private String str = null;
        private String[] strArr = null;
        public HelloObj(String str, String[] strArr)
        {
                this.str = new String(str);
                this.strArr = new String[]{};
                this.strArr = strArr;
        }
        /*
         * This is test comment.
         */
        public void getStr()
        {
        	System.out.println(this.str);
        	System.out.println(strArr.length);
        }
}
 
class Hello
{
        /**
         * @param args
         */
        public static void main(String [] args){
                /*String s = "this is string";
                String[] a = new String[]{s};
                System.out.println(a);
                
                HelloObj hello = new HelloObj(s, a);
                hello.getStr();*/
        	/*String s = "2400.00000";
        	double l = Double.parseDouble(s);
        	System.out.println(""+l);
        	String date = "";
        	System.out.println(date);
        	String year = date.substring(0, 4);
        	String month = date.substring(4,6);
        	String day = date.substring(7, 9);
        	date = year + "/" + month + "/" + day;
        	System.out.println(date);*/
        	
        	/*String expiryDate = "2011070700000000";
        	if(expiryDate.length() > 14)
                expiryDate = expiryDate.substring(0, 4) +"/"+ expiryDate.substring(4, 6) +"/"+ expiryDate.substring(6, 8)+
                				" "+ expiryDate.substring(8, 10) +":"+ expiryDate.substring(10, 12) +":"+ expiryDate.substring(12);
        	System.out.println("a: "+expiryDate);*/
        	final long KEY_MAPPING_USAGE_TYPE_TABLE_DATA=(0x1L)<<5;
            System.out.println("value:"+KEY_MAPPING_USAGE_TYPE_TABLE_DATA);

        	boolean b = false;
        	String a = "abs cde";
        	String ab = a.trim();
        	System.out.println(b+ab);
        	
        	/*Generate sequential numbers*/
        	/*long i = 0;
        	for(int j =0; j < 5000000; j++)
        	{
        		System.out.println("order-"+new SimpleDateFormat("").format(new Date())+String.valueOf(i++ % 1000000l));
        	}*/
        	
        	/*try
        	{
				URL url = new URL("https://test.admeris.com/ccgateway/cc/processor.do");
				URLConnection conn = url.openConnection();
				System.out.println(conn.getExpiration());
				System.out.println(url);
			}
        	catch (MalformedURLException e) 
			{
				e.printStackTrace();
			} 
        	catch (IOException e) 
        	{
				e.printStackTrace();
			}*/
        	
        	int index = a.indexOf("bs");
        	int last = a.lastIndexOf("de");
        	System.out.println(last);
        	
        	System.out.println(-3 % 5);
        	float f = 0.1f + 0.2f;
        	System.out.println(0.1d + 0.2d);
        }
}