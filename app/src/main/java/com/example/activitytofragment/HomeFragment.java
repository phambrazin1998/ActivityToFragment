package com.example.activitytofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private EditText edtEmail;
    private Button btnUpdate;
    private View mView;
    private UpdateData mUpdateData;
    private MainActivity mainActivity;
    public interface UpdateData {
        void UpdateData(String email);
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mUpdateData = (UpdateData) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mainActivity = (MainActivity) getActivity();
        initUI();

        return mView;
    }

    private void initUI() {
        edtEmail = mView.findViewById(R.id.edtEmail);
        btnUpdate = mView.findViewById(R.id.btnUpdate);
        edtEmail.setText(mainActivity.getEmail());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                updateData();
                sendDatatoActivity();
            }
        });
    }

    private void updateData() {
        String strEmail = edtEmail.getText().toString().trim();
        mUpdateData.UpdateData(strEmail);
    }
    private void sendDatatoActivity(){
        String strEmail = edtEmail.getText().toString().trim();
        mainActivity.getEdtEmail().setText(strEmail);
    }
    public void nhanData(String email) {
        edtEmail.setText(email);
    }
}