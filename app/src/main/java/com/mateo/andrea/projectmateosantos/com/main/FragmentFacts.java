package com.mateo.andrea.projectmateosantos.com.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mateo.andrea.projectmateosantos.R;

public class FragmentFacts extends Fragment {
    View view;
    public FragmentFacts() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.facts_fragment,container,false);
        return view;
    }
}
