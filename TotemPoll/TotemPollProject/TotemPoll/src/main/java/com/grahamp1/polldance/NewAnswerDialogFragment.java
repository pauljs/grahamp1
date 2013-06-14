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
 * Created by demouser on 6/12/13.
 */
public class NewAnswerDialogFragment extends DialogFragment {

    public NewAnswerDialogFragment() {}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.fragment_new_answer, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
            .setView(view)
            .setPositiveButton("Create",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String answerText = ((EditText)(view.findViewById(R.id.new_answer_text)))
                                .getText().toString();
                        ((CreatePollActivity) getActivity()).createNewAnswer(answerText);
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
