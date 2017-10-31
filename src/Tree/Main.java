package Tree;

/**
 * 测试二叉树
 */
public class Main {
    public static void main(String [] args){
        CBTType root = null ;                //二叉树的根节点
        root = CBTType.InitTree();           //初始化一个二叉树
        int menusel = 0;
        //添加
        do{
            System.out.printf("请选择菜单添加二叉树的结点 \n");
            System.out.printf("0.退出 \n");
            System.out.printf("1.添加二叉树的结点 \n");
            menusel = CBTType.input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    CBTType.AddTreeNode(root);
                    break;
                default:

            }
        }while (menusel!=0);

        //遍历
        do{
            System.out.printf("请选择菜单遍历二叉树的结点，输入0表示退出 \n");
            System.out.printf("1.先序遍历DLR \n");
            System.out.printf("2.中序遍历LDR \n");
            System.out.printf("3.后续遍历LRD \n");
            System.out.printf("4.按层遍历 \n");
            menusel = CBTType.input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    System.out.printf("先序遍历DLR的结果\n");
                    CBTType.DLRTree(root);
                    break;
                case 2:
                    System.out.printf("中序遍历LDR的结果\n");
                    CBTType.LDRTree(root);
                    break;
                case 3:
                    System.out.printf("后续遍历LRD的结果\n");
                    CBTType.LRDTree(root);
                    break;
                case 4:
                    System.out.printf("按层遍历的结果\n");
                    CBTType.LevelTree(root);
                    break;
            }
        }while (menusel!=0);

        //二叉树的深度
        System.out.printf("二叉树的深度 %d \n",CBTType.TreeDepth(root));
        root = null;
    }
}
