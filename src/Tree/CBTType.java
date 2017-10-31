package Tree;

import java.util.Scanner;

/**
 * 定义二叉树结点类型
 */
public class CBTType {
    String data;                  //二叉树结点数据，我们这里就设置为字符串
    CBTType left;                 //左子树结点引用
    CBTType right;                //右子树结点引用

    static final int MAXLEN = 50;
    static Scanner input =  new Scanner(System.in);

    /**
     * 初始化一个二叉树
     * @return
     */
    public static CBTType InitTree(){
        CBTType node;
        if((node=new CBTType())!=null){                     //申请内存
            System.out.printf("请先定义根结点数据：\n");
            node.data = input.next();
            node.left = null;
            node.right = null;
            if (node!=null)
                return node;
            else
                return null;
        }
        return node;
    }

    /***
     * 查找结点
     * @param treeNode 二叉树
     * @param data     查找的结点
     * @return
     */
    public static CBTType TreeFindNode(CBTType treeNode,String data){
        CBTType ptr = null;
        if(treeNode ==null){
            return null;
        }
        if(treeNode.data.equals(data)){       //判断当前结点是不是
            return treeNode;
        }else {
            if((ptr=TreeFindNode(treeNode.left,data))!=null){      //递归查找左子树里面有没有符合的
                return ptr;
            }else if((ptr=TreeFindNode(treeNode.right,data))!=null){ //递归查找右子树里面有没有符合的
                return ptr;
            }else{
                return null;
            }
        }
    }

    /**
     * 添加结点
     * @param treeNode
     */
    public static void AddTreeNode(CBTType treeNode){
        CBTType pnode,parent;
        String data = null;
        int menusel = 0;
        if((pnode=new CBTType())!=null){                     //申请内存
            System.out.printf("请输入二叉树结点数据：\n");
            pnode.data = input.next();
            pnode.left = null;
            pnode.right = null;


            System.out.printf("请输入父结点数据：\n");

            data = input.next();
            parent = TreeFindNode(treeNode,data);                      //查找制定数据的结点
            if (parent ==null){                               //如果没有找到
                System.out.printf("未找到该父结点：\n");
                pnode = null;                                 //释放内存
                return ;
            }
            System.out.printf("1.添加该结点到左子树 2.添加该结点到右子树 \n");
            do {
                menusel = input.nextInt();                    //输入选择项，是添加左子树还是右子树

                if(menusel==1||menusel==2){
                    if (parent ==null){
                        System.out.printf("未找到该父结点,请先设置父节点 \n");
                    }else{
                        switch (menusel){
                            case 1:
                                if (parent.left!=null){             //添加到左子树
                                    System.out.printf("左子树不为空 \n");
                                }else {
                                    parent.left = pnode;
                                }
                                break;
                            case 2:
                                if(parent.right!=null){              //添加到右子树
                                    System.out.printf("右子树不为空 \n");
                                }else {
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.printf("无效参数 \n");
                        }
                    }
                }
            }while (menusel!=1 && menusel!=2);
        }
    }



    /**
     * 获取右子树
     * @param treeNode
     * @return
     */
    public static CBTType TreeRightNode(CBTType treeNode){
        if(treeNode!=null){
            return treeNode.right;
        }
        return null;
    }

    /**
     * 获取左子树
     * @return
     */
    public static CBTType TreeLeftNode(CBTType treeNode){
        if(treeNode!=null){
            return treeNode.left;
        }
        return null;
    }

    /**
     * 判断是否为空树
     * @param treeNode
     * @return
     */
    public static boolean TreeIsEmpty(CBTType treeNode){
        if(treeNode==null){
            return true;
        }
        return false;
    }

    /**
     * 计算二叉树的深度，也就是计算二叉树中结点的最大层数
     * @param treeNode
     * @return
     */
    public static int TreeDepth(CBTType treeNode){
        int depthLeft,depthRight = 0;
        if (treeNode ==null){
            return 0;
        }
        depthLeft = TreeDepth(treeNode.left);
        depthRight = TreeDepth(treeNode.right);
        if(depthLeft>depthRight){
            return depthLeft+1;
        }else {
            return depthRight+1;
        }
    }

    /**
     * 清空二叉树
     * @param treeNode
     */
    public static void ClearTree(CBTType treeNode){
        if(treeNode!=null){
            ClearTree(treeNode.left);
            ClearTree(treeNode.right);
            treeNode = null;
        }
    }

    /**
     * 显示当前结点数据
     * @param treeNode
     */
    public static String TreeNodeData(CBTType treeNode){
        if(treeNode!=null){
            System.out.printf("%s \n",treeNode.data);
            return treeNode.data;
        }
        return "";
    }

    //----------------------------------------------遍历二叉树---------------------------------------------

    /**
     * 按层遍历
     * @param treeNode
     */
    public static void LevelTree(CBTType treeNode){
        CBTType p;
        CBTType [] q = new CBTType[MAXLEN];
        int head = 0;
        int tail = 0;
        if(treeNode!=null){
            tail = (tail+1)%MAXLEN;
            q[tail] = treeNode;
        }
        while (head!=tail){
            head = (head+1)%MAXLEN;
            p = q[head];
            TreeNodeData(p);
            if(p.left!=null){
                tail = (tail+1)%MAXLEN;
                q[tail] = p.left;
            }
            if(p.right!=null){
                tail = (tail+1)%MAXLEN;
                q[tail]  =p.right;
            }
        }
    }

    /**
     * 先序遍历  D-->L--R
     * @param treeNode
     */
    public static void DLRTree(CBTType treeNode){
        if(treeNode!=null){
            TreeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public static void LDRTree(CBTType treeNode){
        if(treeNode!=null){
            LDRTree(treeNode.left);
            TreeNodeData(treeNode);
            LDRTree(treeNode.right);
        }
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void LRDTree(CBTType treeNode){
        if(treeNode!=null){
            LRDTree(treeNode.left);
            LRDTree(treeNode.right);
            TreeNodeData(treeNode);
        }
    }
}
