package com.grahamp1.polldance;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by demouser on 6/12/13.
 */
public class SettingsDialogFragment extends DialogFragment {

    private int _layout;

    public SettingsDialogFragment(int menuItem) {
        _layout = menuItem;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(_layout, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Okay",
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
