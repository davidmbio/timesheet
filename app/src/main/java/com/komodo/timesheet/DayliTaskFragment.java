package com.komodo.timesheet;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by david on 18/06/14.
 */
public class DayliTaskFragment extends Fragment implements View.OnClickListener {

    public static final int QUICK_ACCESS_OFFICE = 0;
    public static final int QUICK_ACCESS_TRAINING = 1;
    public static final int QUICK_ACCESS_VACATION = 2;

    public static final int DETAILED_ACCESS_OFFICE = 6;
    public static final int DETAILED_ACCESS_TRAINING = 7;
    public static final int DETAILED_ACCESS_VACATION = 8;
    public static final int DETAILED_ACCESS_ENGINNERING = 9;
    public static final int DETAILED_ACCESS_TRAVEL = 10;
    public static final int DETAILED_ACCESS_FIELD = 11;



    private ListView activityTypeList;
    private ArrayList<String> activityTypes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_dayli_task, container, false);

        String[] types = getResources().getStringArray(R.array.activity_type_array);
        activityTypes = new ArrayList<String>();

        for(int i=0; i<types.length; i++){
            activityTypes.add(types[i]);
        }

        activityTypeList = (ListView)rootView.findViewById(R.id.lv_content_activitys_type);
        TypesAdapter adapter = new TypesAdapter(this, activityTypes);
        activityTypeList.setAdapter(adapter);

        return  rootView;
    }

    @Override
    public void onClick(View view) {
        int option = Integer.parseInt(view.getTag().toString());
        switch (option){
            case QUICK_ACCESS_OFFICE:
                Toast.makeText(getActivity(),"Acceso rapido oficina",Toast.LENGTH_LONG).show();
                break;

            case QUICK_ACCESS_TRAINING:
                Toast.makeText(getActivity(),"Acceso rapido viaje",Toast.LENGTH_LONG).show();
                break;
            case QUICK_ACCESS_VACATION:
                Toast.makeText(getActivity(),"Acceso rapido vacaciones",Toast.LENGTH_LONG).show();
                break;
            case DETAILED_ACCESS_OFFICE:
                Toast.makeText(getActivity(),"Acceso detallado oficina",Toast.LENGTH_LONG).show();
                break;
            case DETAILED_ACCESS_TRAINING:
                Toast.makeText(getActivity(),"Acceso detallado capacitacion",Toast.LENGTH_LONG).show();
                break;

            case DETAILED_ACCESS_VACATION:
                Toast.makeText(getActivity(),"Acceso detallado vacaciones",Toast.LENGTH_LONG).show();
                break;

            case DETAILED_ACCESS_ENGINNERING:
                Toast.makeText(getActivity(),"Acceso detallado ingenieria",Toast.LENGTH_LONG).show();
                break;

            case DETAILED_ACCESS_TRAVEL:
                Toast.makeText(getActivity(),"Acceso detallado viaje",Toast.LENGTH_LONG).show();
                break;

            case DETAILED_ACCESS_FIELD:
                Toast.makeText(getActivity(),"Acceso detallado campo",Toast.LENGTH_LONG).show();
                break;

            default:
                System.out.println("hello world!");
                break;
        }
    }
}
