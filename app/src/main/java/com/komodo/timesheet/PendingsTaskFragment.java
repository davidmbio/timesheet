package com.komodo.timesheet;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;


public class PendingsTaskFragment extends Fragment implements CalendarView.OnDateChangeListener{

    CalendarView calendarPendings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_pendings_task, container, false);

        calendarPendings = (CalendarView)rootView.findViewById(R.id.calendarView2);
        calendarPendings.setOnDateChangeListener(this);
        return rootView;
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
       Toast.makeText(getActivity(),"Dia seleccionado \n\n "+ dayOfMonth + "/" + month +"/"+ year,Toast.LENGTH_LONG).show();
    }
}
