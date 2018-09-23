package com.example.nemo1.sqllite.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.controller.SQL_manager;
import com.example.nemo1.sqllite.model.eStudent;

public class Login extends Fragment implements View.OnClickListener {
    private EditText user,pass;
    private Button login;
    private SQL_manager sql_manager;
    static int a=0;

    public Login() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = view.findViewById(R.id.user_Txt);
        pass = view.findViewById(R.id.pass_Txt);
        login = view.findViewById(R.id.login_Btn);
        initEvent();
    }
    public void initEvent(){
        pass.setEnabled(false);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_Btn){
            if(user.getText().length() == 0){
                Toast.makeText(getActivity(),"Vui lòng nhập tên sinh viên",Toast.LENGTH_SHORT).show();
            }
            else {
                pass.setEnabled(true);
                if (pass.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Vui lòng nhập lớp", Toast.LENGTH_SHORT).show();
                } else {
                    eStudent eStudent = new eStudent(String.valueOf(user.getText()), String.valueOf(pass.getText()));
                    sql_manager = new SQL_manager(getActivity());
                    boolean check = sql_manager.login(eStudent.getSv_Ten(),eStudent.getSv_Lop());
                    if(check){
                        Bundle bundle = new Bundle();
                        bundle.putString("name_user",eStudent.getSv_Ten());
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        Fragment fragment = new Main();
                        fragment.setArguments(bundle);
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.commit();
                    }
                    else {
                        Toast.makeText(getActivity(),"Nhập lai thông tin",Toast.LENGTH_SHORT).show();
                        user.setText("");
                        pass.setText("");
                        a++;
                        if(a==2){
                            getActivity().finish();
                        }
                    }
                }
            }
        }
    }
}
