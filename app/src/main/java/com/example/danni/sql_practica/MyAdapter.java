package com.example.danni.sql_practica;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danni on 31/10/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    private ArrayList<Libros> data;

    public MyAdapter(Context context, ArrayList<Libros> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvLibro.setText(data.get(position).getLibro());
        holder.tvAutor.setText(data.get(position).getAutor());
        holder.tvPersona.setText(data.get(position).getPersona());
        holder.tvTelefono.setText(data.get(position).getTelefono());
        holder.tvId.setText(Integer.toString(data.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvLibro,tvAutor,tvPersona,tvTelefono,tvId;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvLibro=(TextView)itemView.findViewById(R.id.tvLibro);
            tvAutor=(TextView)itemView.findViewById(R.id.tvAutor);
            tvPersona=(TextView)itemView.findViewById(R.id.tvPersona);
            tvTelefono=(TextView)itemView.findViewById(R.id.tvTelefono);
            tvId=(TextView)itemView.findViewById(R.id.tvId);
        }
    }
}
