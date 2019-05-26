package com.laioffer.tinnews.save.detail;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.common.BaseViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

//3.5
public class AuthorViewModel extends BaseViewModel<AuthorViewModel.AuthorViewModelHolder> {

    //3.6
    private final String author;
    private final String timeStamp;

    //3.6
    public AuthorViewModel(String author, String timeStamp) {
        super(R.layout.author_layout);
        this.author = author;
        this.timeStamp = timeStamp;
    }

    //3.6
    @Override
    public AuthorViewModelHolder createItemViewHolder(View view) {
        //3.7
        return new AuthorViewModelHolder(view);
    }


    //3.6
    @Override
    public void bindViewHolder(AuthorViewModelHolder holder) {
        //3.8
        holder.author.setText(author);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        Date date = null;
        String formatTime = null;
        try {
            date = simpleDateFormat.parse(timeStamp);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            formatTime = simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.timeStamp.setText(formatTime);
    }


    //3.5
    static class AuthorViewModelHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView timeStamp;
        AuthorViewModelHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            timeStamp = itemView.findViewById(R.id.time_stamp);
        }
    }
}


