package com.example.nemo1.sqllite.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nemo1.sqllite.R;
import com.example.nemo1.sqllite.model.eStudent;
import com.example.nemo1.sqllite.view.Update;

import java.util.List;

public class Adapter_row extends ArrayAdapter<eStudent> {
    private List<eStudent> eStudentList;
    private Context context;
    private int resource;
    private TextView nameR,classR,subjectR;
    private ImageView updateImg,deleteImg;

    public Adapter_row(@NonNull Context context, int resource, @NonNull List<eStudent> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.eStudentList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(resource,parent,false);
        nameR = convertView.findViewById(R.id.name_Row);
        classR = convertView.findViewById(R.id.class_Row);
        subjectR = convertView.findViewById(R.id.subject_Row);
        updateImg = convertView.findViewById(R.id.update_option);
        deleteImg = convertView.findViewById(R.id.delete_option);

        final eStudent eStudent = eStudentList.get(position);
        nameR.setText(eStudent.getSv_Ten());
        classR.setText(eStudent.getSv_Lop());
        subjectR.setText(eStudent.getSv_Mon());
        updateImg.setImageResource(R.drawable.ic_edit_black_24dp);
        deleteImg.setImageResource(R.drawable.ic_delete_black_24dp);

        updateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Fragment fragment = new Update();
                bundle.putSerializable("eStudent",eStudent);
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });
        return convertView;
    }

}
