package com.grahamp1.polldance;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by demouser on 6/13/13.
 */
public class EditAnswerDialogFragment extends DialogFragment {

    private int _index;
    private String _answerText = "";

    public EditAnswerDialogFragment(int i, String answerText) {
        _index = i;
        _answerText = answerText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_new_answer, null);
        final EditText answerText = (EditText) view.findViewById(R.id.new_answer_text);
        answerText.setText(_answerText);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((CreatePollActivity) getActivity()).editAnswerText(_index,
                                        answerText.getText().toString());
                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );

        return builder.create();
    }

}
