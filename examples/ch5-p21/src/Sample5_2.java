// 依 Chapter5.pdf P21 重寫：使用 try-catch 處理例外。
public class Sample5_2 {
    public static void main(String[] args) throws Exception {
        try {
            int[] test = new int[5];
            System.out.println("將值指定給test[10]");
            test[10] = 80; // 刻意超出 0..4 範圍：教學用的錯誤。
            System.out.println("將80指定給test[10]");
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("超過陣列的範圍了");
        }
        System.out.println("順利地執行完畢了");
    }
}
