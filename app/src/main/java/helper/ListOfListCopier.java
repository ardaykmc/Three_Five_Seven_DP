package helper;

import java.util.ArrayList;
import java.util.List;

import game.ICopyConstructor;

public class ListOfListCopier<T extends ICopyConstructor<T>> {
    private List<List<T>> copyList;
    public ListOfListCopier(){
        copyList = new ArrayList<>();
    }
    public List<List<T>> getCopyList(List<List<T>> givenList){
        for(int i = 0; i < givenList.size() ; i++){
            int size = givenList.get(i).size();
            for(int j = 0 ; j < size ; j++){
                List<T> lst = copyList.get(i);
                if (givenList.get(i).get(j) == null){
                    lst.add(null);
                }else{
                    T realValue = givenList.get(i).get(j);
                    T copy = realValue.copyConstructor(realValue);
                    lst.add(copy);
                }
            }
        }
        return this.copyList;
    }
}
