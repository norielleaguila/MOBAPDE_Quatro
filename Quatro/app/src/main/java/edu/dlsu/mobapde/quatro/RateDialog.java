package edu.dlsu.mobapde.quatro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Norielle on 11/15/2017.
 */

public class RateDialog extends DialogFragment {

    final static String TAG = "RateDialog";

    View view;

    private RateDialog.OnUserApprovesListener mOnUserApprovesListener;

    public RateDialog.OnUserApprovesListener getOnUserApprovesListener() {
        return mOnUserApprovesListener;
    }

    public void setOnUserApprovesListener(RateDialog.OnUserApprovesListener mOnUserApprovesListener) {
        this.mOnUserApprovesListener = mOnUserApprovesListener;
    }

    public interface OnUserApprovesListener{
        public void onUserApproves(DialogInterface dialog, int which, String course, String grade, float rating);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_rate, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etCourse = (EditText) view.findViewById(R.id.rate_etCourse);
                        EditText etGrade = (EditText) view.findViewById(R.id.rate_etGrade);
                        RatingBar rtRating = (RatingBar) view.findViewById(R.id.rate_ratingBar);
                        mOnUserApprovesListener.onUserApproves(dialog, which, etCourse.getText().toString(), etGrade.getText().toString(), rtRating.getRating());
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
