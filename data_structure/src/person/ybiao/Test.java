package person.ybiao;

/**
 * ClassName:person.ybiao.Test
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2020/5/17 14:58
 * @Author:HetFrame
 */

final class A {
    boolean isA;
    char b;
    byte c;
    short d;
    int e;
    long f;
    float g;
    double h;

    @Override
    public String toString() {
        return "person.ybiao.A{" +
                "a=" + isA +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                '}';
    }
}

abstract class BaseB {
    static final int MAX = 0;
    static final int MAX_1 = 1;

    //抽象类可以拥有非抽象方法
    protected abstract void f();

    public void b() {
        System.out.println("抽象类的普通方法");
    }
}

class C extends BaseB {
    @Override
    public void f() {
        super.b();
    }

    void f(int a) {
        BaseB baseB = new BaseB() {
            @Override
            public void f() {
                System.out.println("覆写抽象方法");
            }
        };
        baseB.f();
    }
}

interface IVehicle {
    int WHEELS_NUM = 0;

    void play();

    default void stop() {
        System.out.println("车辆停止");
    }
}

interface IVehicle1 {
    void play();

    default void stop() {
        System.out.println("车辆1停止");
    }
}

class Car implements IVehicle, IVehicle1 {
    @Override
    public void play() {
        System.out.println("play");
    }

    @Override
    public void stop() {
        IVehicle.super.stop();
        IVehicle1.super.stop();
    }
}

interface ITool {
    int A = 0;

    void execute();

    static void useTool(ITool... tools) {
        for (ITool tool : tools) {
            tool.execute();
        }
    }
}

class ATool implements ITool {
    @Override
    public void execute() {
        System.out.println("person.ybiao.ATool execute()");
    }
}

class BTool implements ITool {
    @Override
    public void execute() {
        System.out.println("person.ybiao.BTool execute()");
    }
}

class CTool implements ITool {
    @Override
    public void execute() {
        System.out.println("person.ybiao.CTool execute()");
    }
}

public class Test {
    public static void main(String[] args) {
        ITool.useTool(new ATool(), new BTool(), new CTool());
    }
}
