package com.stufflex.fillus;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declarations
    private TextView txt_F_white, txt_i_white, txt_l_1_white, txt_l_2_white, txt_u_white, txt_s_white,
                     txt_F_black, txt_i_black, txt_l_1_black, txt_l_2_black, txt_u_black, txt_s_black, txt_next, txt_plus;
    private Animation anim_txt_next, anim_txt_next_forward, anim_txt_plus;

    private Animator scaleDown_F, scaleUp_F, scaleDown_i, scaleUp_i, scaleDown_l_1, scaleUp_l_1,scaleDown_l_2, scaleUp_l_2, scaleDown_u, scaleUp_u, scaleDown_s, scaleUp_s,
            scaleDown_plus, scaleUp_plus;
    private AnimatorSet setDownAndUp_F, setDownAndUp_i, setDownAndUp_l_1, setDownAndUp_l_2,setDownAndUp_u, setDownAndUp_s, setDownAndUp_plus;

    private Button btn_next, btn_plus;

    private Boolean isPlusClicked, isMinusClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Disable screenshot option by using FLAG_SECURE
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        // Navbar-fullscreen
        hideNavigationBar();

        // Initializations
        txt_F_white = findViewById(R.id.txt_F_white);
        txt_i_white = findViewById(R.id.txt_i_white);
        txt_l_1_white = findViewById(R.id.txt_l_1_white);
        txt_l_2_white = findViewById(R.id.txt_l_2_white);
        txt_u_white = findViewById(R.id.txt_u_white);
        txt_s_white = findViewById(R.id.txt_s_white);
        txt_F_black = findViewById(R.id.txt_F_black);
        txt_i_black = findViewById(R.id.txt_i_black);
        txt_l_1_black = findViewById(R.id.txt_l_1_black);
        txt_l_2_black = findViewById(R.id.txt_l_2_black);
        txt_u_black = findViewById(R.id.txt_u_black);
        txt_s_black = findViewById(R.id.txt_s_black);
        txt_next = findViewById(R.id.txt_next);
        txt_plus = findViewById(R.id.txt_plus);

        btn_next = findViewById(R.id.btn_next);
        btn_plus = findViewById(R.id.btn_plus);

        // Set them invisible
        txt_F_white.setVisibility(View.INVISIBLE);
        txt_i_white.setVisibility(View.INVISIBLE);
        txt_l_1_white.setVisibility(View.INVISIBLE);
        txt_l_2_white.setVisibility(View.INVISIBLE);
        txt_u_white.setVisibility(View.INVISIBLE);
        txt_s_white.setVisibility(View.INVISIBLE);
        txt_F_black.setVisibility(View.INVISIBLE);
        txt_i_black.setVisibility(View.INVISIBLE);
        txt_l_1_black.setVisibility(View.INVISIBLE);
        txt_l_2_black.setVisibility(View.INVISIBLE);
        txt_u_black.setVisibility(View.INVISIBLE);
        txt_s_black.setVisibility(View.INVISIBLE);
        txt_next.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.INVISIBLE);
        btn_plus.setVisibility(View.INVISIBLE);
        txt_plus.setVisibility(View.INVISIBLE);

        // Set animations
        anim_txt_next = AnimationUtils.loadAnimation(this, R.anim.txt_next);
        anim_txt_next_forward = AnimationUtils.loadAnimation(this, R.anim.txt_next_forward);
        anim_txt_plus = AnimationUtils.loadAnimation(this, R.anim.rotation);

        SpecialAnimators();

        // Showing up...
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_F_black.setVisibility(View.VISIBLE);
            }
        }, 200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_i_black.setVisibility(View.VISIBLE);
            }
        }, 400);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_l_1_black.setVisibility(View.VISIBLE);
            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_l_2_black.setVisibility(View.VISIBLE);
            }
        }, 800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_u_black.setVisibility(View.VISIBLE);
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_s_black.setVisibility(View.VISIBLE);
            }
        }, 1200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_F_white.setVisibility(View.VISIBLE);
                txt_i_white.setVisibility(View.VISIBLE);
                txt_l_1_white.setVisibility(View.VISIBLE);
                txt_l_2_white.setVisibility(View.VISIBLE);
                txt_u_white.setVisibility(View.VISIBLE);
                txt_s_white.setVisibility(View.VISIBLE);

                setDownAndUp_F.start();
                setDownAndUp_i.start();
                setDownAndUp_l_1.start();
                setDownAndUp_l_2.start();
                setDownAndUp_u.start();
                setDownAndUp_s.start();
            }
        }, 1400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txt_next.setVisibility(View.VISIBLE);
                txt_next.setAnimation(anim_txt_next);
            }
        }, 1800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_plus.setVisibility(View.VISIBLE);
                txt_plus.setVisibility(View.VISIBLE);

                setDownAndUp_plus.start();

                btn_next.setVisibility(View.VISIBLE);
            }
        }, 2500);


    }

    // Hide the navigation bar and make the entire app full-screen
    private void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    // When I exit for a moment from the app and I'll come back, the same effect must be continue
    @Override
    protected void onResume() {
        super.onResume();

        hideNavigationBar();
    }

    public void SpecialAnimators() {
        // Special guest | Animation for txt_F_white
        scaleDown_F = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_F.setTarget(txt_F_white);

        scaleUp_F = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_F = new AnimatorSet();
        setDownAndUp_F.playSequentially(scaleDown_F, scaleUp_F);

        // Special guest | Animation for txt_i_white
        scaleDown_i = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_i.setTarget(txt_i_white);

        scaleUp_i = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_i = new AnimatorSet();
        setDownAndUp_i.playSequentially(scaleDown_i, scaleUp_i);

        // Special guest | Animation for txt_l_1_white
        scaleDown_l_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_l_1.setTarget(txt_l_1_white);

        scaleUp_l_1 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_l_1 = new AnimatorSet();
        setDownAndUp_l_1.playSequentially(scaleDown_l_1, scaleUp_l_1);

        // Special guest | Animation for txt_l_2_white
        scaleDown_l_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_l_2.setTarget(txt_l_2_white);

        scaleUp_l_2 = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_l_2 = new AnimatorSet();
        setDownAndUp_l_2.playSequentially(scaleDown_l_2, scaleUp_l_2);

        // Special guest | Animation for txt_u_white
        scaleDown_u = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_u.setTarget(txt_u_white);

        scaleUp_u = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_u = new AnimatorSet();
        setDownAndUp_u.playSequentially(scaleDown_u, scaleUp_u);

        // Special guest | Animation for txt_s_white
        scaleDown_s = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_s.setTarget(txt_s_white);

        scaleUp_s = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_s = new AnimatorSet();
        setDownAndUp_s.playSequentially(scaleDown_s, scaleUp_s);

        // Special guest | Animation for txt_plus
        scaleDown_plus = AnimatorInflater.loadAnimator(this, R.animator.scale_down);
        scaleDown_plus.setTarget(txt_plus);

        scaleUp_plus = AnimatorInflater.loadAnimator(this, R.animator.scale_up);

        setDownAndUp_plus = new AnimatorSet();
        setDownAndUp_plus.playSequentially(scaleDown_plus, scaleUp_plus);

    }

    public void GoToFinalActionActivity(View view){
        Intent goToFinalActionActivity = new Intent(MainActivity.this, ActionActivity.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(btn_next, "buttonNextActivity");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

        startActivity(goToFinalActionActivity, activityOptions.toBundle());

    }

    public void GoToNextActivity(View view) {

        txt_next.startAnimation(anim_txt_next_forward);

        txt_plus.startAnimation(anim_txt_plus);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GoToFinalActionActivity(view);

            }
        }, 500);
    }


}