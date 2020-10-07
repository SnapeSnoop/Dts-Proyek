package com.example.restoran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private ArrayList<Menu> dataList;
    public MenuAdapter(ArrayList<Menu> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_view_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.txtKode.setText(dataList.get(position).getKode());
        holder.txtJenis.setText(dataList.get(position).getJenis());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtPenjelasan.setText(dataList.get(position).getPenjelasan());
        holder.txtHarga.setText(dataList.get(position).getHarga());

    }

    @Override
    public int getItemCount() {

        return (dataList != null) ? dataList.size() : 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKode, txtJenis, txtNama, txtPenjelasan, txtHarga;

        public MenuViewHolder(View itemView) {
            super(itemView);
            txtKode = (TextView) itemView.findViewById(R.id.txt_kode);
            txtJenis = (TextView) itemView.findViewById(R.id.txt_jenis);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtPenjelasan = (TextView) itemView.findViewById(R.id.txt_penjelasan);
            txtHarga = (TextView) itemView.findViewById(R.id.txt_harga);

        }
    }
}
