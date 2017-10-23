package LinkedList;
/**
 * 数据结点类型
 * 定义链表结构
 * @author feiyu
 *
 */
public class CLType {
	DATA2 nextData  = new DATA2();     //当前结点的数据类型
	CLType nextNode;                   //储存下一个结点的位置
	/**
	 * 追加一个结点
	 * 1.首先分配内存空间,保存新增的结点
	 * 2.从头引用开始检查,直到找到最后一个结点,
	 * 3.将结尾结点的内存地址设为新的结点
	 * 4.将新的结点的地址部分设置为空地址,null,即新结点成为表尾.
	 * @param head 头结点
	 * @param nodeData 结点数据
	 * @return 返回头结点
	 */
	public CLType CLAddEnd(CLType head,DATA2 nodeData){
		                                //1.分配内存,保存新增的结点数据
		CLType node,htemp;
		if((node=new CLType())==null){
			System.out.println("申请内存失败! \n");
			return null;
		}else{
			
			node.nextData = nodeData;   //2.保存数据
			node.nextNode = null;       //3.设置下一个结点的索引为null,因为追加的这个是链尾
			if(head ==null){            //4.判断链头是否为空,如果为空,则直接赋值并返回
				head = node;
				return head;
			}
			htemp = head;
			while(htemp.nextNode !=null){//5.循环判断是否是链尾,如果不是链尾则继续判断
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;       //6.判断完成后这个肯定是链尾了,直接赋值
			return head;
		}
	}
	/**
	 * 插入头结点
	 * 1.分配内存空间,保存新增的结点
	 * 2.将新增结点指向头引用的head所指向的结点
	 * 3.使头引用指向新增的结点 ,有点绕,就是交换了一下位置,让head原来的头结点指向新的头结点
	 * @param head
	 * @param nodeData
	 * @return
	 */
	public CLType CLAddFirst(CLType head,DATA2 nodeData){
		CLType node;
		if((node =new CLType())==null){
			System.out.println("申请内存失败! \n");
			return null;
		}else{
			node.nextData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	/**
	 * 查找结点
	 * @param head 头结点
	 * @param findkey 
	 * @return
	 */
	public CLType CLFindNode(CLType head,String findkey){
		CLType htemp;
		htemp = head;
		while(htemp.nextNode!=null){
			if(htemp.nextData.key.compareTo(findkey)==0){
				return htemp; 
			}
			htemp = htemp.nextNode;
		}
		return null;
	}
	
	/**
	 * 插入结点
	 * 1.分配内存空间,保存新增的结点
	 * 2.查找关键字,找到需要插入的结点位置并返回
	 * 3.把找到的结点位置地址保存到新的结点地址位置
	 * 4.把找到的结点位置指向新的结点
	 * @param head
	 * @param findkey
	 * @param nodeData
	 * @return
	 */
	public CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData){
		CLType node,nodetemp;
		if((node=new CLType())==null){
			System.out.println("申请内存失败! \n");
			return null;
		}
		
		node.nextData = nodeData;
		nodetemp = head.CLFindNode(head, findkey);
		if(nodetemp!=null){
			node.nextNode = nodetemp.nextNode;
			nodetemp.nextNode = node;
		}else{
			System.out.println("插入失败 \n");
		}
		return head;
	}
	/**
	 * 删除结点
	 * 1.找到要删除的结点位置
	 * 2.把前一个结点指向当前结点的后一个结点
	 * 3.删除结点
	 * @param head
	 * @param key
	 * @return
	 */
	public int CLDeleteNode(CLType head,String key){
		CLType node,htemp;                           //保存上一个结点和当前结点
		htemp = head;                                //保存当前结点
		node = head;
		while(htemp!=null){
			if(htemp.nextData.key.compareTo(key)==0){
				node.nextNode = htemp.nextNode;
				htemp = null;
				return 1;
			}else{
				node = htemp;
				htemp = htemp.nextNode;
			}
		}
		return 0;
	}
	/**
	 * 获取链表的长度
	 * 1.从遍历到尾,然后进行累加
	 * @return
	 */
	public int CLLength(CLType head){
		int length = 0;
		CLType htemp = head;
		while(htemp!=null){
			length++;
			htemp = htemp.nextNode;
		}
		return length;
	}
	/**
	 * 显示所有结点
	 * @param head
	 */
	public void CLAllNode(CLType head){
		CLType htemp;
		htemp = head;
		DATA2 nodeData;
		while(htemp!=null){
			nodeData = htemp.nextData;
			System.out.printf("结点(%s,%s,%d) \n",nodeData.key,nodeData.name,nodeData.age);
			htemp = htemp.nextNode;
		}
	}
}
