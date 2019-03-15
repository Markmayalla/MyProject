package tz.co.comptech.m_safariproduction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //Create a new instance of datepicker and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        TextView date = getActivity().findViewById(R.id.date);
        TextView monthView = getActivity().findViewById(R.id.month);
        TextView day = getActivity().findViewById(R.id.day);
        TextView yearView = getActivity().findViewById(R.id.year);
        EditText searchDate = getActivity().findViewById(R.id.searchdate);

        yearView.setText(String.valueOf(year));
        date.setText(String.valueOf(dayOfMonth));
        monthView.setText(getMonthString(month));
        day.setText(getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK)));

        searchDate.setText(String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(dayOfMonth));
    }

    private String getMonthString(int month) {
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] months = symbols.getMonths();
        return months[month];
    }

    private String getDayOfWeek(int day) {
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] days = symbols.getWeekdays();
        return days[day];
    }
}
