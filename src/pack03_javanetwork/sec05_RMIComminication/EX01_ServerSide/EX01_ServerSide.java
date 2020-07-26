package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*RMI ��ſ��� : RMI ���ݼ��� ��ü�� �޼��� ȣ�� [ServerSide]*/

        //RMI (Remote Method Invocation) : ����Ʈ ��Ʈ 1099 (�л�ȯ��)
		//rmi registry�� ������� �ʰ� java�� LocateRegistry.class, Registry.class�� ���
		//��ġ ����
		//������ ���� Ŭ������ rmic �����Ϸ��� �������ϸ� ���̷���Ŭ����(����), ����Ŭ����(Ŭ���̾�Ʈ) ���� (����Ŭ������ Ŭ���̾�Ʈ���� ����)
		//������ Ŭ���̾�Ʈ���� ������ �޼��带 ������ ��ü�� ���ε� 
		//		
		//������ Ŭ���̾�Ʈ �� ��� ����� �����ϴ� Ŭ���� 
		//���̷���(skeleton): ����, ���
		//����(stub):�丷, ���翬��
		//		
		//RMI: ���� �ڹٷ� �ۼ� JVM�� ������ �߰����� �̵���� ���� ��� ����
		//CORBA(RMI�� ������ �����̳� �ٸ� ������ ȣȯ���� ���� ����), EJB(Enterprize Java Bean) ���� �̵��� �ʿ�
		
		//�߿� package: java.rmi, java.rmi.registry, java.rmi.server (�̿� java.rmi.dgc(distribute gabage collection): �л�ȯ�濡�� ������ ������
		//Registry Interface (��ü ���ε�)

public class EX01_ServerSide {
	public static void main(String[] args) {
		//#1. ���� �������̽� ����
		//@1-1. public + Remote �������̽� ��� (Remote Interface�� Mark�� �������̽�(���ο� �߻� �޼��� ����))	
		//@1-2. ���� ������ �������� �ϴ� ������ �߻�޼��� ���� �� ���� ���� �ۼ� (throws RemoteException)
		//@1-3. ����ȭ(serializable) ������ �Ű����� �� ���ϰ����� ���		
		
		//#2. �����������̽� ���� Ŭ���� �����ϱ�
		//@2-1. public + �����������̽� ����(implements) + UnicastRemoteObject ���
		//@2-2. ���� ���� �ۼ� (throws RemoteException)�� ���� ������ �ϳ� �̻� �ۼ�
		//@2-3. ���� �޼���� �Ѿ�� ���ܿ� ���� ���� ���� �ۼ� (throws RemoteException)
		//@2-4. ����ȭ(serializable) ������ �Ű��������� ���
		
		//#3. Ŭ���̾�Ʈ���� ����� ����(stub) Ŭ���� ���� (���ſ��� ���̷���(skeleton) Ŭ����(������)�� �Բ� �����Ǿ����� ����� �������� �ڵ� ����) 
		//@3-1. �����������̽� ���� Ŭ����(.class) ������ �ٽ� rmic(RMI �����Ϸ�)�� �̿��Ͽ� ������ --> stub Ŭ���� ����
		//@3-2. ������. bin �������� "rmic ��Ű����.����Ŭ������"���� ���� (.class ����)
				
		//#4. RMI Registry ���� ����  (�������� ������ ���� Ư����Ʈ (�⺻ 1099)��Ʈ�� ����ΰ� ���� ���)
		//@4-1. LocateRegistry.createRegistry(��Ʈ��ȣ) �޼��带 Ȱ���Ͽ�  RMI ���� ����
		//@4-2. ������ ��ǻ�Ͱ� �ڵ����� ����ȭ (������/��Ĺ���� ��ó��)
		
		//#5. ���ε� (����Ŭ���� ��ü�� Ŭ���̾�Ʈ���� ����� �� �ֵ��� rmiregistry�� ����ϴ� ��)
		//@5-1. ����Ŭ������ ��ü ���� (RemoteException ó��) 
		//@5-2. ����Ŭ���� ��ü�� Naming Ŭ������ bind() �޼��带 �̿��� ���ε�
	
		MyRemoteImpl mri = null; 
		try {			
			
			mri = new MyRemoteImpl();						
			Registry registry = LocateRegistry.createRegistry(1099); //rmiregistry�� ���� �������� �ʰ� �ڵ����� �⵿
			Naming.rebind("rmi://127.0.0.1:1099/myBindingObject", mri);
			System.out.println("���ε� �Ϸ�(rmi://127.0.0.1:1099/myBindingObject)");
			System.out.println("���� ���� ����� ���۵Ǿ����ϴ�....");
			
		} catch (RemoteException | MalformedURLException e) {}
		
		
	}
}
