// 依 Chapter3.pdf P14 重寫：傳入單一引數。
public class Sample3_6 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        car1.setNum(1234);
        car1.setGas(20.5);
    }
}

class Car {
    int num;
    double gas;

    void setNum(int n) {
        num = n;
        System.out.println("將車號設為" + num);
    }
    void setGas(double g) {
        gas = g;
        System.out.println("將汽油量設為" + gas);
    }
}
