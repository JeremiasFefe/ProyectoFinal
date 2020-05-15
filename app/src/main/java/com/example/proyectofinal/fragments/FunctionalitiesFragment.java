package com.example.proyectofinal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyectofinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunctionalitiesFragment extends Fragment {

    private View v;
    private Button btnFuncToExpl;
    public FunctionalitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=  inflater.inflate(R.layout.fragment_functionalities, container, false);

        btnFuncToExpl=v.findViewById(R.id.btn_func_to_expl);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        btnFuncToExpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionalitiesFragmentDirections.ActionFunctionalitiesFragmentToExplanationFragment actionFunctionalitiesFragmentToExplanationFragment = new FunctionalitiesFragmentDirections.ActionFunctionalitiesFragmentToExplanationFragment();

                Navigation.findNavController(v).navigate(actionFunctionalitiesFragmentToExplanationFragment);
            }
        });
    }
}
