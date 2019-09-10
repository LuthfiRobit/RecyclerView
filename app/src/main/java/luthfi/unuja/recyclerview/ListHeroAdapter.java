package luthfi.unuja.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {

    private ArrayList<Hero> listHero;

    public ListHeroAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Hero hero = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(hero.getName());
        holder.tvForm.setText(hero.getFrom());

        holder.rlList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(holder.itemView.getContext(), "Data di click" +  listHero.get(holder.getAdapterPosition()).getFrom(), Toast.LENGTH_SHORT).show();
                Intent intenDetail = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intenDetail.putExtra("foto", hero.getPhoto());
                intenDetail.putExtra("nama", hero.getName());
                intenDetail.putExtra("deskripsi", hero.getFrom());
                holder.itemView.getContext().startActivity(intenDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlList;
        ImageView imgPhoto;
        TextView tvName, tvForm;

        ListViewHolder(View itemView) {
            super(itemView);
            rlList = itemView.findViewById(R.id.rl_list);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvForm = itemView.findViewById(R.id.tv_item_from);
        }
    }
}
