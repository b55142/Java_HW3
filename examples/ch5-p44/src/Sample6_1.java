// 依 Chapter5.pdf P44 重寫：延伸 Thread 類別啟動執行緒。
public class Sample6_1 {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("1號車");
        car1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("正在進行main()的處理工作");
        }
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
