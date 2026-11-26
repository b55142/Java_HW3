// 依 Chapter3.pdf P9 重寫：物件內外的欄位存取。
public class Sample3_4 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        car1.num = 1234;
        car1.gas = 20.5;
        // 此頁未呼叫 show()；執行時沒有主控台輸出。
    }
}

class Car {
    int num;
    double gas;

    void show() {
        System.out.println("車號是" + this.num);
        System.out.println("汽油量是" + this.gas);
    }
}
