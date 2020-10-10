package com.example.session2_calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.session2_calculationtest.databinding.FragmentQuestionBinding;


public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        //这里需要保证new ViewModelProvider()得到的是同一个provider所以统一使用activity而不是this.
        final MyViewModel myViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        myViewModel.Generate();
        myViewModel.getCurrentScore().setValue(0);

        final FragmentQuestionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        final StringBuilder builder = new StringBuilder();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button0:
                        builder.append("0");
                        break;
                    case R.id.button1:
                        builder.append("1");
                        break;
                    case R.id.button2:
                        builder.append("2");
                        break;
                    case R.id.button3:
                        builder.append("3");
                        break;
                    case R.id.button4:
                        builder.append("4");
                        break;
                    case R.id.button5:
                        builder.append("5");
                        break;
                    case R.id.button6:
                        builder.append("6");
                        break;
                    case R.id.button7:
                        builder.append("7");
                        break;
                    case R.id.button8:
                        builder.append("8");
                        break;
                    case R.id.button9:
                        builder.append("9");
                        break;
                    case R.id.buttonClear:
                        builder.setLength(0);
                        break;
                }
                if(builder.length() == 0){
                    binding.textView9.setText(getString(R.string.Question_require));
                }
                else{
                    binding.textView9.setText(builder.toString());
                }
            }
        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonClear.setOnClickListener(listener);


        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final String TAG = "Current_message";
//                Log.d(TAG, "onClick:"+ String.valueOf(myViewModel.getCurrentScore().getValue()));
                if(Integer.parseInt(builder.toString()) == myViewModel.getAnswer().getValue()){
                    myViewModel.AnswerCorrect();
                    builder.setLength(0);
                    binding.textView9.setText(getString(R.string.Correct_message));
                }
                else{
                    if(myViewModel.win_flag){
                        myViewModel.win_flag = false;
                        myViewModel.SaveShp();
                        NavController controller = Navigation.findNavController(v);
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                    }
                    else{
                        NavController controller = Navigation.findNavController(v);
                        controller.navigate(R.id.action_questionFragment_to_loseFragment);
                    }
                }
            }
        });

        return binding.getRoot();
    }
}