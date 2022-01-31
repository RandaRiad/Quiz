package com.randa.quiz.UI.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.randa.quiz.POJO.QuestionModel;
import com.randa.quiz.POJO.YourAnswers;
import com.randa.quiz.R;
import com.randa.quiz.UI.ViewModelQuestions.ViewModelQuestion;
import com.randa.quiz.UI.activities.Home;
import com.randa.quiz.databinding.FragmentQuestionsFragmentsBinding;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionsFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionsFragments extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "category";
    private static final String ARG_PARAM2 = "Diffcult";

    // TODO: Rename and change types of parameters
    private String categoryName;
    private String diffeclty;
    View view;
    private ViewModelQuestion viewModelQuestion;
    List<YourAnswers> yourAnswers = new ArrayList<>();
    FragmentQuestionsFragmentsBinding binding;
    ResultFragments resultFragments;
    int questionCount = 0;
    int correctAnswer = 0;
    int progressAcount = 1;
    Bundle data = new Bundle();
    YourAnswers yourAnswer;
    YourResultFragment yourResultFragment;

    public QuestionsFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionsFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionsFragments newInstance(String param1, String param2) {
        QuestionsFragments fragment = new QuestionsFragments();
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
        requireActivity().getOnBackPressedDispatcher().addCallback(this, backPressedCallback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestionsFragmentsBinding.inflate(inflater, container, false);
        view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryName = getArguments().getString(ARG_PARAM1);
        diffeclty = getArguments().getString(ARG_PARAM2);

        binding.progressBarQuestion.setBackgroundColor(getResources().getColor(R.color.blue));

        viewModelQuestion = new ViewModelProvider(getActivity()).get(ViewModelQuestion.class);
        viewModelQuestion.getQuestions(categoryName, diffeclty);
        binding.categoryName.setText(categoryName + " / " + diffeclty);

        viewModelQuestion.getQuestionModelMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels) {
                fillQuestion(questionModels);
            }
        });


    }

    OnBackPressedCallback backPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            AlertDialog dialog = new MaterialAlertDialogBuilder(getActivity())
                    .setTitle("Message")
                    .setMessage("Do you want exit Exam ? ")

                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(new Intent(getActivity(), Home.class));
                            dialog.dismiss();


                        }
                    }).setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create();
            dialog.show();
        }
    };

    public void fillQuestion(List<QuestionModel> questionList) {

        viewModelQuestion.setListQuestion(questionList);

        if (questionList != null && questionList.size() > 0) {
            binding.questionLinearlayout.setVisibility(View.VISIBLE);
            binding.progressBarLoader.setVisibility(View.GONE);
            binding.progressBarQuestion.setMax(questionList.size());


            countQuestion(questionList);
            binding.fragmentNext.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    checkecdCorrectAnswers(questionList);
                    int check = setUserAnswers(binding.boxa, binding.boxb, binding.boxc, binding.boxd, binding.boxe, binding.boxf);
                    if (check == 0) {
                        messageDisplay("Please Select Your Answers.");

                    } else {
                        clearCheckBox(binding.boxa, binding.boxb, binding.boxc, binding.boxd, binding.boxe, binding.boxf);
                        questionCount++;
                        progressAcount++;
                        countQuestion(questionList);
                    }
                }
            });
        } else {
            messageDisplay("Sorry, We don't have Exam for this Category.");
        }
    }

    private int setUserAnswers(CheckBox... checkBoxs) {

        int check = 0;
        yourAnswer = new YourAnswers();
        for (CheckBox checkBox : checkBoxs) {
            if (checkBox == binding.boxa && binding.boxa.isChecked()) {
                yourAnswer.setYourAnswerA(true);
                check++;

            } else if (checkBox == binding.boxb && binding.boxb.isChecked()) {
                yourAnswer.setYourAnswerB(true);
                check++;

            } else if (checkBox == binding.boxc && binding.boxc.isChecked()) {
                yourAnswer.setYourAnswerC(true);
                check++;
            } else if (checkBox == binding.boxd && binding.boxd.isChecked()) {
                yourAnswer.setYourAnswerD(true);
                check++;
            } else if (checkBox == binding.boxe && binding.boxe.isChecked()) {
                yourAnswer.setYourAnswerE(true);
                check++;
            } else if (checkBox == binding.boxf && binding.boxf.isChecked()) {
                yourAnswer.setYourAnswerF(true);
                check++;
            }

        }
        if (check > 0) {

            yourAnswers.add(yourAnswer);
        }
        return check;
    }


    private void clearCheckBox(CheckBox... checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
        }
    }

    private void countQuestion(List<QuestionModel> questionList) {
        if (questionCount < questionList.size()) {
            binding.questionTextFragment.setText(questionList.get(questionCount).getQuestion());

            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerA(), binding.boxa);
            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerB(), binding.boxb);
            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerC(), binding.boxc);
            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerD(), binding.boxd);
            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerE(), binding.boxe);
            checkedAnswer(questionList.get(questionCount).getAnswers().getAnswerF(), binding.boxf);


        }

        binding.textProgress.setText(progressAcount + " / " + questionList.size());
        binding.progressBarQuestion.setProgress(progressAcount);
        // to change button to finish button exam
        if (questionCount == questionList.size() - 1) {

            resultFragments = new ResultFragments();
            yourResultFragment = new YourResultFragment();
            binding.fragmentNext.setText("Finish Exam");
            binding.fragmentNext.setBackgroundColor(getResources().getColor(R.color.blue));
            binding.fragmentNext.setTextColor(getResources().getColor(R.color.pink));
            binding.fragmentNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    checkecdCorrectAnswers(questionList);
                    int check = setUserAnswers(binding.boxa, binding.boxb, binding.boxc, binding.boxd, binding.boxe, binding.boxf);

                    if (check == 0) {
                        messageDisplay("Please Select Your Answers.");
                    } else {

                        yourResultFragment.setArguments(data);
                        data.putInt("count", correctAnswer);
                        data.putInt("total", questionList.size());
                        data.putParcelableArrayList("yourAnswers", (ArrayList<? extends Parcelable>) yourAnswers);
                        correctAnswer = 0;
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, yourResultFragment).commit();

                    }

                }
            });

        }
    }

    private void checkecdCorrectAnswers(List<QuestionModel> questionList) {
        if ((binding.boxa.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerACorrect())
                && (binding.boxb.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerBCorrect())
                && (binding.boxc.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerCCorrect())
                && (binding.boxd.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerDCorrect())
                && (binding.boxe.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerECorrect())
                && (binding.boxf.isChecked() == questionList.get(questionCount).getCorrectAnswers().isAnswerFCorrect())) {

            correctAnswer++;
        }
    }

    private void messageDisplay(String message) {
        AlertDialog dialog = new MaterialAlertDialogBuilder(getActivity())
                .setTitle("Message")
                .setMessage(message)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (message.equals("Please Select Your Answers.")) {
                            dialog.dismiss();
                        } else {
                            startActivity(new Intent(getActivity(), Home.class));
                            dialog.dismiss();
                        }

                    }
                })
                .create();
        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        yourAnswers = null;
        correctAnswer = 0;

    }

    private void checkedAnswer(String text, CheckBox checkBox) {
        if (text != null) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setText(text);

        } else {

            checkBox.setVisibility(View.GONE);

        }
    }
}
