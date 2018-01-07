package com.example.android.cardview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RimjhimBhadani on 06-01-2018.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.TextViewHolder>{

    //specify the number of views the adapter will hold
    private int mNumberItems;
    final private ListItemClickListener mOnClickListener;

    MyAdapter(int numberOfItems, ListItemClickListener listener){
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view, parent, false);
        return new TextViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public interface ListItemClickListener{
        void onListItemClicked(int clickedItemIndex);
    }

    //inner class such that the View are cached
    class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mEventTextView;
        ImageView mEventBackground;
        public TextViewHolder(View itemView) {
            super(itemView);
            mEventTextView = (TextView) itemView.findViewById(R.id.event_title);
            mEventBackground = (ImageView) itemView.findViewById(R.id.event_background);
            itemView.setOnClickListener(this);
        }

        //MODIFY LATER
        void bind(int listIndex){
            mEventTextView.setText(Utils.events[listIndex]);
            mEventBackground.setImageResource(Utils.colors[listIndex]);
            int id = Utils.colors[listIndex];
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClicked(clickedPosition);
        }
    }
}
