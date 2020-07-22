package pack04_javanetwork.sec05_RMIComminication.EX02_ClientSide;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import pack04_javanetwork.sec05_RMIComminication.EX01_ServerSide.MyRemote;

public class EX02_ClientSide {
	public static void main(String[] args) {
		//#1. 서버에서 생성한 2개의 파일 복사
		//@1-1. 공통인터페이스.class
		//@1-2. 구현클래스_stub.class
		
		//#2. 서버에 바인딩 되어 있는 객체 복사본 가져오기 
		//@2-1.  바인딩 되어 있는 이름으로 객체 복사본 가져오기 (Naming 클래스의 lookup() 메서드 사용)
		
		//#3. 가져온 객체의 메서드 사용
		//@3-1. 메서드 실행시 실제 실행은 원격지에서 일어남 (원격 시스템)

		try {
			MyRemote mr = (MyRemote)Naming.lookup("rmi://127.0.0.1:1099/myBindingObject"); //"rmi://서버주소/바인딩이름"
			String str = mr.myRemoteMethod("안녕하세요!");
			System.out.println(str);			
		} 
		catch (MalformedURLException e) {} 
		catch (RemoteException e) {}
		catch (NotBoundException e) {} 
		
	}
}
