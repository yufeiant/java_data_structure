package queuelen;

/**
 * Created by feiyu on 2017/10/25.
 * 队列数据结构
 */
public class SQType {
    static final int QUEUELEN = 15;                   //队列的最大长度
    DATA4 [] data = new DATA4[QUEUELEN];              //保存队列的数组结构
    int head;                                         //对头
    int tail;                                         //对尾

    /**
     * 初始化队列结构
     * 1.按符号常量QUEUELEN指定的大小申请一片内存空间,用来保存队列中的数据
     * 2.设置head=0和tail=0表示一个空栈.
     * @return
     */
    public SQType SQTypeInit(){
        SQType q;
        if((q=new SQType())!=null){                    //申请内存
            q.head = 0;                                //设置队头
            q.tail = 0;                                //设置队尾
            return q;
        }else {
            return null;
        }
    }

    /**
     * 判断是否是空队列
     * @param q
     * @return
     */
    public boolean SQTypeIsEmpty(SQType q){
        if(q!=null){
            return q.head ==q.tail;
        }
        return false;
    }

    /**
     * 判断是否是满队列
     * @param q
     * @return
     */
    public boolean SQTypeIsFull(SQType q){
        if(q!=null){
            return q.tail == QUEUELEN;
        }
        return false;
    }

    /**
     * 释放空间
     */
    public void SQTypeClear(SQType q){
        if(q!=null){
            q.head = 0;
            q.tail = 0;
        }
    }

    /**
     * 入队列
     * 这个是队列的主要操作,主要操作是将数据元素从队列底保存到队列结构.主要有如下几个步骤:
     * 1.首先判断tail是否等于QUEUELEN,也就是是否满了;
     * 2.设置tail=tail+1;(队列顶引用加1,指向入队列地址);
     * 3.将入队列元素指向;
     * @return
     */
    public boolean SQTypeInsert(SQType q,DATA4 data){
        if(!SQTypeIsFull(q)){                                        //判断队列是否满了
            q.data[q.tail++] = data;                                 //
            return true;                                             //入队列成功
        }
        return false;                                                //入队列失败
    }

    /**
     * 出队列
     * 这个是队列的主要操作,和入队列相反,其操作是从队列顶弹出一个数据元素.有如下几个步骤
     * 1.判断head是否等于tail,也就是队首是否等于队尾,判断是否是空队列
     * 2.从队列首部取出队头元素,(实际是返回对头元素的引用)
     * 3.设置对头head的序号,让其指向后一个元素
     * 最后返回弹出的元素
     * @return
     */
    public DATA4 SQTypeOut(SQType q){

        if(!SQTypeIsEmpty(q)){                                      //判断队列是否为空
           return q.data[q.head++];                                 //从队列取出数据,并且head指向下一个元素
        }
        return null;
    }

    /**
     * 读取结点
     * 和出队列类似,区别就是读取完数据后不会把数据指向下一个元素
     * 1.判断队列是否为空
     *
     * @return
     */
    public DATA4 SQTypePeek(SQType q){
        if(!SQTypeIsEmpty(q)){                                       //判断队列是否为空
            return q.data[q.head];                                   //从队列取出数据
        }
        return null;
    }

    /**
     * 计算队列的长度
     * @return
     */
    public int SQTypeInt(SQType q){
        int len = 0;
        if(q!=null){
            len = q.tail-q.head;
        }
        return len;
    }
}
