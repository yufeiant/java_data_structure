package Stack;

import java.util.Scanner;

/**
 * 这里我们测试一下栈结构的代码
 * Created by feiyu on 2017/10/24.
 */
public class Main {
    public static void main(String args []){
        //首先创建一个栈结构
        StackType st = new StackType();
        //创建一个结点数据
        DATA3 data1 = new DATA3();
        //初始化栈
        StackType stack = st.SYInit();                //设置栈顶为0
        Scanner input = new Scanner(System.in);
        System.out.println("\n 要取出的结点序号为: ");
        System.out.println("输入姓名 年龄进行入栈操作");
        do
        {
            DATA3 data = new DATA3();
            System.out.println("\n 请输入姓名: ");
            data.name=input.next();
            if(data.name.equals("0")){
                break;
            }
            else
            {
                System.out.println("\n 请输入年龄: ");
                data.age = input.nextInt();
                st.STPush(stack,data);
            }
        }while (true);

        String temp = "1";
        System.out.println("出栈操作:按任意非0键进行出栈操作");
        temp = input.next();
        while (!temp.equals("0")){
            data1 = st.STpop(stack);
            if(data1!=null){
                System.out.printf("出栈的数据是(%s,%d)",data1.name,data1.age);
                temp = input.next();
            }else {
                break;
            }

        }
        System.out.println("\n 测试结束 ");
        st.STFree(st);
    }

}
