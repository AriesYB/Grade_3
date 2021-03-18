import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * ClassName:Node
 * Package:PACKAGE_NAME
 * Description:通信节点
 *
 * @Date:2019/10/19 15:32
 * @Author:HetFrame
 */
public class Node {
    private int id;
    private int status;//节点状态 0未感染 1感染 2已隔离
    private double value;//节点数值
    private double interest;//节点联络其他节点的概率
    private final double error;//最小误差
    private int k;
    private Map<Integer, Node> map;//周围节点的映射

    public Node(int id) {
        this.id = id;
        status = 1;
        value = (int) (Math.random() * 100);
        interest = 1;
        error = 0.0001;
        k = 2;
    }

    public void update() {
//        //未感染状态下不执行
//        if (status == 0) {
//            return;
//        }
        if (interest > Math.random()) {
            //随机获取一个节点进行联络
            Random rand = new Random();
            int i = rand.nextInt(map.size()) + 1;
            while (i == id) {//避免和自己联络
                i = rand.nextInt(map.size()) + 1;
            }
            contact(map.get(i));
        }
    }

    //联络其他节点
    public void contact(Node n) {
//        System.out.println(this + "--" + n);
        //小于最小误差时认为值相同,将减少兴趣
        if (Math.abs(value - n.getValue()) < error) {
            reduceInterest();
        } else {
            double mean = (value + n.getValue()) / 2;
            value = mean;
            n.setValue(mean);
        }
    }

    //减少兴趣值
    public void reduceInterest() {
        interest = interest / k;
        //兴趣值小于一定数值时认为没有兴趣
        if (interest < 0.001) {
            interest = 0;
            setStatus(2);
        }
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public double getInterest() {
        return interest;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public double getValue() {
        return value;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setMap(Map<Integer, Node> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", value=" + value +
                ", interest=" + interest +
                '}';
    }
}
