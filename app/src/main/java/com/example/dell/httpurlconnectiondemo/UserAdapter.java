package com.example.dell.httpurlconnectiondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Dell on 24-Jan-18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<UserGitHub> mListUser = new ArrayList<>();
    private Context mContext;

    public UserAdapter(Context context, ArrayList<UserGitHub> arrUser) {
        mContext = context;
        mListUser = arrUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mListUser.size();
    }

    public void updateData(ArrayList<UserGitHub> usersList) {
        // Clear the list of previous user GitHub data, then add them to the
        mListUser.clear();
        mListUser.addAll(usersList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewId, mTextViewUserName, mTextViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewId = itemView.findViewById(R.id.text_id);
            mTextViewUserName = itemView.findViewById(R.id.text_name);
            mTextViewDescription = itemView.findViewById(R.id.text_descrip);
        }

        public void setData(int position) {
            UserGitHub user = mListUser.get(position);
            mTextViewId.setText(String.valueOf(user.getID()));
            mTextViewUserName.setText(user.getName());
            mTextViewDescription.setText(user.getDescription());
        }
    }
}
