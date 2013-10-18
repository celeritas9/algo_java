/**
 * 
 */
package dev.httpserver;

import org.apache.coyote.http11.Http11Protocol;

/**
 * @author dshah
 *
 */
public class HttpServer
{
	public void startServer()
	{
		System.out.println("Starting HttpServer on Port: ");
        server_ = new Http11Protocol();
        RequestHandlerAdapter requestHandler =new RequestHandlerAdapter();
        if (server_ != null) {
	        server_.setAdapter(requestHandler);
	        server_.setPort(HttpConfigStatic.SERVER_PORT);
	        server_.setTcpNoDelay(true);
	        server_.setBacklog(HttpConfigStatic.MAX_BACKLOG);
	        server_.setDisableUploadTimeout(true);//If true, the regular socket timeout will be used for the full duration of the connection
	        /*server_.setMaxThreads(httpConfig_.getThreadPoolSize());//Maximum amount of worker threads.
	        server_.setMaxSavePostSize(httpConfig_.getWorkPoolSize());
	        server_.setThreadPriority(Thread.NORM_PRIORITY);//Priority of the acceptor and poller threads.
	        server_.setProcessorCache(httpConfig_.getProcessCache());
	        server_.setSoLinger(httpConfig_.getSoLingerTime());
	        server_.setSoTimeout(httpConfig_.getSoTimeout());
	        server_.setTimeout(httpConfig_.getConnectionTimeout());
	        server_.setMaxKeepAliveRequests(httpConfig_.getMaxKeepAliveRequests());*/
	        
	        try
	        {
	            server_.init();
	        }
	        catch (Exception e)
	        {
	            System.out.println("Exception While initialising server:");
	        }
	        
	        try
	        {
	            server_.start();
	            System.out.println("HTTP Server Started ");
	        }
	        catch (Exception e)
	        {
	            System.out.println("Exception While starting server:");
	            
	        }
	      
	       System.out.println("Started server with values:\n"
	               + "Algorithm:"+ server_.getAlgorithm()+ "\n"
	               + "Backlog:" + server_.getBacklog()+"\n"
	               + "Ciphers:" +server_.getCiphers()+ "\n"
	               + "Clientauth" + server_.getClientauth() + "\n"
	               + "CompressableMimeType:" + server_.getCompressableMimeType()+ "\n"
	               + "Compression:" + server_.getCompression() + "\n"
	               + "CompressionMinSize:" + server_.getCompressionMinSize() + "\n"
	               + "Domain:" + server_.getDomain() + "\n"
	               + "KeepAliveTimeout:" + server_.getKeepAliveTimeout() + "\n"
	               + "KeyAlias:" + server_.getKeyAlias() + "\n"
	               + "Keypass:" + server_.getKeypass() + "\n"
	               + "Keystore:" + server_.getKeystore() + "\n"
	               + "Keytype:" + server_.getKeytype() + "\n"
	               + "MaxHttpHeaderSize:" + server_.getMaxHttpHeaderSize() + "\n"
	               + "MaxKeepAliveRequests:" + server_.getMaxKeepAliveRequests() + "\n"
	               + "MaxSavePostSize:" + server_.getMaxSavePostSize() + "\n"
	               + "MaxThreads" + server_.getMaxThreads() + "\n"
	               + "Name:" + server_.getName() + "\n"
	               + "NoCompressionUserAgents:" + server_.getNoCompressionUserAgents() + "\n"
	               + "Port:" + server_.getPort() + "\n"
	               + "ProcessorCache:" + server_.getProcessorCache() + "\n"
	               + "Protocols:" + server_.getProtocols() + "\n"
	               + "RestrictedUserAgents:" + server_.getRestrictedUserAgents() + "\n"
	               + "Server:" + server_.getServer() + "\n"
	               + "SocketFactory:" + server_.getSocketFactory() + "\n"
	               + "SoLinger:" + server_.getSoLinger() + "\n"
	               + "SoTimeout:" + server_.getSoTimeout() + "\n"
	               + "SSLImplementation:" + server_.getSSLImplementation() + "\n"
	               + "ThreadPriority:" + server_.getThreadPriority() + "\n"
	               + "Timeout:" + server_.getTimeout() + "\n"
	               + "DisableUploadTimeout:" + server_.getDisableUploadTimeout() + "\n"
	               + "KeepAlive:" + server_.getKeepAlive() + "\n"
	               + "Secure:" + server_.getSecure() + "\n"
	               + "TcpNoDelay:" + server_.getTcpNoDelay());
        }
        else 
        {
        	System.out.println("HttpServer can not be started on Port[" +HttpConfigStatic.SERVER_PORT);
        }
	}
	
	Http11Protocol server_;
}
