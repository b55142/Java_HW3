// 依 Chapter3.pdf P16 重寫：return 回傳值語法的可執行補充。
public class ReturnValueDemo {
    public static void main(String[] args) {
        ReturnValueDemo demo = new ReturnValueDemo();
        System.out.println("傳回值是" + demo.doubleValue(21));
    }
    int doubleValue(int value) {
        return value * 2;
    }
}
