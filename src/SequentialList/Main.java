package SequentialList;

import java.util.Scanner;

//实战操作演示顺序表结构
public class Main {

	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();                        //定义顺序表变量
		DATA pdata;                                      //定义结点保存引用变量
		String key;                                      //保存关键字
		
		System.out.println("顺序表操作演示! \n");
		
		SL.SLInit(SL);                                   //初始化顺序表
		System.out.println("顺序表初始化完成! \n");
		
		Scanner input =  new Scanner(System.in);
		
		do{
			System.out.println("请输入添加的结点(学号 姓名 年龄):");
			DATA data = new DATA();
			data.key = input.next();
			System.out.println("请输入添加的结点(学号 key =):"+data.key);
			data.name = input.next();
			System.out.println("请输入添加的结点(姓名 name =):"+data.name);
			data.age = input.nextInt();
			System.out.println("请输入添加的结点(年龄 age =):"+data.age);
			
			if(data.age!=0){
				if(SL.SLAdd(SL, data)==0){                 //如果返回是0,则添加失败
					break;
				}
			}else{
				break;
			}
		}while(true);
		
		System.out.println("\n 顺序表的结点顺序是: \n");
		SL.SLAll(SL);
		
		System.out.println("\n 要取出的结点序号为: ");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为:(%d,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
		System.out.println("\n 要查找结点的关键字:");
		
		key = input.next();
		i = SL.SLFindByCout(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为:(%d,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
	}

}
