package com.example.nemo1.sqllite.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.adapter.Adapter_row;
import com.example.nemo1.sqllite.controller.SQL_manager;
import com.example.nemo1.sqllite.model.eStudent;

import static android.support.v4.content.ContextCompat.getSystemService;

public class Register extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText user_Std,class_Std;
    private Spinner subject_Std;
    private Button register;
    private SQL_manager sql_manager;
    private ArrayAdapter arrayAdapter;
    private String subject;
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user_Std = view.findViewById(R.id.user_Txt);
        class_Std = view.findViewById(R.id.pass_Txt);
        subject_Std = view.findViewById(R.id.subject_spinner);
        register = view.findViewById(R.id.register_Btn);
        initEvent();
        createAdapterSpinner();
    }

    private void initEvent() {
        register.setOnClickListener(this);
        subject_Std.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.register_Btn){
            if(user_Std.getText().length() == 0 || class_Std.getText().length() == 0|| subject.isEmpty()){
                Toast.makeText(getActivity(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            }
            else {
                eStudent eStudent = new eStudent(String.valueOf(user_Std.getText()),String.valueOf(class_Std.getText()),subject);
                sql_manager = new SQL_manager(getActivity());
                sql_manager.insertData(eStudent);
                NotificationCompat.Builder notification = new NotificationCompat.Builder(getActivity(),CHANNEL_1_ID);
                notification.setSmallIcon(R.drawable.ic_launcher_background);
                notification.setContentTitle("Registration");
                notification.setContentText("OK");
                notification.setPriority(NotificationCompat.PRIORITY_HIGH);
                notification.setCategory(NotificationCompat.CATEGORY_MESSAGE);
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,notification.build());

            }
        }
    }

    public void createAdapterSpinner(){
        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.class_array,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject_Std.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        subject = subject_Std.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
