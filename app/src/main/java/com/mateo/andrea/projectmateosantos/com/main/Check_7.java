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
import android.widget.TextView;

import com.mateo.andrea.projectmateosantos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Check_7 extends Fragment {

    View view;
    public Check_7() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.check6, container, false);
        Button nxtpg=(Button)view.findViewById(R.id.pg7);

        nxtpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction frag = getFragmentManager().beginTransaction();
                frag.replace(R.id.chk1, new Check_8());
                frag.commit();
            }
        });
        return view;
    }

}
