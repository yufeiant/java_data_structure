package LinkedList;
/**
 * ���ݽ������
 * ��������ṹ
 * @author feiyu
 *
 */
public class CLType {
	DATA2 nextData  = new DATA2();     //��ǰ������������
	CLType nextNode;                   //������һ������λ��
	/**
	 * ׷��һ�����
	 * 1.���ȷ����ڴ�ռ�,���������Ľ��
	 * 2.��ͷ���ÿ�ʼ���,ֱ���ҵ����һ�����,
	 * 3.����β�����ڴ��ַ��Ϊ�µĽ��
	 * 4.���µĽ��ĵ�ַ��������Ϊ�յ�ַ,null,���½���Ϊ��β.
	 * @param head ͷ���
	 * @param nodeData �������
	 * @return ����ͷ���
	 */
	public CLType CLAddEnd(CLType head,DATA2 nodeData){
		                                //1.�����ڴ�,���������Ľ������
		CLType node,htemp;
		if((node=new CLType())==null){
			System.out.println("�����ڴ�ʧ��! \n");
			return null;
		}else{
			
			node.nextData = nodeData;   //2.��������
			node.nextNode = null;       //3.������һ����������Ϊnull,��Ϊ׷�ӵ��������β
			if(head ==null){            //4.�ж���ͷ�Ƿ�Ϊ��,���Ϊ��,��ֱ�Ӹ�ֵ������
				head = node;
				return head;
			}
			htemp = head;
			while(htemp.nextNode !=null){//5.ѭ���ж��Ƿ�����β,���������β������ж�
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;       //6.�ж���ɺ�����϶�����β��,ֱ�Ӹ�ֵ
			return head;
		}
	}
	/**
	 * ����ͷ���
	 * 1.�����ڴ�ռ�,���������Ľ��
	 * 2.���������ָ��ͷ���õ�head��ָ��Ľ��
	 * 3.ʹͷ����ָ�������Ľ�� ,�е���,���ǽ�����һ��λ��,��headԭ����ͷ���ָ���µ�ͷ���
	 * @param head
	 * @param nodeData
	 * @return
	 */
	public CLType CLAddFirst(CLType head,DATA2 nodeData){
		CLType node;
		if((node =new CLType())==null){
			System.out.println("�����ڴ�ʧ��! \n");
			return null;
		}else{
			node.nextData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	/**
	 * ���ҽ��
	 * @param head ͷ���
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
	 * ������
	 * 1.�����ڴ�ռ�,���������Ľ��
	 * 2.���ҹؼ���,�ҵ���Ҫ����Ľ��λ�ò�����
	 * 3.���ҵ��Ľ��λ�õ�ַ���浽�µĽ���ַλ��
	 * 4.���ҵ��Ľ��λ��ָ���µĽ��
	 * @param head
	 * @param findkey
	 * @param nodeData
	 * @return
	 */
	public CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData){
		CLType node,nodetemp;
		if((node=new CLType())==null){
			System.out.println("�����ڴ�ʧ��! \n");
			return null;
		}
		
		node.nextData = nodeData;
		nodetemp = head.CLFindNode(head, findkey);
		if(nodetemp!=null){
			node.nextNode = nodetemp.nextNode;
			nodetemp.nextNode = node;
		}else{
			System.out.println("����ʧ�� \n");
		}
		return head;
	}
	/**
	 * ɾ�����
	 * 1.�ҵ�Ҫɾ���Ľ��λ��
	 * 2.��ǰһ�����ָ��ǰ���ĺ�һ�����
	 * 3.ɾ�����
	 * @param head
	 * @param key
	 * @return
	 */
	public int CLDeleteNode(CLType head,String key){
		CLType node,htemp;                           //������һ�����͵�ǰ���
		htemp = head;                                //���浱ǰ���
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
	 * ��ȡ����ĳ���
	 * 1.�ӱ�����β,Ȼ������ۼ�
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
	 * ��ʾ���н��
	 * @param head
	 */
	public void CLAllNode(CLType head){
		CLType htemp;
		htemp = head;
		DATA2 nodeData;
		while(htemp!=null){
			nodeData = htemp.nextData;
			System.out.printf("���(%s,%s,%d) \n",nodeData.key,nodeData.name,nodeData.age);
			htemp = htemp.nextNode;
		}
	}
}
