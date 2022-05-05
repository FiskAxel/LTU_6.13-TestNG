import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestReport extends TestingCaesar {

    public static void writeTestStatusLine(String name, String status) throws IOException {
        File file = new File("Testreport.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.write(String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        fw.write(" Test: " + name + " Status: " + status + "\n");
        fw.close();
    }

    public static void writeTestStartLine(String str) throws IOException{
        File file = new File("TestReport.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.write(str + String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))) + "\n");
        fw.close();
    }

    public static void writeBlankLine() throws IOException {
        File file = new File("Testreport.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.write("\n");
        fw.close();
    }
}
