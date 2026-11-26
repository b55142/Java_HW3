// 依 Chapter5.pdf P50 重寫：實作 Runnable。
public class Sample6_6 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("一號車");
        Thread th1 = new Thread(car1);
        th1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("正在進行main()的處理工作");
        }
    }
}

class Car implements Runnable {
    private final String name;
    public Car(String nm) { name = nm; }
    @Override public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("正在進行" + name + "的處理工作");
        }
    }
}
