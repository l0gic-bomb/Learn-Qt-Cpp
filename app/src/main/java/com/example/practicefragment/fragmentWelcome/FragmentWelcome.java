package com.example.practicefragment.fragmentWelcome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicefragment.R;

public class FragmentWelcome extends Fragment {

    public final static String TAG = "FragWelcomeTag";
    private Button btnWelcome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        return inflater.inflate(R.layout.fragment_welcome, container, false);

    }

}