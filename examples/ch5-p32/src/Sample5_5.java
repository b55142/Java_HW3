// 依 Chapter5.pdf P30, P32 重寫：以 throws 向外傳遞例外。
public class Sample5_5 {
    public static void main(String[] args) throws CarException {
        Car car1 = new Car();
        car1.setCar(1234, -10.0);
        car1.show(); // 發生例外後不會執行。
    }
}
class Car {
    private int num;
    private double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("已生產了汽車");
    }

    public void setCar(int n, double g) throws CarException {
        if (g < 0) {
            throw new CarException();
        } else {
            num = n;
            gas = g;
            System.out.println("將車號設為" + num + "，汽油量設為" + gas);
        }
    }

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}

class CarException extends Exception {
    private static final long serialVersionUID = 1L;
}
