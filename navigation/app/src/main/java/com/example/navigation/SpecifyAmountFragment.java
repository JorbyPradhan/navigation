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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    String recipient;
    Button Send_btn,Cancel;
    TextView Reci;
    TextInputEditText Ed_amount;
    Money amount;

    public SpecifyAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipient = getArguments().getString("recipient");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Send_btn = view.findViewById(R.id.send_btn);
        Cancel = view.findViewById(R.id.cancel_btn);
        Reci = view.findViewById(R.id.recipient);
        Reci.setText("Sending money to " + recipient);
        Ed_amount = view.findViewById(R.id.input_amount);
        Send_btn.setOnClickListener(this);
        Cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_btn :
                if(!TextUtils.isEmpty(Ed_amount.getText().toString())) {
                    amount = new Money(new BigDecimal(Ed_amount.getText().toString()));
                    Bundle bundle = new Bundle();
                    bundle.putString("recipient",recipient);
                    bundle.putParcelable("amount",amount);
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle);
                }
                else {
                    Toast.makeText(getActivity(), "Enter an amount", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;
        }
    }
}
