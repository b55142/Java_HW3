// 依 Chapter5.pdf P34 重寫：從標準輸入讀取一行文字。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample5_6 {
    public static void main(String[] args) {
        System.out.println("請輸入字串");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            String str = br.readLine();
            System.out.println("已輸入字串" + str);
        } catch (IOException e) {
            System.out.println("輸入輸出有誤");
        }
    }
}
