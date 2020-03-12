package com.example.ejemplolistas;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;

    public ContactsAdapter(){
        contacts = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
        //el notify es como un observer ya implementado que le hace saber que se añadieron datos
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.contact_row, null,false);
        TextView nameRowField = row.findViewById(R.id.nameField);
        TextView phoneRowField = row.findViewById(R.id.phoneRowField);
        Button callButton = row.findViewById(R.id.callButton);

        nameRowField.setText(contacts.get(position).getName());
        phoneRowField.setText(contacts.get(position).getPhone());

        callButton.setOnClickListener(
                (v) ->{
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+contacts.get(position).getPhone()));
                    parent.getContext().startActivity(intent);
                }
        );
        return row;
    }
}
