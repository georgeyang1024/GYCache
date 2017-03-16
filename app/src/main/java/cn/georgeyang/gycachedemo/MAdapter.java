package cn.georgeyang.gycachedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.georgeyang.gycachedemo.bean.Bean;

/**
 * Created by george.yang on 17/3/12.
 */

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bean bean = list.get(position);
        holder.bindData(bean);
    }

    private List<Bean> list;

    public void setList(List<Bean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(cn.georgeyang.gycache.R.id.image);
            mTextView = (TextView) v.findViewById(cn.georgeyang.gycache.R.id.text);
        }

        public void bindData (Bean bean) {
            mTextView.setText(bean.desc);
            GildeUtil.drLoadSingleImage(itemView.getContext(),bean.downloadUrl,imageView);
        }
    }
}
