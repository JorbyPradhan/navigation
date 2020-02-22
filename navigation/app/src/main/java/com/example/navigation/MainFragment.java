package com.example.navigation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    NavController navController;
    Button TransactionBtn,SendMoney,ViewBalance;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        TransactionBtn = view.findViewById(R.id.view_transactions_btn);
        SendMoney = view.findViewById(R.id.send_money_btn);
        ViewBalance =view.findViewById(R.id.view_balance_btn);
        TransactionBtn.setOnClickListener(this);
        SendMoney.setOnClickListener(this);
        ViewBalance.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.view_transactions_btn :
                navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment);
                break;
            case R.id.send_money_btn :
                navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment);
                break;
            case R.id.view_balance_btn :
                navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment);
                break;
        }

    }
}
