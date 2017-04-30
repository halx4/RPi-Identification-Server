// Author: F. Christoulakis

package rpiServer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class DevicesList extends ArrayList<DeviceEntry> {
	
	//-----------------------------------
	private int getIndexById(String id){   //returns index of entry with Id=id. if not found returns -1
		int index=-1;
		
				
		ListIterator<DeviceEntry> iterator=listIterator();		
		while(iterator.hasNext()){
			DeviceEntry next=iterator.next();
			if(next.getId().equals(id)){
				System.out.println("return "+(iterator.nextIndex()-1));
				return (iterator.nextIndex()-1);
				
			}
		}
		System.out.println("return -1");
		return index;
	}
	//--------------------------------
	void printAll(){
		Iterator<DeviceEntry> iterator=iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
			
		}
		System.out.println("--------");
	}
	//--------------------------------
	void printAsHtmlTable(PrintWriter out){
		Iterator<DeviceEntry> iterator=iterator();
		
		out.println("<table border=\"1\" align=\"center\" style=\"width:100%\">");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>IP</th>");
		out.println("<th>Last updated (sec ago)</th>");
		out.println("</tr>");
		
		
		while(iterator.hasNext()){
			DeviceEntry next = iterator.next();
			
			out.println("<tr>");
			
			out.println("<td>");
			out.println(next.getId());
			out.println("</td>");
			
			out.println("<td>");
			out.println(next.getIp());
			out.println("</td>");
			
			out.println("<td>");
			out.println(next.getSecFromLastUpdate());
			out.println("</td>");
			
			out.println("</tr>");
			
		}
		out.println("</table>");
	}
	
	//----------------------------------
	public void addOrUpdate(DeviceEntry device){
		
		int index=getIndexById(device.getId());
		if(index<0)add(device);
		else{
			remove(index);
			add(device);
		}
		
		
	}
	//------------------------------------
	@Override
	public boolean add(DeviceEntry device){
		System.out.println("add");
		device.setLastUpdatedTime(System.currentTimeMillis());
		boolean ret=super.add(device);
		return ret;
		
	}
}
