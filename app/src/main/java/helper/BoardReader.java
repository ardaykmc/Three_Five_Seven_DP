package helper;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BoardReader {
    private Reader reader;
    private StringTokenizer stringTokenizer;
    private List<String> list;
    public BoardReader(String filePath, Context context) throws IOException {
        reader = new Reader(filePath,context);
        list = new ArrayList<String>();
    }

    public List<String> read() throws IOException {
        BufferedReader bufferedReader = reader.read();
        String line = " ";
        String res = "" ;
        while (line != null){
            line = bufferedReader.readLine();
            if (line != null){
                list.add(line);
            }

        }
        return this.list;
    }
}
