// 依 Chapter3.pdf P20 重寫：未封裝的錯誤資料示範。
public class Sample3_9 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        car1.num = 1234;
        car1.gas = -10;
        car1.show();
    }
}

class Car {
    int num;
    double gas;

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}
