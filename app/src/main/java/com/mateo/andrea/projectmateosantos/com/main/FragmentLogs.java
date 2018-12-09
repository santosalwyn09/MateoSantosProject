package com.mateo.andrea.projectmateosantos.com.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.mateo.andrea.projectmateosantos.R;

public class FragmentLogs extends Fragment {
    View view;
    public FragmentLogs() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.logs_fragment, container, false);
        Button btn = (Button) view.findViewById(R.id.BtnFragment1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), LogView.class);
                startActivity(in);
            }
        });
        return view;

    }
}
