package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.TrainViewHolder> {

    private List<Train> trainList;

    public TrainAdapter(List<Train> trainList) {
        this.trainList = trainList;
    }

    @NonNull
    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_train, parent, false);
        return new TrainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainViewHolder holder, int position) {
        Train train = trainList.get(position);
        holder.tvDepart.setText(train.getVilleDepart());
        holder.tvArrivee.setText(train.getVilleArrivee());
        holder.tvHeureDepart.setText(train.getHeureDepart());
        holder.tvHeureArrivee.setText(train.getHeureArrivee());
    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    public static class TrainViewHolder extends RecyclerView.ViewHolder {
        TextView tvDepart, tvArrivee, tvHeureDepart, tvHeureArrivee;

        public TrainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDepart = itemView.findViewById(R.id.tvDepart);
            tvArrivee = itemView.findViewById(R.id.tvArrivee);
            tvHeureDepart = itemView.findViewById(R.id.tvHeureDepart);
            tvHeureArrivee = itemView.findViewById(R.id.tvHeureArrivee);
        }
    }
}