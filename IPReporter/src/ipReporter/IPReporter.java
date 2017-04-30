package ipReporter;

import java.io.IOException;
import java.net.InetAddress;

public class IPReporter {

	public static void main(String[] args) {

		PropertiesHandler propertiesHandler = new PropertiesHandler();
		System.out.println("id=" + propertiesHandler.getID());

		try {

			InetAddress trueIP = IPManager.getTrueIP(propertiesHandler
					.getIpPrefix());
			if (trueIP == null)
				throw new NullPointerException();

			System.out.println("trueIP=" + trueIP.getHostAddress());

			HttpRequester.sendRequest(propertiesHandler.getServerUrl(),
					propertiesHandler.getID(), trueIP.getHostAddress());

		} catch (NullPointerException e) {
			System.err.println("no matching IP found");
		} catch (IOException e) {
			System.err.println("connection error");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
