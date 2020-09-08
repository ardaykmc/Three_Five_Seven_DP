package animation;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import androidx.annotation.RequiresApi;

public class AnimationProvider {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void animatedCurvesObject(View view, float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo, int repeatMode, int repeatCount, int duration){
        Path path = new Path();
        path.arcTo(left,top,right,bottom,startAngle,sweepAngle,forceMoveTo);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,View.X,View.Y,path);
        animator.setDuration(duration);
        animator.setRepeatMode(repeatMode);
        animator.setRepeatCount(repeatCount);
        animator.start();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void rectangularMove(View view, Path path,float left, float top, float right,float bottom,float rx, float ry, Path.Direction direction,int duration) {
        path.addRoundRect(left, top, right, bottom, rx, ry, direction);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, view.X, view.Y, path);
        animator.setDuration(duration);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();
    }

    public static void rotatingViews(View view,float pivotX, float pivotY){


        // Create an animation instance
        RotateAnimation an = new RotateAnimation(0.0f, 360.0f, pivotX, pivotY);

        // Set the animation's parameters
        // reverses each repeat
        an.setFillAfter(true);               // keep rotation after animation
        an.setDuration(4000);
        an.setRepeatMode(Animation.RESTART);
        an.setRepeatCount(ObjectAnimator.INFINITE);
        // Aply animation to image view
        view.setAnimation(an);
    }
}
