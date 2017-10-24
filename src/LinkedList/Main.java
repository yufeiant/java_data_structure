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

		System.out.println("链表测试,先输入链表中的数据.格式为:关键字 姓名 年龄  \n");
		do{
			DATA2 nodeData = new DATA2();
			System.out.println("请输入关键字 \n");
			nodeData.key = input.next();
			if(nodeData.key.equals("0")){                              //判断关键字是否为0
				break;
			}else{
				System.out.println("请输入姓名 \n");
				nodeData.name = input.next();
				System.out.println("请输入年龄 \n");
				nodeData.age = input.nextInt();
				head = CL.CLAddEnd(head, nodeData);             //在链表结尾添加结点

				if(CL.CLFindNode(head, nodeData.key)!=null){
					System.out.println("输入成功");
				}
				CL.CLAllNode(head);
			}
		}
		while(true);

		CL.CLAllNode(head);
		System.out.println("\n 演示插入结点,输入插入位置的关键字:");
		findkey = input.next();
		System.out.println("输入插入结点的数据(关键字 姓名 年龄) \n");

		DATA2 nodeData1 = new DATA2();
		nodeData1.key = input.next();
		nodeData1.name = input.next();
		nodeData1.age = input.nextInt();

		head.CLInsertNode(head, findkey, nodeData1);           //调用插入函数
		CL.CLAllNode(head);

		System.out.println("\n 演示删除结点,输入要删除的关键字:");
		key = input.next();
		CL.CLDeleteNode(head, key);                            //删除结点
		CL.CLAllNode(head);

		System.out.println("\n 演示在链表中查找,输入查找关键字;");
		key = input.next();
		node = CL.CLFindNode(head, key);                         //调用查找关键字,返回结点引用
		if(node!=null){                                          //若返回结点引用有效
			DATA2 nodeData2 = node.nextData;
			System.out.printf("关键字%s对应的结点为(%s,%s,%d)",key,nodeData2.key,nodeData2.name,nodeData2.age);
		}
		else{
			System.out.printf("在链表中没有找到关键字为%s的结点",key);
		}
		System.out.println("\n 演示完毕,链表结构演示完毕");
	}
}
