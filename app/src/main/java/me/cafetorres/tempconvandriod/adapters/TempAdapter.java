package me.cafetorres.tempconvandriod.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.tempconvandriod.R;
import me.cafetorres.tempconvandriod.models.Temperature;

/**
 * Created by Carlos on 10/11/2016.
 */

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.ViewHolder> {

    private Context context;
    private List<Temperature> dataset;
    private OnItemClickListener onItemClickListener;

    public TempAdapter (Context context, List<Temperature> dataset, OnItemClickListener onItemClickListener) {
    this.context=context;
        this.dataset=dataset;
        this.onItemClickListener=onItemClickListener;
    }

    public TempAdapter(Context context,OnItemClickListener onItemClickListener)
    {
        this.context = context;
        this.dataset = new ArrayList<Temperature>();
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(TempAdapter.ViewHolder holder, int position) {
        Temperature element = dataset.get(position);
        String strTip = element.showTemp();
        holder.txtContent.setText(strTip);
        holder.setOnItemClickListener(element, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(Temperature record) {
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setOnItemClickListener(final Temperature element, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(element);
                }
            });
        }


    }

}
