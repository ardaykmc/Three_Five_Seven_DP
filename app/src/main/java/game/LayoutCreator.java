package game;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import helper.BoardReader;

public class LayoutCreator {
    private BoardReader boardReader;
    private List<String> linesList;

    public LayoutCreator(String mapPath, Context context) throws IOException {
        boardReader = new BoardReader(mapPath,context);
        linesList = boardReader.read();
    }

    public List<List> separate(){
        List<List> integerList = new ArrayList<>();
        String line = "" ;
        for (int i = 0; i < this.linesList.size(); i++) {
            line = this.linesList.get(i);
            StringTokenizer stringTokenizer = new StringTokenizer(line," ");
            List<Integer> lst = new ArrayList<>();
            while(stringTokenizer.hasMoreTokens()){
                lst.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            integerList.add(lst);
        }
        return integerList;
    }
}
