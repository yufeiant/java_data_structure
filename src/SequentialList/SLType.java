package SequentialList;

public class SLType {
	static final int MAXLEN = 100;
	//定义顺序表结构
	DATA [] ListData = new DATA[MAXLEN+1];//保存顺序表的结构数组
	int ListLen;                          //顺序表已存节点的数量
	/**
	 * 初始化顺序表
	 * @param SL
	 */
	public void SLInit(SLType SL){
		SL.ListLen=0;//初始化空表
	}
	/**
	 * 返回顺序表的元素数量
	 */
	public int SLLength(SLType SL){
		return SL.ListLen;
	}
	/**
	 * 插入结点
	 * 插入结点就是在线性表的第i个位置插入一个新的结点,使得其后的结点编号依次加1,这时,插入一个结点后,线性表的长度L将变为
	 * n+1,插入结点的难点在于随后的每个结点的数据都要向后移动
	 * @return
	 */
	public int Insert(SLType SL,int n,DATA data){
		int i;
		if(SL.ListLen>=MAXLEN){                                //判断顺序表是否已满
			System.out.println("顺序表已满，不能插入结点！\n");
			return 0;
		}
		if(n<1||n>SL.ListLen-1){                               //判断插入符号是否正确
			System.out.println("插入元素序号错误，不能插入元素！\n");
			return 0;
		}	  
		for (int j = SL.ListLen; j>n; j--) {                     //将顺序表中的数据向后移动
			SL.ListData[j+1]=SL.ListData[j];
		}
		SL.ListData[n]=data;                                    //插入位置
		SL.ListLen++;
		return 1;                                               //成功插入,返回1
	}
	
	/**
	 * 增加元素到顺序表尾部
	 * @param SL
	 * @param data
	 * @return
	 */
	public int SLAdd(SLType SL,DATA data){
		
		if(SL.ListLen >= MAXLEN){                               //判断是否已满
			System.out.println("顺序表已满,不能再添加结点了");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}
	/**
	 * 删除顺序表中的数据元素
	 * 顺序表删掉第i个结点,那么之后的所有结点的位置都需要向前移动一个位置
	 * @return
	 */
	public int SLDeleteType(SLType SL,int n){
		int i;
		if(n<1||n>SL.ListLen-1){                               //判断插入符号是否正确
			System.out.println("删除元素符号错误！\n");
			return 0;
		}
		
		for (i = n; i < SL.ListLen; i++) {                    //顺序表中的元素向前移动
			SL.ListData[n+1] = SL.ListData[n];
		}
		
		SL.ListLen--;                                        //顺序表的元素数量减一
		return 1;
	}
	/**
	 * 按照序号查找结点
	 * @return
	 */
	public DATA SLFindByNum(SLType SL,int n){                 //根据序号返回数据元素
		if(n<1||n>SL.ListLen-1){
			System.out.println("查找符号错误！\n");
			return null;
		}
		return SL.ListData[n];
	}
	/**
	 * 按照关键字查找结点  返回结点序号
	 * @return
	 */
	public int SLFindByCout(SLType SL,String key){           //按照关键字查找元素
		int j;
		for (j = 1; j < SL.ListLen; j++) {
			if(SL.ListData[j].key.compareTo(key)==0){
				return j;
			}
		}
		return 0;
	}
	/**
	 * 返回所有结点
	 * @return
	 */
	public int SLAll(SLType SL){
		int i;
		for(i =1;i<SL.ListLen;i++){
			System.out.printf("(%s,%s,%d)\n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
		}
		return i;
	}
}
