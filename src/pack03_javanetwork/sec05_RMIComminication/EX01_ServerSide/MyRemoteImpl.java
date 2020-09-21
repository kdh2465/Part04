package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pack04_javanetwork.sec05_RMIComminication.EX01_ServerSide.MyRemote;

 
/*RMI 통신예제 : RMI 원격서버 객체의 메서드 호출 [ServerSide]*/

//#2. 공통인터페이스 구현 클래스 생성하기
//@2-1. public + 공통인터페이스 구현(implements) + UnicastRemoteObject 상속
//@2-2. 예외 전가 작성 (throws RemoteException)를 가진 생성자 하나 이상 작성
//@2-3. 구현 메서드는 넘어온 예외에 대한 예외 전가 작성 (throws RemoteException)
//@2-4. 직렬화(serializable) 가능한 매개변수만을 사용

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

	//private static final long serialVersionUID = 1L; //Remote를 구현하여 Serializable이 필수사항인 경우 serial 버전을 입력 (생략시 경고)

	protected MyRemoteImpl() throws RemoteException {
		super(); 
	}

	@Override
	public String myRemoteMethod(String str) throws RemoteException {
		System.out.println("원격메서드: myRemoteMethod()"); //원격서버에서 실행 (원격서버에서 출력)
		return "원격메서드: 전달받은 문자열 = " + str; //Client에게 전달되는 내용
	}
	
}
