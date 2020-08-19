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
        for (List<Integer> lst : this.lists){
            List<Box> boxes = new ArrayList<>();
            for (Integer i : lst){
                if (i == 0 ){
                    boxes.add(null);
                }else{
                    Box box = new Box(20);
                    boxes.add(box);
                }
            }
            boxList.add(boxes);
        }
        return boxList;
    }

    public List<List<Box>> getLayoutList() {
        return layoutList;
    }
}
