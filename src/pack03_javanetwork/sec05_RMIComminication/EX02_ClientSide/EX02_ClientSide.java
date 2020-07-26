package pack04_javanetwork.sec05_RMIComminication.EX02_ClientSide;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import pack04_javanetwork.sec05_RMIComminication.EX01_ServerSide.MyRemote;

public class EX02_ClientSide {
	public static void main(String[] args) {
		//#1. �������� ������ 2���� ���� ����
		//@1-1. �����������̽�.class
		//@1-2. ����Ŭ����_stub.class
		
		//#2. ������ ���ε� �Ǿ� �ִ� ��ü ���纻 �������� 
		//@2-1.  ���ε� �Ǿ� �ִ� �̸����� ��ü ���纻 �������� (Naming Ŭ������ lookup() �޼��� ���)
		
		//#3. ������ ��ü�� �޼��� ���
		//@3-1. �޼��� ����� ���� ������ ���������� �Ͼ (���� �ý���)

		try {
			MyRemote mr = (MyRemote)Naming.lookup("rmi://127.0.0.1:1099/myBindingObject"); //"rmi://�����ּ�/���ε��̸�"
			String str = mr.myRemoteMethod("�ȳ��ϼ���!");
			System.out.println(str);			
		} 
		catch (MalformedURLException e) {} 
		catch (RemoteException e) {}
		catch (NotBoundException e) {} 
		
	}
}
