// 依 Chapter5.pdf P19 重寫：未捕捉的陣列越界例外。
public class Sample5_1 {
    public static void main(String[] args) throws Exception {
        int[] test = new int[5];
        System.out.println("將值指定給test[10]");
        test[10] = 80; // 刻意超出 0..4 範圍：教學用的錯誤。
        System.out.println("將80指定給test[10]");

        System.out.println("順利地執行完畢");
    }
}
