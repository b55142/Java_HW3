// 依 Chapter3.pdf P12 重寫：在方法內呼叫另一個方法。
public class Sample3_5 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        car1.num = 1234;
        car1.gas = 20.5;
        car1.showCar();
    }
}

class Car {
    int num;
    double gas;

    void showCar() {
        System.out.println("開始顯示車子資料");
        this.show();
    }

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}
