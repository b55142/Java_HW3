// 依 Chapter3.pdf P37 重寫：String 大小寫轉換。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample3_18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("請輸入英文字母");
        String str = br.readLine();
        String stru = str.toUpperCase(java.util.Locale.ROOT);
        String strl = str.toLowerCase(java.util.Locale.ROOT);
        System.out.println("轉換成大寫時為" + stru);
        System.out.println("轉換成小寫時為" + strl);
    }
}
