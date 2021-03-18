import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:Main
 * Package:edu.neu.bg
 * Description:使用Gossiping协议实现去中心化的平均数算法
 *
 * @Date:2019/10/19 15:30
 * @Author:HetFrame
 */
public class Main {
    //写文件
    private static void write(String url, String string, boolean flag) {// 文件路径 传入list 是否续写
        FileWriter fw = null;
        BufferedWriter bufw = null;
        try {
            fw = new FileWriter(url, flag);
            bufw = new BufferedWriter(fw);
            bufw.write(string);
            bufw.newLine();
            bufw.flush();
            bufw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testNodeNumber(int number, String url) {//节点数量 结果文件名
        int count = 0;//执行轮数
        double mean = 0;//实际平均数
        Map<Integer, Node> map = new HashMap();
        //添加节点
        for (int i = 1; i <= number; i++) {
            map.put(i, new Node(i));
        }
        for (Node n : map.values()) {
            n.setMap(map);
            mean += n.getValue();
        }
        mean /= map.size();
        int num = 0;
        //开始一轮一轮的更新
        while (num < map.size()) {
            count++;
            num = 0;
            for (Node node : map.values()) {
                node.update();
                if (node.getStatus() == 2) {
                    num++;
                }
            }
        }
//        //打印较耗时---------------------------------------------------
//        for (Node node : map.values()
//        ) {
//            System.out.println(node);
//        }
        //并将数据写入指定文本
        write(url, number + "," + Math.abs(map.get(1).getValue() - mean) + "," + count + "," + map.get(1).getK(), true);
    }

    private static void testKNumber(int number, int k, String url) {//节点数量 结果文件名
        int count = 0;//执行轮数
        double mean = 0;//实际平均数
        Map<Integer, Node> map = new HashMap();
        //添加节点
        for (int i = 1; i <= number; i++) {
            map.put(i, new Node(i));
        }
        for (Node n : map.values()) {
            n.setMap(map);
            mean += n.getValue();
        }
        mean /= map.size();
        int num = 0;
        //开始一轮一轮的更新
        while (num < map.size()) {
            count++;
            num = 0;
            for (Node node : map.values()) {
                node.update();
                if (node.getStatus() == 2) {
                    num++;
                }
            }
        }
        write(url, number + "," + Math.abs(map.get(1).getValue() - mean) + "," + count + "," + k, true);
    }

    public static void main(String[] args) {
        //节点数量为自变量
        for (int n = 0; n < 3; n++) {//每组数据做三次实验避免偶然性
            //进行节点数从10到100的实验
            for (int i = 10; i <= 100; i += 10) {
                testNodeNumber(i, "result.txt");
            }
            //节点数从200到10000
            for (int i = 200; i <= 10000; i += 100) {
                testNodeNumber(i, "result.txt");
                System.out.println(i);
            }
            //节点数从10000到100000
            for (int i = 10000; i <= 100000; i+=10000) {
                testNodeNumber(i, "result.txt");
                System.out.println(i);
            }
        }
        // k值为自变量
        for (int n = 0; n < 10; n++) {
            for (int i = 2; i <= 1002; i+=10) {//每组数据做十次实验避免偶然性
                testKNumber(100, i, "result1.txt");
                System.out.println(i);
            }
        }

//        //额外的实验  节点数从10000到100000
//        for (int i = 10000; i <= 100000; i+=10000) {
//            testNodeNumber(i, "test.txt");
//            System.out.println(i);
//        }
    }
}
