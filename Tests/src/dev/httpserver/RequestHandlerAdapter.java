/**
 * 
 */
package dev.httpserver;

import org.apache.coyote.Adapter;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.tomcat.util.net.SocketStatus;

/**
 * @author dshah
 *
 */
public class RequestHandlerAdapter implements Adapter {

	/* (non-Javadoc)
	 * @see org.apache.coyote.Adapter#event(org.apache.coyote.Request, org.apache.coyote.Response, org.apache.tomcat.util.net.SocketStatus)
	 */
	@Override
	public boolean event(Request arg0, Response arg1, SocketStatus arg2) throws Exception
	{
		return false;
	}

	/* (non-Javadoc)
	 * @see org.apache.coyote.Adapter#service(org.apache.coyote.Request, org.apache.coyote.Response)
	 */
	@Override
	public void service(Request arg0, Response arg1) throws Exception
	{
		System.out.println(">>>>>>>>>>>>response received:"+arg1.getOutputBuffer());
	}

}
