package ipReporter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequester {
	
	
	static void sendRequest(String serverUrl,String idArg,String ipArg) throws IOException{
		URL url = null;
		try {
		   url = new URL(serverUrl+"?id="+idArg+"&ip="+ipArg);
		   System.out.println("URL="+url.toString());
		   //url = new URL("http://83.212.122.89:8080/ResourcesServletTEMP/temperature?id=23&ip=192.168.178.33");
		} catch (MalformedURLException exception) {
		    exception.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		DataOutputStream dataOutputStream = null;
		try {
		    httpURLConnection = (HttpURLConnection) url.openConnection();
		    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httpURLConnection.setRequestMethod("PUT");
		    httpURLConnection.setDoInput(true);
		    httpURLConnection.setDoOutput(true);
		    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
		    //dataOutputStream.writeUTF("hello");
		    //System.out.println("done");
		}  finally {
		    if (dataOutputStream != null) {
		        try {
		            dataOutputStream.flush();
		            dataOutputStream.close();
		            //System.out.println("closed");
		            //httpURLConnection.connect();
		            System.out.println("response code="+httpURLConnection.getResponseCode());
		        } catch (IOException exception) {
		        	
		            exception.printStackTrace();
		        }
		    }
		    if (httpURLConnection != null) {
		        httpURLConnection.disconnect();
		    }
		}
		
	}
	
	
	

}
