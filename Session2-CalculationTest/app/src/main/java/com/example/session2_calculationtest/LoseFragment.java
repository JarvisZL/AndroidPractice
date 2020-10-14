package com.example.session2_calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.session2_calculationtest.databinding.FragmentLoseBinding;

public class LoseFragment extends Fragment {



    public LoseFragment() {
        // Required empty public constructor
    }

    @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //这里需要保证new ViewModelProvider()得到的是同一个provider所以统一使用activity而不是this.
        MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        FragmentLoseBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lose, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loseFragment_to_welcomeFragment);
            }
        });

        return binding.getRoot();
    }
}