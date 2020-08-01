package repository;

import androidx.room.Entity;

@Entity
public class Gold implements IGold{
    private Double numberOfGold;

    @Override
    public Double getNumberOfGold() {
        return numberOfGold;
    }

    @Override
    public void setNumberOfGold(Double number) {
        numberOfGold = numberOfGold + number ;
    }
    public Gold(){
        this.numberOfGold = 0.0; //initially 0
    }
    public Gold(Gold golden){
        this.numberOfGold = golden.getNumberOfGold();
    }
}
