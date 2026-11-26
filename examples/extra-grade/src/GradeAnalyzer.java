import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** 範例一：java.util 類別，計算成績統計並列出排名。 */
public class GradeAnalyzer {
    public static void main(String[] args) {
        String[] inputs = args;
        if (inputs.length == 0) {
            System.out.println("請輸入成績，以空白分隔，例如：80 95 70 60");
            Scanner scanner = new Scanner(System.in, "UTF-8");
            if (!scanner.hasNextLine()) {
                System.err.println("沒有輸入成績。");
                System.exit(2);
            }
            inputs = scanner.nextLine().trim().split("\\s+");
        }

        List<Double> grades = new ArrayList<Double>();
        DoubleSummaryStatistics statistics = new DoubleSummaryStatistics();
        int passed = 0;
        for (String input : inputs) {
            try {
                double grade = Double.parseDouble(input);
                // NaN 與 Infinity 雖可被 parseDouble 解析，但不是有效成績。
                if (!Double.isFinite(grade) || grade < 0 || grade > 100) {
                    throw new IllegalArgumentException();
                }
                grades.add(grade);
                statistics.accept(grade);
                if (grade >= 60) passed++;
            } catch (IllegalArgumentException error) {
                System.err.println("略過無效成績：" + input);
            }
        }
        if (grades.isEmpty()) {
            System.err.println("至少需要一筆 0 到 100 的有效成績。");
            System.exit(2);
            return;
        }

        // 複製後排序，保留原本的輸入順序。
        List<Double> ranking = new ArrayList<Double>(grades);
        Collections.sort(ranking, Collections.reverseOrder());
        System.out.println("有效人數：" + statistics.getCount());
        System.out.printf(Locale.ROOT, "平均：%.2f%n", statistics.getAverage());
        System.out.printf(Locale.ROOT, "最高：%.2f%n", statistics.getMax());
        System.out.printf(Locale.ROOT, "最低：%.2f%n", statistics.getMin());
        System.out.printf(Locale.ROOT, "及格率：%.2f%%%n", passed * 100.0 / grades.size());
        System.out.println("原始順序：" + grades);
        System.out.println("由高到低：" + ranking);
    }
}
