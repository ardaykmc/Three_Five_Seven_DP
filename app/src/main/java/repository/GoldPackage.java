package repository;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.security.PublicKey;
@Entity
public class GoldPackage {
    @Embedded private Gold gold;

    public int getPackage_ID() {
        return package_ID;
    }

    public void setPackage_ID(int package_ID) {
        this.package_ID = package_ID;
    }

    @PrimaryKey private int package_ID;



    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        double numberOfGold = this.gold.getNumberOfGold();
        double added = gold.getNumberOfGold();
        this.gold.setNumberOfGold(numberOfGold + added);
    }

    /**
     *
     * @param golden has to be initialized with piece of golden
     */
    public  GoldPackage(Gold golden){
        this.gold = golden ;
    }
    public GoldPackage(){}
}
