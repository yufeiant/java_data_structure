package SequentialList;

import java.util.Scanner;

//ʵս������ʾ˳���ṹ
public class Main {

	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();                        //����˳������
		DATA pdata;                                      //�����㱣�����ñ���
		String key;                                      //����ؼ���
		
		System.out.println("˳��������ʾ! \n");
		
		SL.SLInit(SL);                                   //��ʼ��˳���
		System.out.println("˳����ʼ�����! \n");
		
		Scanner input =  new Scanner(System.in);
		
		do{
			System.out.println("��������ӵĽ��(ѧ�� ���� ����):");
			DATA data = new DATA();
			data.key = input.next();
			System.out.println("��������ӵĽ��(ѧ�� key =):"+data.key);
			data.name = input.next();
			System.out.println("��������ӵĽ��(���� name =):"+data.name);
			data.age = input.nextInt();
			System.out.println("��������ӵĽ��(���� age =):"+data.age);
			
			if(data.age!=0){
				if(SL.SLAdd(SL, data)==0){                 //���������0,�����ʧ��
					break;
				}
			}else{
				break;
			}
		}while(true);
		
		System.out.println("\n ˳���Ľ��˳����: \n");
		SL.SLAll(SL);
		
		System.out.println("\n Ҫȡ���Ľ�����Ϊ: ");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("��%d�����Ϊ:(%d,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
		System.out.println("\n Ҫ���ҽ��Ĺؼ���:");
		
		key = input.next();
		i = SL.SLFindByCout(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("��%d�����Ϊ:(%d,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
	}

}
