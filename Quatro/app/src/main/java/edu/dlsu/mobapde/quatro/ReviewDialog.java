package edu.dlsu.mobapde.quatro;

import android.app.AlertDialog;
import android.app.Dialog;
import android.media.Rating;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

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
        public void onUserApproves(String course, String grade, double rating, String review);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_rate, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setView(view)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        EditText etCourse = (EditText) view.findViewById(R.id.review_etCourse);
//                        EditText etGrade = (EditText) view.findViewById(R.id.review_etGrade);
//                        EditText etReview = (EditText) view.findViewById(R.id.review_etReview);
//                        mOnUserApprovesListener.onUserApproves(dialog, which, etCourse.getText().toString(), etGrade.getText().toString(), etReview.getText().toString());
//                    }
//                })
//                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dismiss();
//                    }
//                })
                ;

        Button cancel = view.findViewById(R.id.button_cancel);
        Button ok = view.findViewById(R.id.button_ok);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etCourse = (EditText) view.findViewById(R.id.rate_etCourse);
                EditText etGrade = (EditText) view.findViewById(R.id.rate_etGrade);
                EditText etReview = (EditText) view.findViewById(R.id.review_etReview);
                RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rate_ratingBar);
                mOnUserApprovesListener.onUserApproves(etCourse.getText().toString(), etGrade.getText().toString(), ratingBar.getRating(), etReview.getText().toString());
            }
        });

        return  alertDialogBuilder.create();
    }

}
