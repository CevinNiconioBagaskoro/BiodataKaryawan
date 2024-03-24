package com.example.biodata2;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextnis;
    private EditText editTextName;

    private EditText editTextAlamat;

    private Spinner editTextKota;

    private Button buttonAdd;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextnis = findViewById(R.id.nis);
        editTextName = findViewById(R.id.nama);
        editTextAlamat = findViewById(R.id.alamat);
        editTextKota = findViewById(R.id.listItem);

        buttonAdd = findViewById(R.id.submit);
        buttonAdd.setOnClickListener(this);
    }

    private void addEmployee() {
        final String nis = editTextnis.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String kota = editTextKota.getSelectedItem().toString().trim();

            // Mendapatkan nilai dari RadioGroup "Jenis Kelamin"
        RadioGroup radioGroupJK = findViewById(R.id.jenisKelamin);
        int selectedRadioButtonId = radioGroupJK.getCheckedRadioButtonId();
        final String jenisKelamin;  // Jadikan variabel jenisKelamin final

        if (selectedRadioButtonId != -1) {
            switch (selectedRadioButtonId) {
                case R.id.laki:
                    jenisKelamin = "Laki-Laki";
                    break;
                case R.id.perempuan:
                    jenisKelamin = "Perempuan";
                    break;
                default:
                    jenisKelamin = "";  // Tetapkan nilai default jika diperlukan
                    break;
            }

            // Mendapatkan nilai dari EditText "Umur"
            EditText editTextUmur = findViewById(R.id.umur);
            final String umur = editTextUmur.getText().toString().trim();

            class AddEmployee extends AsyncTask<Void, Void, String> {

                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(MainActivity.this, "Menambahkan...", "Tunggu...", false, false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }

                @Override
                protected String doInBackground(Void... v) {
                    HashMap<String, String> params = new HashMap<>();
                    params.put(konfigurasi.KEY_EMP_NIS, nis);
                    params.put(konfigurasi.KEY_EMP_NAMA, name);
                    params.put(konfigurasi.KEY_EMP_ALAMAT, alamat);
                    params.put(konfigurasi.KEY_EMP_KOTA, kota);
                    params.put(konfigurasi.KEY_EMP_JENIS_KELAMIN, jenisKelamin);
                    params.put(konfigurasi.KEY_EMP_UMUR, umur);
                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                    return res;
                }
            }

            AddEmployee ae = new AddEmployee();
            ae.execute();
        }
    }
        @Override
    public void onClick(View v) {
        if (v == buttonAdd) {
            addEmployee();
        }
    }
}