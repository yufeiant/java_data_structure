package LinkedList;

import java.util.Scanner;

/**
 * Created by feiyu on 2017/10/20.
 */
public class Main {
	public static void main(String [] args){
		CLType node,head = null;
		CLType CL = new CLType();
		String key,findkey;
		Scanner input = new Scanner(System.in); 
		
		System.out.println("�������,�����������е�����.��ʽΪ:�ؼ��� ���� ����  \n");
		do{
			DATA2 nodeData = new DATA2();
			System.out.println("������ؼ��� \n");
			nodeData.key = input.next();
			if(nodeData.key.equals("0")){                              //�жϹؼ����Ƿ�Ϊ0
				break;
			}else{
				System.out.println("���������� \n");
				nodeData.name = input.next();
				System.out.println("���������� \n");
				nodeData.age = input.nextInt();
				head = CL.CLAddEnd(head, nodeData);             //�������β��ӽ��
				
				if(CL.CLFindNode(head, nodeData.key)!=null){
					System.out.println("����ɹ�");
				}
				CL.CLAllNode(head);
			}
		}
		while(true);
		
		CL.CLAllNode(head);
		System.out.println("\n ��ʾ������,�������λ�õĹؼ���:");
		findkey = input.next();
		System.out.println("��������������(�ؼ��� ���� ����) \n");
		
		DATA2 nodeData1 = new DATA2();
		nodeData1.key = input.next();
		nodeData1.name = input.next();
		nodeData1.age = input.nextInt();
		
		head.CLInsertNode(head, findkey, nodeData1);           //���ò��뺯��
		CL.CLAllNode(head);
		
		System.out.println("\n ��ʾɾ�����,����Ҫɾ���Ĺؼ���:");
		key = input.next();
		CL.CLDeleteNode(head, key);                            //ɾ�����
		CL.CLAllNode(head);
		
		System.out.println("\n ��ʾ�������в���,������ҹؼ���;");
		key = input.next();
		node = CL.CLFindNode(head, key);                         //���ò��ҹؼ���,���ؽ������
		if(node!=null){                                          //�����ؽ��������Ч
			DATA2 nodeData2 = node.nextData;
			System.out.printf("�ؼ���%s��Ӧ�Ľ��Ϊ(%s,%s,%d)",key,nodeData2.key,nodeData2.name,nodeData2.age);
		}
		else{
			System.out.printf("��������û���ҵ��ؼ���Ϊ%s�Ľ��",key);
		}
		System.out.println("\n ��ʾ���,����ṹ��ʾ���");
	}
}
