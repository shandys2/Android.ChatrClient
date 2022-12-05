package com.example.clienteandroidchat;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clienteandroidchat.Models.Mensaje;
import com.example.clienteandroidchat.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.clienteandroidchat.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMensajeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyMensajeItemRecyclerViewAdapter.ViewHolder> {

    private final List<Mensaje> mValues;

    public MyMensajeItemRecyclerViewAdapter(List<Mensaje> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mensajeItem = mValues.get(position);
        holder.hora.setText(mValues.get(position).getHora());
        holder.usuario.setText(mValues.get(position).getUsuario());
        holder.mensaje.setText(mValues.get(position).getMensaje());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Mensaje mensajeItem;
        public final TextView hora;
        public final TextView usuario;
        public final TextView mensaje;


        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            hora = binding.hora;
            usuario = binding.usuario;
            mensaje = binding.mensaje;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mensaje.getText() + "'";
        }
    }
}