// 依 Chapter3.pdf P15 重寫：傳入兩個引數。
public class Sample3_7 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        int number = 1234;
        double gasoline = 20.5;
        car1.setNumGas(number, gasoline);
    }
}

class Car {
    int num;
    double gas;

    public void setNumGas(int n, double g) {
        num = n;
        gas = g;
        System.out.println("將車號設為" + num + "，汽油量設為" + gas);
    }

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}
