package com.tingshuo.myretrofitdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tingshuo.myretrofitdemo.R;
import com.tingshuo.myretrofitdemo.enter.TopBean;

import java.util.List;

public class DoBanAdapter extends RecyclerView.Adapter<DoBanAdapter.DoBanHolder>  {

    private Context mContext;
    private List<TopBean.subjectsBean> mDatas;

    private DoBanAdapter(Context context, List<TopBean.subjectsBean> datas){
        this.mContext = context;
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public DoBanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_douban_rv, null);
        return new DoBanHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DoBanHolder holder, int position) {
        TopBean.subjectsBean subjectsBean = mDatas.get(position);

        holder.title.setText(subjectsBean.getTitle());
        holder.message.setText(subjectsBean.getMainland_pubdate());
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }

    class DoBanHolder extends RecyclerView.ViewHolder{

        private TextView title,message;


        public DoBanHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_douban_title);
            message = itemView.findViewById(R.id.item_douban_message);
        }
    }
}
