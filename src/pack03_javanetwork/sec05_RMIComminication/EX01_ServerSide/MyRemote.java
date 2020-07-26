package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*RMI 통신예제 : RMI 원격서버 객체의 메서드 호출 [ServerSide]*/

//#1. 공통 인터페이스 생성
//@1-1. public + Remote 인터페이스 상속 (Remote Interface는 Mark용 인터페이스(내부에 추상 메서드 없음))	
//@1-2. 원격 제공을 목적으로 하는 내부의 추상메서드 정의 및 예외 전가 작성 (throws RemoteException)
//@1-3. 직렬화(serializable) 가능한 매개변수 및 리턴값만을 사용		

public interface MyRemote extends Remote{
	//원격으로 제공할 메서드
	public abstract String myRemoteMethod(String str) throws RemoteException; 
}
