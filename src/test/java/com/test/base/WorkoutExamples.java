package com.test.base;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WorkoutExamples {
	public static void main(String[] args) throws Exception{
	     CloseableHttpClient httpclient = HttpClients.custom()
	      .setRetryHandler(new DefaultHttpRequestRetryHandler(0,false))
	      .build();


	     String user = "hemamalini@skillup.tech";
	     String pwd = "Hema@2022";
	     CredentialsProvider credsProvider = new BasicCredentialsProvider();
	     credsProvider.setCredentials(AuthScope.ANY,
	        new NTCredentials(user, pwd, "", ""));

	     // You may get 401 if you go through a load-balancer.
	     // To fix this, go directly to one of the sharepoint web server or
	     // change the config. See this article :
	     // http://blog.crsw.com/2008/10/14/unauthorized-401-1-exception-calling-web-services-in-sharepoint/
	     HttpHost target = new HttpHost("web.mysharepoint.local", 80, "http");
	     HttpClientContext context = HttpClientContext.create();
	     context.setCredentialsProvider(credsProvider);

	     // The authentication is NTLM.
	     // To trigger it, we send a minimal http request
	     HttpHead request1 = new HttpHead("/");
	     CloseableHttpResponse response1 = null;
	     try {
	       response1 = httpclient.execute(target, request1, context);
	       EntityUtils.consume(response1.getEntity());
	       System.out.println("1 : " + response1.getStatusLine().getStatusCode());
	     }
	     finally {
	       if (response1 != null ) response1.close();
	     }

	     // The real request, reuse authentication
	     String file = "/30500C/PubDoc/TEST/jira.log";  // source
	     String targetFolder = "C:/TEMP";
	     HttpGet request2 = new HttpGet("/_api/web/GetFileByServerRelativeUrl('" + file + "')/$value");
	     CloseableHttpResponse response2 = null;
	     try {
	       response2 = httpclient.execute(target, request2, context);
	       HttpEntity entity = response2.getEntity();
	       int rc = response2.getStatusLine().getStatusCode();
	       String reason = response2.getStatusLine().getReasonPhrase();
	       if (rc == HttpStatus.SC_OK) {
	          System.out.println("Writing "+ file + " to " + targetFolder);
	          File f = new File(file);
	          File ff= new File(targetFolder, f.getName());  // target
	          // writing the byte array into a file using Apache Commons IO
	          FileUtils.writeByteArrayToFile(ff, EntityUtils.toByteArray(entity));
	       }
	       else {
	          throw new Exception("Problem while receiving " + file + "  reason : "
	              + reason + " httpcode : " + rc);
	       }
	     }
	     finally {
	       if (response2 != null) response2.close();
	     }
	   }
}
