// 依 Chapter3.pdf P26 重寫：無參數建構式。
public class Sample3_12 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        car1.show();
    }
}

class Car {
    private int num;
    private double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("生產了車子");
    }

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}
