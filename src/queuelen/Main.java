package queuelen;

import SequentialList.DATA;

import java.util.Scanner;

/**
 * Created by feiyu on 2017/10/25.
 * 在这里我们测试一下队列结构
 */
public class Main {
    public static void main(String [] args ){
        SQType sq = new SQType();
        DATA4 data1 ;
        Scanner input = new Scanner(System.in);

        SQType stack = sq.SQTypeInit();                       //初始化一个队列
        System.out.println("入队列操作演示:");
        System.out.println("输入姓名 年龄进行入队列操作");
        do
        {
            DATA4 data = new DATA4();
            System.out.println("请输入姓名:如果输入0则退出循环!");
            data.name = input.next();
            if(data.name.equals("0")){
                break;
            }else {
                System.out.println("请输入年龄:");
                data.age = input.nextInt();
                sq.SQTypeInsert(stack,data);
            }
        }while (true);

        String temp = "1";
        System.out.println("出队列操作:按任意非0键执行出队列操作");
        temp = input.next();
        while (!temp.equals("0")){
            data1 = sq.SQTypeOut(stack);
            if(data1==null){
                break;
            }
            System.out.printf("出队列的数据是:(%s,%d)",data1.name,data1.age);
            temp  =input.next();
        }
        System.out.println("释放队列操作结束!");
        sq.SQTypeClear(stack);
    }
}
