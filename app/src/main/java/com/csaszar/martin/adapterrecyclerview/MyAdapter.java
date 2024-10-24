package com.csaszar.martin.adapterrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    // ViewHolder osztály: Az egyes elemek nézeteinek létrehozása és újrahasznosítása
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView; // Az egyes nézetekhez tartozó TextView

        // Nézetek hozzákötése a ViewHolderhez
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    private List<String> nameList; // Az adatok, amiket megjelenítünk (nevek listája)

    // Adatok átadása
    public MyAdapter(List<String> nameList){
        this.nameList = nameList;
    }

    //RecyclerView.Adapter... osztály metódusainek implementálása

    //Új nézet létrehozása a sablonunk (recycler_item.xml) alapján
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(itemView);
    }

    //Adatok hozzárendelése a nézethez
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = nameList.get(position);
        holder.textView.setText(name);
    }

    //ez határozza meg, hogy hányszor kell végrehajtani a nézetlétrehozást
    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
