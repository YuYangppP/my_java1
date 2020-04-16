package shiyan.three;

import java.io.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName AnalysisResult.java
 * @Description TODO
 * @Date 2019/10/28 12:16
 */
public class AnalysisResult {
    public static void main(String[] args) {

        File fRead = new File("D:\\my_java\\practice1\\test1\\src\\score.txt");
        File fWrite = new File("D:\\my_java\\practice1\\test1\\src\\scoreAnalysis.txt");
        try {
            Writer out = new FileWriter(fWrite, true);
            BufferedWriter bufferedWriter = new BufferedWriter(out);
            Reader in = new FileReader(fRead);
            BufferedReader bufferedReader = new BufferedReader(in);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                double totalScore = Fenxi.getTotalScore(str);
                str = str + "总分：" + totalScore;
                System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
