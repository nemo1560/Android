package com.example.nemo1.sqllite.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.adapter.Adapter_row;
import com.example.nemo1.sqllite.controller.SQL_manager;
import com.example.nemo1.sqllite.model.eStudent;

import java.util.List;

public class Main extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private TextView name_user;
    private EditText search_Txt;
    private Spinner spinner;
    private Button search_Btn;
    private ListView listView;
    private Adapter_row adapter_row;
    private List<eStudent> eStudentList;
    private ArrayAdapter arrayAdapter;
    private String spinner_Selected ="";
    private String search ="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        name_user = view.findViewById(R.id.name_user);
        search_Txt = view.findViewById(R.id.search_Txt);
        spinner = view.findViewById(R.id.class_spinner);
        spinner.setOnItemSelectedListener(this);
        search_Btn = view.findViewById(R.id.search_Btn);
        search_Btn.setOnClickListener(this);
        listView = view.findViewById(R.id.listView);

        createAdapterSpinner();
        name_user.setText("Username: "+ getUsername());
        search_Txt.setHint("Nhập thông tin sinh viên");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void createAdapterSpinner(){
        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.class_array,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        search = search_Txt.getText().toString();
        if(search.length()==0&&spinner_Selected.equals("")){
            SQL_manager sql_manager = new SQL_manager(getActivity());
            eStudentList = sql_manager.getAll();
            adapter_row = new Adapter_row(getActivity(),R.layout.custom_row,eStudentList);
            listView.setAdapter(adapter_row);
        }
        else{
            SQL_manager sql_manager = new SQL_manager(getActivity());
            eStudentList = sql_manager.getRequest(search,spinner_Selected);
            adapter_row = new Adapter_row(getActivity(),R.layout.custom_row,eStudentList);
            listView.setAdapter(adapter_row);
        }
    }

    public String getUsername(){
        Bundle bundle = getArguments();
        String name = bundle.getString("name_user");
        return name;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinner_Selected = spinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
