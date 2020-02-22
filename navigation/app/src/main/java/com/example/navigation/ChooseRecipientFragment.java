package com.example.navigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipientFragment extends Fragment implements View.OnClickListener{

    NavController navController;
    Button next,cancel;
    TextInputEditText input_recipient;
    public ChooseRecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        next =view.findViewById(R.id.next_btn);
        cancel =view.findViewById(R.id.cancel_btn);
        input_recipient = view.findViewById(R.id.input_recipient);
        next.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_btn:
                if(!TextUtils.isEmpty(input_recipient.getText().toString())){
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient",input_recipient.getText().toString().trim());
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,bundle);
                }
                else {
                    Toast.makeText(getActivity(), "Enter a name", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;

        }

    }
}
