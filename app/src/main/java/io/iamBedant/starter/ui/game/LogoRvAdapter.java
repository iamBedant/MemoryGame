package io.iamBedant.starter.ui.game;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.iamBedant.starter.R;
import io.iamBedant.starter.data.remote.model.game.Logo;


/**
 * Created by @iamBedant on 11/05/17.
 */

public class LogoRvAdapter extends RecyclerView.Adapter<LogoRvAdapter.ContactViewHolder> {

    private ArrayList<Logo> mLogoList = new ArrayList<>();
    Context mContext;

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogo;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivLogo = (ImageView) itemView.findViewById(R.id.iv_logo);
        }
    }

    public LogoRvAdapter(Context context,ArrayList<Logo> data) {
        this.mLogoList.addAll(data);
        this.mContext = context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_logos, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
//        Log.d("diffutilcheck", "onBindViewHolder");
        if (!mLogoList.get(position).getHidden()) {
            Glide.with(mContext)
                    .load(mLogoList.get(position).getImage())
                    .into(holder.ivLogo);
        } else {
            Glide.with(mContext)
                    .load("https://cdn4.iconfinder.com/data/icons/miu/24/circle-help-question-mark-outline-stroke-128.png")
                    .into(holder.ivLogo);
        }

        holder.ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((GameActivity)mContext).logoClicked(mLogoList.get(position));
            }
        });
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position, List<Object> payloads) {
//        Log.d("diffutilcheck", "onBindViewHolder payload "+payloads.isEmpty());

        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {
//            Log.d("diffutilcheck", "onBindViewHolder with payload");
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()) {
                if (key.equals("isHidden")) {
                    if (!mLogoList.get(position).getHidden()) {
                        Glide.with(mContext)
                                .load(mLogoList.get(position).getImage())
                                .into(holder.ivLogo);
                    } else {
                        Glide.with(mContext)
                                .load("https://cdn4.iconfinder.com/data/icons/miu/24/circle-help-question-mark-outline-stroke-128.png")
                                .into(holder.ivLogo);
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mLogoList.size();
    }

    public ArrayList<Logo> getData() {
        return mLogoList;
    }

    public void onNewProducts(ArrayList<Logo> newProducts) {
//        Log.d("diffutilcheck", "Size : "+newProducts.size());
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new GameDiffUtilCallback(newProducts, mLogoList));
        diffResult.dispatchUpdatesTo(this);
        this.mLogoList.clear();
        this.mLogoList.addAll(newProducts);
    }
}