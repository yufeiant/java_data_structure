package Stack;
/**
 * 栈结构的特点是先进后出,看到栈,首先想到的就是子弹夹,一个一个的子弹通过上面压进去
 * 在栈结构中,只有栈顶的数据是可以访问的.
 * 入栈(push):将数据保存到栈顶的操作,进行入栈操作前,先修改栈顶引用使其向上移动一个位置,
 * 然后将数据保存到栈顶引用所指的位置.通过修改栈顶引用使其指向栈中的下一个元素.
 * 我们用数组来保存栈的结点数据,数组的起点位置是0,我们保存结点数据,从1开始
 * 出栈(pop):将栈顶
 * @author feiyu
 *
 */
public class StackType {
	
	static final int MAXLEN = 50;                        //栈的最大长度
	DATA3 [] data = new DATA3[MAXLEN+1];                 //数据元素
	int top;                                             //栈顶
	
	/**
	 * 初始化操作
	 * @return
	 */
	public StackType SYInit(){
		StackType p;
		if((p=new StackType())!=null){                   //申请内存
			p.top = 0;                                   //设置栈顶为0
			return p;                                    //返回栈引用
		}
		return null;
	}
	/**
	 * 判断是否为空栈 
	 * @param s  
	 * @return true 空栈 false 不是
	 */
	public boolean STIsEmpty(StackType s){
		if(s!=null){
			return s.top == 0;
		}
		return false;
	}
	
	/**
	 * 判断是否为满栈
	 * @param s
	 * @return true 满栈 false 不是
	 */
	public boolean SLIsFull(StackType s){
		if(s!=null){
			return s.top==MAXLEN;
		}
		return false;
	}
	
	/**
	 * 清空栈只需要把栈的top设置0就可以了,因为top表示的栈顶,栈顶都是0了,当然就是空的了
	 * @param s
	 */
	public void STClear(StackType s){
		if(s!=null){
			s.top=0;
		}
	}
	/**
	 * 释放空间
	 * 在清空栈的方法里面,我们只是把栈顶设置为0,并没有释放空间,只需要把栈的引用指向null
	 * @param s
	 */
	public void STFree(StackType s){
		if(s!=null){
			s = null;
		}
	}
	/**
	 * 入栈是栈结构的基本操作,主要操作是将数据元素保存到栈结构,步骤如下:
	 * 1.首先判断栈是否已满,如果不满,则入栈
	 * 2.设置top=top+1,(栈顶引用加1,指向入栈地址)
	 * 3.将入栈元素指向top所在的位置
	 * @param s
	 * @param data
	 * @return
	 */
	public int STPush(StackType s,DATA3 data){
		if(SLIsFull(s)){                                     //判断是否已经满了
			System.out.println("你的弹夹已经满了! \n");
			return 0;
		}
		s.data[++s.top] = data;                              //将元素保存到++s.top的位置
		return 1;
	}
	/**
	 * 出栈是栈的基本操作,与入栈相反,主要是从栈顶弹出一个操作,步骤如下:
	 * 1.首先判断是否已经是个空的了
	 * 2.将栈顶引用top所指向的元素返回
	 * 3.栈顶引用top减1,也就是指向下面的一个元素 
	 * @param s
	 * @param data
	 * @return
	 */
	public DATA3 STpop(StackType s){
		if(STIsEmpty(s)){
			System.out.println("你的弹夹没有子弹了!");
			return null;
		}
		return s.data[s.top--];
	}
	/**
	 * 读取栈的结点,因为栈的操作都是从一端读取,所以读取结点也是栈顶结点的数据,和出栈不同的是,这里只读取不删除
	 * 而出栈是弹出,就没有了
	 * @param s
	 * @return
	 */
	public DATA3 STPeek(StackType s){
		if(STIsEmpty(s)){
			System.out.println("你的弹夹没有子弹了!");
		}
		return s.data[s.top];
	}
}
