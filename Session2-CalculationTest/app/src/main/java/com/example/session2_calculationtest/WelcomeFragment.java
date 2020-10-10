package com.example.session2_calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.session2_calculationtest.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        MyViewModel myViewModel;
        //这里需要保证new ViewModelProvider()得到的是同一个provider所以统一使用activity而不是this.
        myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        FragmentWelcomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_welcomeFragment_to_questionFragment);
            }
        });

        return binding.getRoot();
    }
}