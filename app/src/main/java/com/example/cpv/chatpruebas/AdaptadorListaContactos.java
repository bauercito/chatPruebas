package com.example.cpv.chatpruebas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptadorListaContactos extends BaseAdapter {
    ArrayList<Contacto> listaContactos=new ArrayList();
    Activity actividad;
    public AdaptadorListaContactos(Activity actividad,ArrayList<Contacto> listaContactos){
        this.listaContactos=listaContactos;
        this.actividad=actividad;
    }
    @Override
    public int getCount() {
        return listaContactos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaContactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.listview_contactos, null);
        }

        TextView nombre=v.findViewById(R.id.nombre_contactos);
        TextView telefono=v.findViewById(R.id.telefono_contactos);
        nombre.setText(listaContactos.get(position).getNombre());
        telefono.setText(listaContactos.get(position).getNumero());
        return v;
    }
}