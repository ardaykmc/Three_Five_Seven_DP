package repository;

import android.graphics.drawable.Drawable;
import android.R;
public enum Flags {
    SPANISH ("SPAIN", "@assets/spanish"),
    FRENCH ("FRENCH", "@assets/french"),
    ITALY ("ITALY", "@assets/italy"),
    SWEDEN ("SWEDEN", "@assets/sweden"),
    TURKEY("TURKEY","@assets/turkey"),
    UK("UK","@assets/uk");
    private final String name;   // in kilograms
    private final String  path;

    Flags(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

}
