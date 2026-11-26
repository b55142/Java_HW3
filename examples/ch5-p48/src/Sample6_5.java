// 依 Chapter5.pdf P48 重寫：使用 join 等待執行緒。
public class Sample6_5 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("1號車");
        car1.start();
        try {
            car1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("結束main()的處理工作。");
    }
}

class Car extends Thread {
    private final String name;
    public Car(String nm) { name = nm; }
    @Override public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("正在進行" + name + "的處理工作");
        }
    }
}
