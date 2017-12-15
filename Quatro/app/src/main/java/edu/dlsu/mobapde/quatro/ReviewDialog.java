package edu.dlsu.mobapde.quatro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
/**
 * Created by Norielle on 11/15/2017.
 */

public class ReviewDialog extends DialogFragment{

    View view;

    private OnUserApprovesListener mOnUserApprovesListener;

    public OnUserApprovesListener getOnUserApprovesListener() {
        return mOnUserApprovesListener;
    }

    public void setOnUserApprovesListener(OnUserApprovesListener mOnUserApprovesListener) {
        this.mOnUserApprovesListener = mOnUserApprovesListener;
    }

    public interface OnUserApprovesListener{
        public void onUserApproves(DialogInterface dialog, int which, String course, String grade, String review);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_review, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etCourse = (EditText) view.findViewById(R.id.review_etCourse);
                        EditText etGrade = (EditText) view.findViewById(R.id.review_etGrade);
                        EditText etReview = (EditText) view.findViewById(R.id.review_etReview);
                        mOnUserApprovesListener.onUserApproves(dialog, which, etCourse.getText().toString(), etGrade.getText().toString(), etReview.getText().toString());
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return  alertDialogBuilder.create();
    }

}
