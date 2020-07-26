package pack04_javanetwork.sec01_ManagingAddress.EX02_SocketAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class EX02_SocketAddress {
	public static void main(String[] args) throws UnknownHostException {
		
		//#1. InetSocketAddress 객체 생성
		InetAddress ia = InetAddress.getByName("www.google.com");
		int port = 10000;
		
		InetSocketAddress isa1 = new InetSocketAddress(port);
		InetSocketAddress isa2 = new InetSocketAddress("www.google.com", port);
		InetSocketAddress isa3 = new InetSocketAddress(ia, port);
		
		System.out.println(isa1); //0.0.0.0/0.0.0.0:10000
		System.out.println(isa2); //www.google.com/216.58.220.196:10000
		System.out.println(isa3); //www.google.com/216.58.220.196:10000
		System.out.println();
		
		//#2. InetSocketAddress 메서드
		System.out.println(isa2.getAddress()); //www.google.com/216.58.220.196
		System.out.println(isa2.getHostName()); //www.google.com
		System.out.println(isa2.getPort()); //10000

				
		Process p1=null;
		try {
			p1 = Runtime.getRuntime().exec("ping -n 1 www.google.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int returnVal=0;
		try {
			returnVal = p1.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(returnVal);
				
	}
}
