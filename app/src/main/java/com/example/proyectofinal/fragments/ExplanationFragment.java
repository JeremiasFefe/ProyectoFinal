package com.example.proyectofinal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectofinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExplanationFragment extends Fragment {

    private View v;
    private TextView TxtExplanation;
    public ExplanationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_explanation, container, false);

        TxtExplanation=v.findViewById(R.id.txt_explanation);
        TxtExplanation.setText("Explanation Fragment");

        return v;
    }
}
