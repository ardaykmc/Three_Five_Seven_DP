package animation;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

public class AnimationProvider {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void circularAnimation(View view, float radius, float xPosition, float yPosition){
        Path path = new Path();
        path.addCircle(xPosition,yPosition,radius,Path.Direction.CW);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,view.X,view.Y,path);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setDuration(5000);
        animator.start();
    }
}
