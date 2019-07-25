package com.example.myalarmmanager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    DialogTimeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null){
            listener = (DialogTimeListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (listener != null){
            listener = null;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        boolean formatHour24 = true;
        return new TimePickerDialog(getActivity(),this,hour,minute,formatHour24);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        listener.onDialogTimeSet(getTag(),i,i1);
    }

    public interface DialogTimeListener{
        void onDialogTimeSet(String tag,int hourOfDay, int minute);
    }
}
