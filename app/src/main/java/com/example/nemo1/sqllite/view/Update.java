package com.example.nemo1.sqllite.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.model.eStudent;

public class Update extends Fragment {
    private EditText user,pass,subject;
    private Button update_Btn;

    public Update() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = view.findViewById(R.id.user_Txt);
        pass = view.findViewById(R.id.pass_Txt);
        subject = view.findViewById(R.id.subject_Txt);
        update_Btn = view.findViewById(R.id.update_Btn);
        Bundle bundle = getArguments();
        eStudent eStudent = (com.example.nemo1.sqllite.model.eStudent) bundle.getSerializable("eStudent");
        user.setText(eStudent.getSv_Ten());
        pass.setText(eStudent.getSv_Lop());
        subject.setText(eStudent.getSv_Mon());
    }
}
