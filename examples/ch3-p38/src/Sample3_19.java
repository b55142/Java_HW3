// 依 Chapter3.pdf P38 重寫：String 搜尋字元。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample3_19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("請輸入字串");
        String str1 = br.readLine();
        System.out.println("請輸入要檢索的文字");
        String str2 = br.readLine();
        if (str2 == null || str2.isEmpty()) {
            System.out.println("請至少輸入一個字元");
            return;
        }
        char ch = str2.charAt(0);
        int num = str1.indexOf(ch);
        if (num != -1) System.out.println(str1 + "的第" + (num + 1) + "個字就是「" + ch + "」");
        else System.out.println(str1 + "中沒有「" + ch + "」這個字");
    }
}
