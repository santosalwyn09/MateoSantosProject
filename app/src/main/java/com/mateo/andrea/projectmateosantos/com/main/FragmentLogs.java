package com.mateo.andrea.projectmateosantos.com.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mateo.andrea.projectmateosantos.R;

public class FragmentLogs extends Fragment {
    View view;
    public FragmentLogs() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.logs_fragment, container, false);
        Button nxtLog=(Button)view.findViewById(R.id.BtnFragment1);

        nxtLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.linearLayout3, new LogsFragment());
                fr.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fr.commit();
            }
        });
        return view;
    }
}
