package com.example.asus.guanzw.adatpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.guanzw.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ASUS on 2017/12/15.
 */

public class IAdapter extends RecyclerView.Adapter<IAdapter.IViewHolder> {
    private Context context;
    private List<Integer> listimage;
    private List<String> listtext;

    public IAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<Integer> list, List<String> list1) {
        if (listimage == null || listtext == null) {
            listimage = new ArrayList<>();
            listtext = new ArrayList<>();
        }
        listimage = list;
        listtext = list1;
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.itemlayout, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {

        holder.itemImage.setImageResource(listimage.get(position));
        holder.itemText.setText(listtext.get(position));
    }

    @Override
    public int getItemCount() {
        return listimage.size();
    }


    static class IViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_image)
        ImageView itemImage;
        @BindView(R.id.item_text)
        TextView itemText;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
