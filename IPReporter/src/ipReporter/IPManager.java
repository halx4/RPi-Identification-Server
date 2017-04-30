package ipReporter;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IPManager {
	
	static Vector<InetAddress> getIPs() throws Exception{
		
		Vector<InetAddress> IPList=new Vector<InetAddress>();
		
        //System.out.println("Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
        
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();)
        {
                NetworkInterface e = n.nextElement();
               // System.out.println("Interface: " + e.getName());
                Enumeration<InetAddress> a = e.getInetAddresses();
                for (; a.hasMoreElements();)
                {
                        InetAddress addr = a.nextElement();
                        System.out.println("  " + addr.getHostAddress());
                        IPList.add(addr);
                        
                }
        }
		
	
		return IPList;
	}
	//--------------------------------------------
	static boolean ipStartsWith(InetAddress address,String prefix){
		
		String ipAsString=address.getHostAddress();
		return ipAsString.startsWith(prefix);
		
		
	}
	//--------------------------------------------
	static InetAddress getTrueIP(String ip_prefix) throws Exception{
		Vector<InetAddress> ipsVector=IPManager.getIPs();
		Iterator<InetAddress> iterator=ipsVector.iterator();
		while(iterator.hasNext()){
			InetAddress nextIP=iterator.next();
			//System.out.print(next.getHostAddress()+"   ");
			if(IPManager.ipStartsWith(nextIP,ip_prefix))return nextIP;
		}
		
		return null;
	
	
	
	}

}






