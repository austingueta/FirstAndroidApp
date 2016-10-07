package com.acgg.firstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class TouchListenerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_listener);

        final ImageView image = (ImageView)findViewById(R.id.imageView);
        image.setOnTouchListener(new View.OnTouchListener(){
            float initX = 0, finalX = 0, initY = 0, finalY = 0;
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();

                        TextView xy1=(TextView) findViewById(R.id.xy1);
                        xy1.setText(String.valueOf(initX)+"   "+ String.valueOf(initY));

                        return true;

                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();

                        TextView xy2=(TextView) findViewById(R.id.xy2);
                        xy2.setText(String.valueOf(finalX)+"   "+ String.valueOf(finalY));

                        actionDisplay(initX, finalX, initY, finalY);
                        return true;
                }
                return false;
            }
        });
    }

    public void actionDisplay(float initX, float finalX, float initY, float finalY){
        float diffInX, diffFiX, diffFiY, diffInY = 0;
        diffInX = (initX-finalX);
        diffFiX = (finalX-initX);
        diffInY = (initY-finalY);
        diffFiY = (finalY-initY);

        if (diffInX ==0){
            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("");

            TextView diff = (TextView)findViewById(R.id.dX);
            diff.setText("");

            TextView diff2 = (TextView)findViewById(R.id.dY);
            diff2.setText("");
        }

        else if (diffFiX ==0){
            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("");

            TextView diff = (TextView)findViewById(R.id.dX);
            diff.setText("");

            TextView diff2 = (TextView)findViewById(R.id.dY);
            diff2.setText("");
        }

        else if (diffInY ==0){
            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("");

            TextView diff = (TextView)findViewById(R.id.dX);
            diff.setText("");

            TextView diff2 = (TextView)findViewById(R.id.dY);
            diff2.setText("");
        }

        else if (diffFiY ==0){
            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("");

            TextView diff = (TextView)findViewById(R.id.dX);
            diff.setText("");

            TextView diff2 = (TextView)findViewById(R.id.dY);
            diff2.setText("");
        }

        if(initX<finalX & (initX<finalX & initY<finalY)){
            TextView difffiX = (TextView)findViewById(R.id.dX);
            String txt= Float.toString(diffFiX);
            difffiX.setText(txt);

            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("Swiped Right and Down");
        }

        else if(initX<finalX & (initX<finalX & initY>finalY)){
            TextView difffiX = (TextView)findViewById(R.id.dX);
            String txt= Float.toString(diffFiX);
            difffiX.setText(txt);
            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("Swiped Right and Up");
        }

        else if(initX>finalX & (initX>finalX & initY<finalY))
        {
            TextView diffinX = (TextView)findViewById(R.id.dX);
            String txt= Float.toString(diffInX);
            diffinX.setText(txt);

            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("Swiped Left and Down");
        }

        else if(initX>finalX & (initX>finalX & initY>finalY))
        {
            TextView diffinX = (TextView)findViewById(R.id.dX);
            String txt= Float.toString(diffInX);
            diffinX.setText(txt);

            TextView motion = (TextView)findViewById(R.id.motion);
            motion.setText("Swiped Left and Up");
        }

        if(initY<finalY){
            TextView difffiY = (TextView)findViewById(R.id.dY);
            String txt= Float.toString(diffFiY);
            difffiY.setText(txt);
        }

        else if(initY>finalY)
        {
            TextView diffinY = (TextView)findViewById(R.id.dY);
            String txt= Float.toString(diffInY);
            diffinY.setText(txt);
        }

        if (initX<finalX && initY<finalY){
            TextView qd = (TextView)findViewById(R.id.quadrant);
            qd.setText("Quadrant 4");
        }

        else if (initX>finalX && initY<finalY){
            TextView qd = (TextView)findViewById(R.id.quadrant);
            qd.setText("Quadrant 3");
        }

        else if (initX>finalX && initY>finalY){
            TextView qd = (TextView)findViewById(R.id.quadrant);
            qd.setText("Quadrant 2");
        }

        else if(initX<finalX && initY>finalY){
            TextView qd = (TextView)findViewById(R.id.quadrant);
            qd.setText("Quadrant 1");
        }

        else if(initX==finalX && initY==finalY){
            TextView qd = (TextView)findViewById(R.id.quadrant);
            qd.setText("");
        }
    }


}
