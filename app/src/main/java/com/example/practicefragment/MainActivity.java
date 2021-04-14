package com.example.practicefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.practicefragment.fragmentWelcome.FragmentCourse;
import com.example.practicefragment.fragmentWelcome.FragmentWelcome;

public class MainActivity extends AppCompatActivity {

    private FragmentWelcome welcome;
    private FragmentCourse fragCourse;
    private FragmentTransaction ft;
    private FragmentManager fm;

    private Fragment currentFragment;
    private String lastTag;

    private final String rem = "remove", rep = "replace", add = "add";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        welcome = new FragmentWelcome();
        setTmpFrag(welcome, welcome.TAG);
        makeTransaction(welcome,  welcome.TAG, rep);
    }

    void makeTransaction(Fragment frag, String tag, String action) {
        ft = fm.beginTransaction();
        switch (action) {
            case rem:
                ft.remove(frag);
                break;
            case rep:
                if (fm.findFragmentByTag(tag) == null)
                    ft.replace(R.id.forFragment, frag);
                break;
            case add:
                if (fm.findFragmentByTag(tag) == null) {
                    ft.add(frag, tag);
                }
                break;
        }

        ft.commit();
    }

    public void onClickNext(View view) {
        fragCourse = new FragmentCourse();

        currentFragment = fragCourse;
        lastTag = fragCourse.TAG;

        makeTransaction(fragCourse, fragCourse.TAG, rep);
        makeTransaction(welcome, welcome.TAG, rem);
    }

    public  void onClickSkip(View view) {
        makeTransaction(currentFragment, lastTag, rem);
    }

    void setTmpFrag(Fragment tmpFragment, String tag) {
        currentFragment = tmpFragment;
        lastTag = tag;
    }
}