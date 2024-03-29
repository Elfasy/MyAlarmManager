package com.example.myalarmmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    DialogDateListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null){
            listener = (DialogDateListener) context;
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
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        return new DatePickerDialog(getActivity(),this,year,month,date);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        listener.onDialogDataSet(getTag(),i,i1,i2);
    }

    public interface DialogDateListener {
        void onDialogDataSet(String tag, int year, int month, int dayOfMonth);
    }
}
