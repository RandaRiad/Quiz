package com.randa.quiz.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randa.quiz.R;
import com.randa.quiz.databinding.FragmentYourResult2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YourResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YourResultFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";


    FragmentYourResult2Binding binding;
    View view;
    Bundle data;
    ResultFragments resultFragments;
    Bundle bundle = new Bundle();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public YourResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YourResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YourResultFragment newInstance(String param1, String param2) {
        YourResultFragment fragment = new YourResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentYourResult2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultFragments = new ResultFragments();
        data = getArguments();


        int result = (data.getInt("count") * 100) / data.getInt("total");
        binding.percentageText.setText(result + " % ");
        binding.resultProgress.setProgress(result);
        if (result > 50) {
            binding.textResult.setText("Congratulations");
            binding.imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.winner));
        } else {
            binding.textResult.setText("Try Again");
            binding.imageViewResult.setImageDrawable(getResources().getDrawable(R.drawable.fail));

        }
        binding.correctAnsers.setText(String.valueOf(data.getInt("count")));


        binding.yourResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putParcelableArrayList("yourAnswe", data.getParcelableArrayList("yourAnswers"));

                resultFragments.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, resultFragments).commit();

            }
        });

    }
}