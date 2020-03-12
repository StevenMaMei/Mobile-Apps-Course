package com.example.ejemplolistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView contactsTable;
    private ContactsAdapter adapter;

    private EditText phoneField, nameField;
    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsTable = findViewById(R.id.contactsTable);
        adapter = new ContactsAdapter();
        contactsTable.setAdapter( adapter);

        phoneField= findViewById(R.id.phoneField);
        nameField = findViewById(R.id.nameField);
        addButton = findViewById(R.id.addButton);

        adapter.addContact(new Contact("Steven", "3057599598"));
        adapter.addContact(new Contact("JEJEJ", "2321222"));

        addButton.setOnClickListener(
                (v) -> {
                    adapter.addContact(new Contact(nameField.getText().toString(), phoneField.getText().toString()));
                }
        );
    }
}
