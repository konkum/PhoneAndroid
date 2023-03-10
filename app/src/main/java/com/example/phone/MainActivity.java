package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private int iconId;
    private int flags[] = {R.drawable.android, R.drawable.apple, R.drawable.asus, R.drawable.samsing};

    private ArrayList<Phone> listPhone=new ArrayList<>();
    private ArrayList<Phone> filterList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_view);

        InitializedSpinner();
        InitializedPhone();
    }

    private void InitializedPhone(){
        EditText phoneMainNameText =(EditText) findViewById(R.id.main_phone_name);
        EditText phoneMainCostText =(EditText) findViewById(R.id.main_phone_cost);
        recyclerView =(RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        PhoneAdapter phoneAdapter = new PhoneAdapter(getApplicationContext(),listPhone);


        Button addBtn = findViewById(R.id.add_btn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPhone.add(new Phone(iconId,phoneMainNameText.getText().toString(),phoneMainCostText.getText().toString()));
                phoneAdapter.setAction(()-> {
                    recyclerView.setAdapter(phoneAdapter);
                });
                recyclerView.setAdapter(phoneAdapter);
            }
        });

        Button updateBtn=(Button) findViewById(R.id.update_btn);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<listPhone.size();i++){
                    if (listPhone.get(i).getPhoneName().equals(phoneMainNameText.getText().toString())){
                        listPhone.get(i).setPhoneCost(phoneMainCostText.getText().toString());
                        listPhone.get(i).setIcon(iconId);
                        recyclerView.setAdapter(phoneAdapter);
                        return;
                    }
                }
            }
        });


        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList.clear();
                for (int i=0;i<listPhone.size();i++){
                    if (listPhone.get(i).getPhoneName().equals(s)){
                        filterList.add(listPhone.get(i));
                    }
                }
                if (!filterList.isEmpty()){
                    phoneAdapter.setListPhone(filterList);
                    recyclerView.setAdapter(phoneAdapter);
                    return true;
                }

                phoneAdapter.setListPhone(listPhone);
                recyclerView.setAdapter(phoneAdapter);
                return false;
            }
        });
    }

    private void InitializedSpinner(){
        Spinner dropDown=(Spinner) findViewById(R.id.main_dropdown);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                iconId=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        SpinnerAdapter dropDownItem = new SpinnerAdapter(getApplicationContext(),flags);
        dropDown.setAdapter(dropDownItem);
    }
}