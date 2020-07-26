package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pack04_javanetwork.sec05_RMIComminication.EX01_ServerSide.MyRemote;

 
/*RMI ��ſ��� : RMI ���ݼ��� ��ü�� �޼��� ȣ�� [ServerSide]*/

//#2. �����������̽� ���� Ŭ���� �����ϱ�
//@2-1. public + �����������̽� ����(implements) + UnicastRemoteObject ���
//@2-2. ���� ���� �ۼ� (throws RemoteException)�� ���� ������ �ϳ� �̻� �ۼ�
//@2-3. ���� �޼���� �Ѿ�� ���ܿ� ���� ���� ���� �ۼ� (throws RemoteException)
//@2-4. ����ȭ(serializable) ������ �Ű��������� ���

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

	//private static final long serialVersionUID = 1L; //Remote�� �����Ͽ� Serializable�� �ʼ������� ��� serial ������ �Է� (������ ���)

	protected MyRemoteImpl() throws RemoteException {
		super(); 
	}

	@Override
	public String myRemoteMethod(String str) throws RemoteException {
		System.out.println("���ݸ޼���: myRemoteMethod()"); //���ݼ������� ���� (���ݼ������� ���)
		return "���ݸ޼���: ���޹��� ���ڿ� = " + str; //Client���� ���޵Ǵ� ����
	}
	
}
