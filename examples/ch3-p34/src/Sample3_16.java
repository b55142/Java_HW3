// 依 Chapter3.pdf P34 重寫：使用標準類別庫讀取整數。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample3_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("請輸入一個整數");
        String str = br.readLine();
        int num = Integer.parseInt(str);
        System.out.println("您輸入的數字是：" + num);
    }
}
