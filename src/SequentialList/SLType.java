package SequentialList;

public class SLType {
	static final int MAXLEN = 100;
	//����˳���ṹ
	DATA [] ListData = new DATA[MAXLEN+1];//����˳���Ľṹ����
	int ListLen;                          //˳����Ѵ�ڵ������
	/**
	 * ��ʼ��˳���
	 * @param SL
	 */
	public void SLInit(SLType SL){
		SL.ListLen=0;//��ʼ���ձ�
	}
	/**
	 * ����˳����Ԫ������
	 */
	public int SLLength(SLType SL){
		return SL.ListLen;
	}
	/**
	 * ������
	 * ��������������Ա�ĵ�i��λ�ò���һ���µĽ��,ʹ�����Ľ�������μ�1,��ʱ,����һ������,���Ա�ĳ���L����Ϊ
	 * n+1,��������ѵ���������ÿ���������ݶ�Ҫ����ƶ�
	 * @return
	 */
	public int Insert(SLType SL,int n,DATA data){
		int i;
		if(SL.ListLen>=MAXLEN){                                //�ж�˳����Ƿ�����
			System.out.println("˳������������ܲ����㣡\n");
			return 0;
		}
		if(n<1||n>SL.ListLen-1){                               //�жϲ�������Ƿ���ȷ
			System.out.println("����Ԫ����Ŵ��󣬲��ܲ���Ԫ�أ�\n");
			return 0;
		}	  
		for (int j = SL.ListLen; j>n; j--) {                     //��˳����е���������ƶ�
			SL.ListData[j+1]=SL.ListData[j];
		}
		SL.ListData[n]=data;                                    //����λ��
		SL.ListLen++;
		return 1;                                               //�ɹ�����,����1
	}
	
	/**
	 * ����Ԫ�ص�˳���β��
	 * @param SL
	 * @param data
	 * @return
	 */
	public int SLAdd(SLType SL,DATA data){
		
		if(SL.ListLen >= MAXLEN){                               //�ж��Ƿ�����
			System.out.println("˳�������,��������ӽ����");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}
	/**
	 * ɾ��˳����е�����Ԫ��
	 * ˳���ɾ����i�����,��ô֮������н���λ�ö���Ҫ��ǰ�ƶ�һ��λ��
	 * @return
	 */
	public int SLDeleteType(SLType SL,int n){
		int i;
		if(n<1||n>SL.ListLen-1){                               //�жϲ�������Ƿ���ȷ
			System.out.println("ɾ��Ԫ�ط��Ŵ���\n");
			return 0;
		}
		
		for (i = n; i < SL.ListLen; i++) {                    //˳����е�Ԫ����ǰ�ƶ�
			SL.ListData[n+1] = SL.ListData[n];
		}
		
		SL.ListLen--;                                        //˳����Ԫ��������һ
		return 1;
	}
	/**
	 * ������Ų��ҽ��
	 * @return
	 */
	public DATA SLFindByNum(SLType SL,int n){                 //������ŷ�������Ԫ��
		if(n<1||n>SL.ListLen-1){
			System.out.println("���ҷ��Ŵ���\n");
			return null;
		}
		return SL.ListData[n];
	}
	/**
	 * ���չؼ��ֲ��ҽ��  ���ؽ�����
	 * @return
	 */
	public int SLFindByCout(SLType SL,String key){           //���չؼ��ֲ���Ԫ��
		int j;
		for (j = 1; j < SL.ListLen; j++) {
			if(SL.ListData[j].key.compareTo(key)==0){
				return j;
			}
		}
		return 0;
	}
	/**
	 * �������н��
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
