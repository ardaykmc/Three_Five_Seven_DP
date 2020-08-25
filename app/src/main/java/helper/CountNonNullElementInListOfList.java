package helper;

import java.util.List;

public class CountNonNullElementInListOfList<E> {
    private List<List<E>> listList;

    public CountNonNullElementInListOfList(List<List<E>> listList) {
        this.listList = listList;
    }
    public int count(){
        int count = 0 ;
        for (int i = 0; i < listList.size() ; i++){
            List<E> list = listList.get(i);
            for (int j = 0; j < list.size() ; j++){
                if (list.get(j) != null){
                    count++;
                }
            }
        }
        return count;
    }
}
