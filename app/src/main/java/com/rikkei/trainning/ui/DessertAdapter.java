package com.rikkei.trainning.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DessertAdapter extends RecyclerView.Adapter<DessertAdapter.DessertViewHolder> {

    private List<Dessert> desserts;

    public DessertAdapter(List<Dessert> desserts) {
        this.desserts = desserts;
    }

    @Override
    public DessertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_dessert, parent, false);
        return new DessertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DessertViewHolder holder, int position) {
        Dessert dessert = desserts.get(position);
        holder.txtName.setText(dessert.getName());
        holder.txtDescription.setText(dessert.getDescription());
        holder.txtFirstLetter.setText(dessert.getName().charAt(0)+"");

    }

    @Override
    public int getItemCount() {
        return desserts == null ? 0 : desserts.size();
    }

    public class DessertViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView txtDescription;
        private TextView txtFirstLetter;

        public DessertViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtDescription = itemView.findViewById(R.id.txt_desc);
            txtFirstLetter = itemView.findViewById(R.id.txt_firstLetter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), txtName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}