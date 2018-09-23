package com.example.nemo1.sqllite.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.controller.SQL_manager;
import com.example.nemo1.sqllite.model.eStudent;

public class Register extends Fragment implements View.OnClickListener {
    private EditText user_Std,class_Std,subject_Std;
    private Button register;
    private SQL_manager sql_manager;

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
        subject_Std = view.findViewById(R.id.subjects_Txt);
        register = view.findViewById(R.id.register_Btn);
        initEvent();
    }

    private void initEvent() {
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.register_Btn){
            if(user_Std.getText().length() == 0 || class_Std.getText().length() == 0|| subject_Std.getText().length() == 0){
                Toast.makeText(getActivity(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            }
            else {
                eStudent eStudent = new eStudent(String.valueOf(user_Std.getText()),String.valueOf(class_Std.getText()),String.valueOf(subject_Std.getText()));
                sql_manager = new SQL_manager(getActivity());
                sql_manager.insertData(eStudent);
                Toast.makeText(getActivity(),"Đã lưu",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
