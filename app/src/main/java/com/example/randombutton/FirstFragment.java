package com.example.randombutton;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FirstFragment extends Fragment {

    private TextView textView;
    private View firstFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firstFragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        textView = firstFragmentView.findViewById(R.id.textView);

        return firstFragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber();
            }
        });

        view.findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                action.setMyArg(text);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });
    }

    private void randomNumber(){
        Random random = new Random();
        Integer number = random.nextInt(1028);
        textView.setText(number.toString());
    }
}