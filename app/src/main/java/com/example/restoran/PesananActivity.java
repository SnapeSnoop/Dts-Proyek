package com.example.restoran;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PesananActivity extends AppCompatActivity {
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText txt_tanggal, txt_jam, txt_nomormeja, kd_menu, harga;
    Button btn_get_datetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        txt_tanggal = (EditText) findViewById(R.id.edt_txt_tanggal);
        txt_jam = (EditText) findViewById(R.id.edt_txt_jam);
        btn_get_datetime = (Button) findViewById(R.id.btn_get_datetime);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        txt_tanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(PesananActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_jam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(PesananActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_jam.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

//        btn_get_datetime.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PesananActivity.this,
//                        "Tanggal : " + txt_tanggal.getText().toString() + "\n" +
//                                "Jam : " + txt_jam.getText().toString()
//                        , Toast.LENGTH_SHORT
//                ).show();
//            }
//        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tanggal.setText(sdf.format(myCalendar.getTime()));
    }

    public void getDate(View v) {
        txt_nomormeja = findViewById(R.id.edt_txt_nomor_meja);
        kd_menu = findViewById(R.id.edt_txt_kode_menu);
        harga = findViewById(R.id.edt_txt_harga);
        txt_tanggal = findViewById(R.id.edt_txt_tanggal);
        txt_jam = findViewById(R.id.edt_txt_jam);

        String nomorMeja = txt_nomormeja.getText().toString();
        String kdMenu = kd_menu.getText().toString();
        String hrga = harga.getText().toString();
        String tanggal = txt_tanggal.getText().toString();
        String jam = txt_jam.getText().toString();

        if (nomorMeja.isEmpty()) {
            txt_nomormeja.setError("Nomor Meja Harus Di isi Brow");
            txt_nomormeja.requestFocus();
            return;
        }else if (kdMenu.isEmpty()){
            kd_menu.setError("Nomor Menu Harus Di isi Brow");
            kd_menu.requestFocus();
            return;
        }else if (hrga.isEmpty()){
            harga.setError("Harga Harus Di isi Brow");
            harga.requestFocus();
            return;
        }else if (tanggal.isEmpty()){
            txt_tanggal.setError("Tanggal Menu Harus Di isi Brow");
            txt_tanggal.requestFocus();
            return;
        }else if(jam.isEmpty()){
            txt_jam.setError("Tanggal Menu Harus Di isi Brow");
            txt_jam.requestFocus();
            return;
        }
    }
}
