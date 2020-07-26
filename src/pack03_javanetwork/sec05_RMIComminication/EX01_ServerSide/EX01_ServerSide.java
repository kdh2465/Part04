package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*RMI 통신예제 : RMI 원격서버 객체의 메서드 호출 [ServerSide]*/

        //RMI (Remote Method Invocation) : 디폴트 포트 1099 (분산환경)
		//rmi registry를 사용하지 않고 java의 LocateRegistry.class, Registry.class를 사용
		//설치 배포
		//서버의 구현 클래스를 rmic 컴파일러로 컴파일하면 스켈레톤클래스(서버), 스텁클래스(클라이언트) 생성 (스텁클래스는 클라이언트에게 제공)
		//서버는 클라이언트에게 제공할 메서드를 포함한 객체를 바인딩 
		//		
		//서버와 클라이언트 간 통신 기능을 제공하는 클래스 
		//스켈레톤(skeleton): 뼈대, 골격
		//스텁(stub):토막, 몽당연필
		//		
		//RMI: 순수 자바로 작성 JVM만 있으면 추가적인 미들웨어 없이 사용 가능
		//CORBA(RMI와 동일한 개념이나 다른 언어와의 호환성을 위해 나옴), EJB(Enterprize Java Bean) 등은 미들웨어가 필요
		
		//중요 package: java.rmi, java.rmi.registry, java.rmi.server (이외 java.rmi.dgc(distribute gabage collection): 분산환경에서 쓰레기 수집기
		//Registry Interface (객체 바인딩)

public class EX01_ServerSide {
	public static void main(String[] args) {
		//#1. 공통 인터페이스 생성
		//@1-1. public + Remote 인터페이스 상속 (Remote Interface는 Mark용 인터페이스(내부에 추상 메서드 없음))	
		//@1-2. 원격 제공을 목적으로 하는 내부의 추상메서드 정의 및 예외 전가 작성 (throws RemoteException)
		//@1-3. 직렬화(serializable) 가능한 매개변수 및 리턴값만을 사용		
		
		//#2. 공통인터페이스 구현 클래스 생성하기
		//@2-1. public + 공통인터페이스 구현(implements) + UnicastRemoteObject 상속
		//@2-2. 예외 전가 작성 (throws RemoteException)를 가진 생성자 하나 이상 작성
		//@2-3. 구현 메서드는 넘어온 예외에 대한 예외 전가 작성 (throws RemoteException)
		//@2-4. 직렬화(serializable) 가능한 매개변수만을 사용
		
		//#3. 클라이언트에서 사용할 스텁(stub) 클래스 생성 (과거에는 스켈레톤(skeleton) 클래스(서버쪽)가 함께 생성되었으나 현재는 동적으로 자동 생성) 
		//@3-1. 공통인터페이스 구현 클래스(.class) 파일을 다시 rmic(RMI 컴파일러)를 이용하여 컴파일 --> stub 클래스 생성
		//@3-2. 주의점. bin 폴더에서 "rmic 패키지명.구현클래스명"으로 실행 (.class 삭제)
				
		//#4. RMI Registry 서비스 시작  (서버로의 접속을 위해 특정포트 (기본 1099)포트를 열어두고 접속 대기)
		//@4-1. LocateRegistry.createRegistry(포트번호) 메서드를 활용하여  RMI 서비스 시작
		//@4-2. 현재의 컴퓨터가 자동으로 서버화 (웹서버/톰캣서버 등처럼)
		
		//#5. 바인딩 (구현클래스 객체를 클라이언트들이 사용할 수 있도록 rmiregistry상에 등록하는 것)
		//@5-1. 구현클래스의 객체 생성 (RemoteException 처리) 
		//@5-2. 구현클래스 객체를 Naming 클래스의 bind() 메서드를 이용해 바인딩
	
		MyRemoteImpl mri = null; 
		try {			
			
			mri = new MyRemoteImpl();						
			Registry registry = LocateRegistry.createRegistry(1099); //rmiregistry를 따로 실행하지 않고 자동으로 기동
			Naming.rebind("rmi://127.0.0.1:1099/myBindingObject", mri);
			System.out.println("바인딩 완료(rmi://127.0.0.1:1099/myBindingObject)");
			System.out.println("원격 서비스 기능이 시작되었습니다....");
			
		} catch (RemoteException | MalformedURLException e) {}
		
		
	}
}
