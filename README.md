# Java Homework 3

CH3、CH4、CH5 指定頁碼的 Java 程式，以及三個標準類別庫範例。

- CH3：類別、物件、封裝、多載、建構式與字串，共 26 個範例。
- CH4：繼承、覆寫、多型、抽象類別與介面，共 13 個範例。
- CH5：套件、例外、檔案、執行緒與同步，共 22 個範例。
- 延伸：成績統計（java.util）、文字檔統計（java.io）、網址解析（java.net）。

共 64 個獨立範例、68 個 Java 原始檔。每個範例分開編譯，避免同名類別互相影響。

## 程式位置

| 內容 | 資料夾 |
| --- | --- |
| CH3 封裝示範 | `examples/ch3-p22/src/Sample3_10.java` |
| CH4 抽象類別與多型 | `examples/ch4-p29/src/Sample4_10.java` |
| CH5 執行緒同步 | `examples/ch5-p55/src/Sample6_8.java` |
| 三個類別庫範例 | `examples/extra-grade`、`extra-file`、`extra-url` |
| 全部指定頁碼 | [指定頁碼對照表](指定頁碼對照表.md) |

## 執行方式（Windows）

需安裝 JDK；也可以使用 Android Studio 內建 JDK。於此資料夾執行：

```bat
run-example.cmd ch3-p22
run-example.cmd ch4-p29
run-example.cmd ch5-p55
run-example.cmd extra-grade 80 95 70 60
run-example.cmd extra-file
run-example.cmd extra-url
```

PowerShell 中請在指令前加上 `.\`，例如 `.\run-example.cmd ch3-p22`。
檔案範例使用 `runtime` 資料夾；需要標準輸入的程式會等待鍵盤輸入。

## Gradle

```bat
gradlew.bat compileAllExamples --console=plain
gradlew.bat :ch4-p29:run --console=plain
```

## 驗證與注意事項

64 個範例已獨立編譯與執行，另通過 9 項錯誤情況與檔案檢查。
使用 JDK 25.0.4 執行，並以 `--release 8` 檢查 Java 8 API 相容性。
CH5 P19、P32 刻意拋出未捕捉例外；P52 保留未同步的競爭條件；P55 使用同步化保護加總。
CH3 P16 為依 return 語法補寫的可執行示範。

程式重寫、技術說明與驗證整理使用 ChatGPT 協助。
