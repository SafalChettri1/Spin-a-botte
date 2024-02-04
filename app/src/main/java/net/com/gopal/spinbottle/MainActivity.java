package net.com.gopal.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;

    private Random random = new Random();
    private int lastdir;
    private boolean spinning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);

    }
    public void spinBottle(View v){
        if (!spinning) {


            int newDir = random.nextInt(500);
            float pivotx = bottle.getWidth() / 2;
            float pivoty = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastdir, lastdir - 20000, pivotx, pivoty);
            rotate.setDuration(2000);


            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                    lastdir = (lastdir - 20000)%360;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    spinning=true;

                }
            });

            lastdir = newDir;
            bottle.startAnimation(rotate);
        }
    }
}