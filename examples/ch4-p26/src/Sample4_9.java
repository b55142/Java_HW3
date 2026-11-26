// 依 Chapter4.pdf P26, P27 重寫：getClass 取得實際類別。
public class Sample4_9 {
    public static void main(String[] args) throws Exception {
        Car[] cars = new Car[2];
        cars[0] = new Car();
        cars[1] = new RacingCar();
        for (int i = 0; i < cars.length; i++) {
            Class<?> cl = cars[i].getClass();
            System.out.println("第" + (i + 1) + "個物件的類別是" + cl);
        }
    }
}

class Car {
    int num;
    double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("生產了車子");
    }
}

class RacingCar extends Car {
    public RacingCar() { System.out.println("生產了賽車"); }
}
