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
public class MenuFragment extends Fragment {

    private View v;
    private Button btnMenuToFunc;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_menu, container, false);

        btnMenuToFunc=v.findViewById(R.id.btn_menu_to_func);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        btnMenuToFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragmentDirections.ActionMenuFragmentToFunctionalitiesFragment actionMenuFragmentToFunctionalitiesFragment = new MenuFragmentDirections.ActionMenuFragmentToFunctionalitiesFragment();

                Navigation.findNavController(v).navigate(actionMenuFragmentToFunctionalitiesFragment);
            }
        });
    }
}
