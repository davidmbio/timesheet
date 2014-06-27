package com.komodo.timesheet;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by david on 26/06/14.
 */
public class ActivitiesDialog implements DialogInterface.OnClickListener, SeekBar.OnSeekBarChangeListener {

    AlertDialog alertDialog;
    Context context;
    int title, progress = 0;;
    SeekBar seekBar;
    TextView textView;

    public ActivitiesDialog(Context context, int title)
    {
        this.context = context;
        this.title=title;
        this.createDialogView();
    }
    protected void createDialogView()
    {
        LayoutInflater inflater =  ((Activity)context).getLayoutInflater();
        ViewGroup dialogView = (ViewGroup)inflater.inflate(R.layout.activity_detail_dialog, null);

        seekBar = (SeekBar)dialogView.findViewById(R.id.sbHoras);
        textView = (TextView)dialogView.findViewById(R.id.tvHoras);

        textView.setText(seekBar.getProgress() + " H");

        Builder builder = new Builder(context);
        builder.setTitle(title)
                .setView(dialogView)
                .setIcon(R.drawable.ic_action_dayli_task)
                .setPositiveButton(R.string.btn_ok, this)
                .setNegativeButton(R.string.btn_cancel, this);

        seekBar.setOnSeekBarChangeListener(this);

        this.alertDialog = builder.create();
        this.alertDialog.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            System.out.println("Ok. pressed button");
        }

        if(which == DialogInterface.BUTTON_NEGATIVE){
            System.out.println("Cancel logout");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser) {
        progress = progresValue;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do something here,
        //if you want to do anything at the start of
        // touching the seekbar
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        textView.setText(progress + " H");
    }
}
