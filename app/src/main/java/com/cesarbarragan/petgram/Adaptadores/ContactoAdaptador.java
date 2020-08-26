package com.cesarbarragan.petgram.Adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cesarbarragan.petgram.DataBase.ConstructorContactos;
import com.cesarbarragan.petgram.POJO.ContactoPerritos;
import com.cesarbarragan.petgram.R;

import java.util.ArrayList;

import static android.view.LayoutInflater.*;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<ContactoPerritos> contactoPerritos;
    Activity activity;

    public ContactoAdaptador (ArrayList<ContactoPerritos> contacto, Activity activity){
        this.contactoPerritos = contacto;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = from(parent.getContext()).inflate(R.layout.cardview_contacto, parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder holder, int position) {
        final ContactoPerritos contacto = contactoPerritos.get(position);
        final String like = "" + contacto.getLikes()+" Likes";
        holder.ivFotodePerfil.setImageResource(contacto.getFoto());
        holder.tvNombrePerritoCV.setText(contacto.getNombrePerrito());
        holder.tvNumeroLikesCV.setText(like);

       /* if(contacto.getLikes()==0){
            holder.ivHuesitoAmarCV.setVisibility(View.INVISIBLE);
            holder.tvNumeroLikesCV.setVisibility(View.INVISIBLE);
        }*/

        holder.ivHuesitoBlanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "diste like a "+ contacto.getNombrePerrito(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLike(contacto);
                //like = constructorContactos.obtenerLike(contacto)+" Likes";
                holder.tvNumeroLikesCV.setText(String.valueOf(constructorContactos.obtenerLike(contacto)+ " Likes"));

                /*contacto.setLikes(1+contacto.getLikes());
                if (contacto.getLikes()>0){
                    holder.ivHuesitoAmarCV.setVisibility(View.VISIBLE);
                    holder.tvNumeroLikesCV.setVisibility(View.VISIBLE);
                    Toast.makeText(activity, "diste like a "+ contacto.getNombrePerrito(), Toast.LENGTH_SHORT).show();
                }
                holder.tvNumeroLikesCV.setText(like);*/
            }
        });

    }

    @Override
    public int getItemCount() { //debuelve la cantidad de elementos en mi lista de contactos
        return contactoPerritos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotodePerfil;
        private TextView tvNombrePerritoCV;
        private ImageButton ivHuesitoBlanCV;
        private ImageView ivHuesitoAmarCV;
        private TextView tvNumeroLikesCV;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotodePerfil      = (ImageView) itemView.findViewById(R.id.ivFotoPerfil);
            tvNombrePerritoCV   = (TextView) itemView.findViewById(R.id.tvNombrePerrito);
            ivHuesitoBlanCV     = (ImageButton) itemView.findViewById(R.id.ivHuesoBlanco);
            ivHuesitoAmarCV     = (ImageView) itemView.findViewById(R.id.ivHuesoAmarillo);
            tvNumeroLikesCV     = (TextView) itemView.findViewById(R.id.tvNumeroLikes);
        }
    }

}
