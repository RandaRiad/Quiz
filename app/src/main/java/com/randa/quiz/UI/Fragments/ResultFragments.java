package com.randa.quiz.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randa.quiz.POJO.QuestionModel;
import com.randa.quiz.R;
import com.randa.quiz.UI.ViewModelQuestions.ViewModelQuestion;
import com.randa.quiz.UI.activities.QuestionAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "diff";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewModelQuestion viewModelQuestion;
    private QuestionAdapter adapter;
    RecyclerView recyclerView;
    View view;
    Bundle data;


    public ResultFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragments newInstance(String param1, String param2) {
        ResultFragments fragment = new ResultFragments();
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

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result_fragments, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data = getArguments();

        adapter = new QuestionAdapter();
        adapter.getYouranswers(data.getParcelableArrayList("yourAnswe"));
        recyclerView = view.findViewById(R.id.reycler_result_fragment);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        viewModelQuestion = new ViewModelProvider(getActivity()).get(ViewModelQuestion.class);


        viewModelQuestion.getListQuestion().observe(getActivity(), new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels) {
                adapter.setList(questionModels);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}