package UIElementCreator;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.widget.ImageView;
import android.R;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

import java.io.IOException;
import java.io.InputStream;

public class ImageViewFlagCreator {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static void createImageViewFlags(Context context, String path) throws IOException {
        ImageView imageView = new ImageView(context);
        imageView.setLeftTopRightBottom(50,50,0,0);
        Resources res = context.getResources();
    }

}
