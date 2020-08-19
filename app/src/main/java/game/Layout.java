package game;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Layout {

    private List<List> lists;
    private List<List<Box>> boxList;
    private List<List<Box>> layoutList;
    public Layout(String mapPath, Context context) throws IOException {
        lists = new LayoutCreator(mapPath,context).separate();
        boxList = new ArrayList<>();
        layoutList = fitBoxes();
    }
    private List<List<Box>> fitBoxes(){
        int raw = 0;
        for (List<Integer> lst : this.lists){
            int column = 0 ;
            List<Box> boxes = new ArrayList<>();
            for (Integer i : lst){
                if (i == 0 ){
                    boxes.add(null);
                    column ++;
                }else{
                    Box box = new Box(20,raw,column);
                    boxes.add(box);
                    column++;
                }
            }
            boxList.add(boxes);
            raw++;
        }
        return boxList;
    }

    public List<List<Box>> getLayoutList() {
        return layoutList;
    }
}
