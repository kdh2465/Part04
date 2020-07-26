package pack04_javanetwork.sec01_ManagingAddress.EX01_InetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;

public class EX01_InetAddress {
	public static void main(String[] args) throws IOException {
		//# InetAddress 객체 생성방법 (IP/HostName 관리 (포트번호 관리 못함)) : 
		//# InetAddress + 포트번호관리 = InetSocketAddress
		
		//#1. InetAddress 객체 생성 =================================
		//@1-1. 원격지 IP 
		InetAddress ia1 = InetAddress.getByName("www.google.com"); //www.google.com/172.217.26.132
		InetAddress ia2 = InetAddress.getByAddress(new byte[] {(byte)172,(byte)217,(byte)26,(byte)132}); //172.217.161.132
		InetAddress ia3 = InetAddress.getByAddress("www.google.com", new byte[] {(byte)172,(byte)217,(byte)26,(byte)132}); //www.google.com/172.217.161.132 : 호스트이름을 바꾸어도 그대로 저장
		System.out.println(ia1);
		System.out.println(ia2);
		System.out.println(ia3);
		//@1-2. 로컬/루프백 IP
		InetAddress ia4 = InetAddress.getLocalHost(); //DHKIM/192.168.123.159
		InetAddress ia5 = InetAddress.getLoopbackAddress(); //localhost/127.0.0.1
		System.out.println(ia4);
		System.out.println(ia5);
		//@1-3. 하나의 호스트가 여러개의 IP를 가지고 있는 경우
		InetAddress[] ia6 = InetAddress.getAllByName("www.naver.com");
		System.out.println(Arrays.toString(ia6));		
		System.out.println();
		
		//#2. InetAddress 메서드
		//@2-1. 호스트와 IP 알아내기
		byte[] address = ia1.getAddress();
		System.out.println(Arrays.toString(address)); //[-84, -39, -95, -124]	
		System.out.println(ia1.getHostAddress()); //172.217.161.132
		System.out.println(ia1.getHostName()); //www.google.com
		
		System.out.println(ia1.isReachable(1000)); //true		
		System.out.println(ia1.isLoopbackAddress());//false
		System.out.println(ia1.isMulticastAddress());//false
		System.out.println(InetAddress.getByAddress(new byte[] {127,0,0,1}).isLoopbackAddress()); //true
		System.out.println(InetAddress.getByAddress(new byte[] {(byte)225,(byte)225,(byte)225,(byte)225}).isMulticastAddress()); //true
		
		System.out.println();
	}
}
