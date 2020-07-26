package pack03_javanetwork.sec05_RMIComminication.EX01_ServerSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*RMI ��ſ��� : RMI ���ݼ��� ��ü�� �޼��� ȣ�� [ServerSide]*/

//#1. ���� �������̽� ����
//@1-1. public + Remote �������̽� ��� (Remote Interface�� Mark�� �������̽�(���ο� �߻� �޼��� ����))	
//@1-2. ���� ������ �������� �ϴ� ������ �߻�޼��� ���� �� ���� ���� �ۼ� (throws RemoteException)
//@1-3. ����ȭ(serializable) ������ �Ű����� �� ���ϰ����� ���		

public interface MyRemote extends Remote{
	//�������� ������ �޼���
	public abstract String myRemoteMethod(String str) throws RemoteException; 
}
