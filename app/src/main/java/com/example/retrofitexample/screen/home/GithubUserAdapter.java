package com.example.retrofitexample.screen.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitexample.R;
import com.example.retrofitexample.data.model.Item;
import com.example.retrofitexample.databinding.ItemResultBinding;

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
        ItemResultBinding itemResultBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_result,
                viewGroup, false);
        return new ViewHolder(itemResultBinding, mOnItemClickListener);
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
        private OnItemClickListener mOnListener;
        private ItemResultBinding mBinding;
        private Item mItem;

        public ViewHolder(@NonNull ItemResultBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            itemView.findViewById(R.id.text_name).setOnClickListener(this);;
            itemView.findViewById(R.id.text_id).setOnClickListener(this);
            itemView.findViewById(R.id.image_person_icon).setOnClickListener(this);
        }

        public ViewHolder(@NonNull ItemResultBinding binding, OnItemClickListener listener) {
            this(binding);
            mOnListener = listener;
            mBinding.setListener(mOnListener);
        }

        public void bindData(Item item) {
            setitem(item);
            mBinding.setItem(item);
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
