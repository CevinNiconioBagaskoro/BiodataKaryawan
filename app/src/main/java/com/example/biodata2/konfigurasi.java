package com.example.biodata2;

public class konfigurasi {

    // PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD = "http://192.168.37.142/androiddb/TambahBiodata2.php";

    // Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_NIS = "Nis";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_JENIS_KELAMIN = "jenis_kelamin";
    public static final String KEY_EMP_KOTA = "kota";
    public static final String KEY_EMP_UMUR = "umur";

    // JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_NIS = "Nis";
    public static final String TAG_NAMA = "name";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_KOTA = "kota";
    public static final String TAG_UMUR = "umur";


    public static final String EMP_ID = "emp_id";
}
