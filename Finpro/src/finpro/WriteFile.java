/*
FINAL PROJECT KELOMPOK 1: SOCCER AGENDA
Christoper Luis Alexander - 2301876493
Jonathan Evan Sampurna - 2301876612
Christiano Ekasakti Sangalang - 2301927872
 */
package finpro;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFile {
    private String path;
    private boolean append_to_file = false;
    
    public WriteFile(String file_path) {
        path = file_path;
    }
    
    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }
    
    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);
        
        print_line.printf("%s" + "%n", textLine);
        print_line.close();
    }

}
