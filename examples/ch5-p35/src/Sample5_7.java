// 依 Chapter5.pdf P35 重寫：用 BufferedWriter 與 PrintWriter 寫檔。
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Sample5_7 {
    public static void main(String[] args) {
        // 寫入 runtime/test1.txt；此練習會覆寫該檔案。
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test1.txt")))) {
            pw.println("Hello!");
            pw.println("GoodBye!");
            // PrintWriter 會保留寫入錯誤狀態，主動檢查才不會誤報成功。
            if (pw.checkError()) throw new IOException("寫入失敗");
            System.out.println("資料已經寫入檔案了");
        } catch (IOException e) {
            System.out.println("輸出入有錯誤");
        }
    }
}
