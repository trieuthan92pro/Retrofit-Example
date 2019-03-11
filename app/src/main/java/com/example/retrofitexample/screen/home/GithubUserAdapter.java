package com.example.retrofitexample.screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Item> mItems;
    private OnItemClickListener mOnItemClickListener;

    public GithubUserAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mItems = new ArrayList<>();
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.item_result, viewGroup, false);
        return new ViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = mItems.get(i);
        viewHolder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setItems(List<Item> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        mItems.add(item);
        notifyItemChanged(mItems.size() - 1);
    }

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextName;
        private TextView mTextId;
        private ImageView mImageAvartar;
        private Context mContext;
        private OnItemClickListener mOnListener;
        private Item mItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextId = itemView.findViewById(R.id.text_id);
            mImageAvartar = (ImageView) itemView.findViewById(R.id.image_person_icon);
            mContext = itemView.getContext();

            mTextName.setOnClickListener(this);
            mTextId.setOnClickListener(this);
            mImageAvartar.setOnClickListener(this);
        }

        public ViewHolder(@NonNull View view, OnItemClickListener listener) {
            this(view);
            mOnListener = listener;
        }

        public void bindData(Item item) {
            setitem(item);
            mTextId.setText(String.valueOf(item.getId()));
            mTextName.setText(item.getLogin());
            Glide.with(mContext)
                    .load(item.getAvatarUrl())
                    .error(R.drawable.ic_person_add_black_24dp)
                    .circleCrop()
                    .into(mImageAvartar);
        }

        public void setitem(Item item) {
            mItem = item;
        }

        @Override
        public void onClick(View v) {
            mOnListener.onItemClick(mItem);
        }
    }
}
