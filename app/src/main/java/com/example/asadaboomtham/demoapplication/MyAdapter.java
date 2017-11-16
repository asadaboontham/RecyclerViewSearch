package com.example.asadaboomtham.demoapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asada boomtham on 27/9/2560.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {

    //private List<ListItem> listItems;
    private Context context;
    //private List<ListItem> mFilteredList;

    private ArrayList<ListItem> mArrayList;
    private List<ListItem> mFilteredList;

//    public MyAdapter(List<ListItem> listItems, Context context, List<ListItem> mFilteredList) {
//        this.listItems = listItems;
//        this.context = context;
//        this.listItems = mFilteredList;
//    }

    public MyAdapter(List<ListItem> arrayList, Context context) {
        //this.listItems = listItems;
        this.mArrayList  = (ArrayList<ListItem>) arrayList;
        this.context = context;
        this.mFilteredList = arrayList;
       // this.listItems = mFilteredList;
    }

//    public MyAdapter(List<ListItem> listItems, Context applicationContext) {
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem listItem = mArrayList.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDes.setText(listItem.getDesc());
        holder.textViewRef.setText(listItem.getRef());


        Picasso.with(context)
                .load(listItem.getImageUrl())
                .into(holder.imageView);
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "clicked" + listItem.getHead(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    //Search Filter
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {


                    mFilteredList = mArrayList;
                } else {

                    List<ListItem> filteredList = new ArrayList<>();

                    for (ListItem listItem : mArrayList) {

                        if (listItem.getHead().toLowerCase().contains(charString) || listItem.getDesc().toLowerCase().contains(charString) || listItem.getRef().toLowerCase().contains(charString)) {

                            filteredList.add(listItem);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<ListItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDes;
        public TextView textViewRef;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDes = (TextView) itemView.findViewById(R.id.textViewDes);
            textViewRef = (TextView) itemView.findViewById(R.id.textViewRef);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }


}
