package com.cs180project.ucrclasses;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alamkanak.weekview.WeekView;

import java.util.Calendar;

/**
 * Created by Peter on 11/14/2016.
 */
public class CalendarSelectActivity extends Fragment{
    View myView;
    private Button sched1;
    private Button sched2;
    private Button sched3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_calendar_select, container, false);
        getActivity().setTitle("Select Schedule");
        sched1 = (Button) myView.findViewById(R.id.Schedule1);
        sched2 = (Button) myView.findViewById(R.id.Schedule2);
        sched3 = (Button) myView.findViewById(R.id.Schedule3);

        sched1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UCRSchedules.activeSched = 0;
                Intent intent = new Intent(getActivity(), CalendarActivity1.class);
                startActivity(intent);
            }
        });
        sched2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UCRSchedules.activeSched = 1;
                Intent intent = new Intent(getActivity(), CalendarActivity2.class);
                startActivity(intent);
            }
        });
        sched3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UCRSchedules.activeSched = 2;
                Intent intent = new Intent(getActivity(), CalendarActivity3.class);
                startActivity(intent);
            }
        });

        return myView;
    }


}