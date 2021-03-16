package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
    int PERMISSIONS_READ_CONTACTS = 0;
    String[] mProjection;
    Cursor mCursor;
    ContactsAdapter mContactsAdapter;
    ListView mlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Permisos.requestPermission(this, Manifest.permission.READ_CONTACTS,"",PERMISSIONS_READ_CONTACTS);

        //Setear lista de contactos
        mlista = (ListView)findViewById(R.id.list);
        mProjection = new String[]{ContactsContract.Profile._ID, ContactsContract.Profile.DISPLAY_NAME_PRIMARY};
        mContactsAdapter = new ContactsAdapter(this,null,0);
        mlista.setAdapter(mContactsAdapter);
        initView();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Gracias", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Funcionalidad Limitada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initView() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permission == PackageManager.PERMISSION_GRANTED){
            mCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,mProjection,
                    null,null,null);
            mContactsAdapter.changeCursor(mCursor);
        }
    }
}