package Stack;
/**
 * ջ�ṹ���ص����Ƚ����,����ջ,�����뵽�ľ����ӵ���,һ��һ�����ӵ�ͨ������ѹ��ȥ
 * ��ջ�ṹ��,ֻ��ջ���������ǿ��Է��ʵ�.
 * ��ջ(push):�����ݱ��浽ջ���Ĳ���,������ջ����ǰ,���޸�ջ������ʹ�������ƶ�һ��λ��,
 * Ȼ�����ݱ��浽ջ��������ָ��λ��.ͨ���޸�ջ������ʹ��ָ��ջ�е���һ��Ԫ��.
 * ����������������ջ�Ľ������,��������λ����0,���Ǳ���������,��1��ʼ
 * ��ջ(pop):��ջ��
 * @author feiyu
 *
 */
public class StackType {
	
	static final int MAXLEN = 50;                        //ջ����󳤶�
	DATA3 [] data = new DATA3[MAXLEN+1];                 //����Ԫ��
	int top;                                             //ջ��
	
	/**
	 * ��ʼ������
	 * @return
	 */
	public StackType SYInit(){
		StackType p;
		if((p=new StackType())!=null){                   //�����ڴ�
			p.top = 0;                                   //����ջ��Ϊ0
			return p;                                    //����ջ����
		}
		return null;
	}
	/**
	 * �ж��Ƿ�Ϊ��ջ 
	 * @param s  
	 * @return true ��ջ false ����
	 */
	public boolean STIsEmpty(StackType s){
		if(s!=null){
			return s.top == 0;
		}
		return false;
	}
	
	/**
	 * �ж��Ƿ�Ϊ��ջ
	 * @param s
	 * @return true ��ջ false ����
	 */
	public boolean SLIsFull(StackType s){
		if(s!=null){
			return s.top==MAXLEN;
		}
		return false;
	}
	
	/**
	 * ���ջֻ��Ҫ��ջ��top����0�Ϳ�����,��Ϊtop��ʾ��ջ��,ջ������0��,��Ȼ���ǿյ���
	 * @param s
	 */
	public void STClear(StackType s){
		if(s!=null){
			s.top=0;
		}
	}
	/**
	 * �ͷſռ�
	 * �����ջ�ķ�������,����ֻ�ǰ�ջ������Ϊ0,��û���ͷſռ�,ֻ��Ҫ��ջ������ָ��null
	 * @param s
	 */
	public void STFree(StackType s){
		if(s!=null){
			s = null;
		}
	}
	/**
	 * ��ջ��ջ�ṹ�Ļ�������,��Ҫ�����ǽ�����Ԫ�ر��浽ջ�ṹ,��������:
	 * 1.�����ж�ջ�Ƿ�����,�������,����ջ
	 * 2.����top=top+1,(ջ�����ü�1,ָ����ջ��ַ)
	 * 3.����ջԪ��ָ��top���ڵ�λ��
	 * @param s
	 * @param data
	 * @return
	 */
	public int STPush(StackType s,DATA3 data){
		if(SLIsFull(s)){                                     //�ж��Ƿ��Ѿ�����
			System.out.println("��ĵ����Ѿ�����! \n");
			return 0;
		}
		s.data[++s.top] = data;                              //��Ԫ�ر��浽++s.top��λ��
		return 1;
	}
	/**
	 * ��ջ��ջ�Ļ�������,����ջ�෴,��Ҫ�Ǵ�ջ������һ������,��������:
	 * 1.�����ж��Ƿ��Ѿ��Ǹ��յ���
	 * 2.��ջ������top��ָ���Ԫ�ط���
	 * 3.ջ������top��1,Ҳ����ָ�������һ��Ԫ�� 
	 * @param s
	 * @param data
	 * @return
	 */
	public DATA3 STpop(StackType s){
		if(STIsEmpty(s)){
			System.out.println("��ĵ���û���ӵ���!");
			return null;
		}
		return s.data[s.top--];
	}
	/**
	 * ��ȡջ�Ľ��,��Ϊջ�Ĳ������Ǵ�һ�˶�ȡ,���Զ�ȡ���Ҳ��ջ����������,�ͳ�ջ��ͬ����,����ֻ��ȡ��ɾ��
	 * ����ջ�ǵ���,��û����
	 * @param s
	 * @return
	 */
	public DATA3 STPeek(StackType s){
		if(STIsEmpty(s)){
			System.out.println("��ĵ���û���ӵ���!");
		}
		return s.data[s.top];
	}
}
