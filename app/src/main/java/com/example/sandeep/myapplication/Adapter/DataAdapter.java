package com.example.sandeep.myapplication.Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sandeep.myapplication.Fragments.Image_Fragment;
import com.example.sandeep.myapplication.Models.MyModel;
import com.example.sandeep.myapplication.R;

import java.util.List;

/**
 * Created by sandeep on 07-02-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{




    Activity activity;
  /*  FragmentManager fragmentManager = activity.getFragmentManager();
    FragmentTransaction ft;*/
 /* FragmentManager fragmentManager ;;//= activity.getFragmentManager();
    FragmentTransaction ft;*/
  android.app.FragmentManager fragmentManager ;//= getFragmentManager();
    android.app.FragmentTransaction ft;

    List<MyModel> list;
    LayoutInflater inflater;
    String description;
    String price;
    String name;
    String image_url;

    public DataAdapter(Activity activity, List<MyModel> list) {
        this.activity = activity;
        this.fragmentManager = activity.getFragmentManager();
        this.list = list;
        inflater = LayoutInflater.from(activity);

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        view = inflater.inflate(R.layout.product_layout,parent,false);
        //String type = "type";
        //int a = (int)view;
        String type = String.valueOf(view);

        return new FindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if(holder instanceof FindViewHolder)
        {
            FindViewHolder findViewHolder = (FindViewHolder) holder;

            //String description = list.get(position).getDescription();
            findViewHolder.textView.setText(list.get(position).getName());
            Glide.with(activity).load(list.get(position).getImage()).into(findViewHolder.imageView);
        }
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }


    public class FindViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;




        public FindViewHolder(View itemView)
        {

            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //MyModel myModel = new MyModel();
                    description = list.get(getAdapterPosition()).getDescription();
                    price = list.get(getAdapterPosition()).getPrice();
                    name = list.get(getAdapterPosition()).getName();
                    image_url = list.get(getAdapterPosition()).getImage();
                    ft = fragmentManager.beginTransaction();
                    Image_Fragment image_fragment = new Image_Fragment();
                    //ft.add(R.id.frame_image,image_fragment);
                    Bundle b = new Bundle();
                    b.putString("name",name);
                    b.putString("description",description);
                    b.putString("price",price);
                    b.putString("image",image_url);
                    image_fragment.setArguments(b);
                    ft.addToBackStack("products");
                    //ft.add(R.id.frame,image_fragment);
                    ft.replace(R.id.frame,image_fragment);
                    ft.commit();
                    /*Intent intent = new Intent(activity, Image_Fragment.class);
                    intent.putExtra("name",name);
                    intent.putExtra("price",price);
                    intent.putExtra("des",description);
                    *//*switch (getAdapterPosition())
                    {
                        case 0:
                            ft = fragmentManager.beginTransaction();
                            Image_Fragment image_fragment = new Image_Fragment();
                            //ft.add(R.id.frame_image,image_fragment);
                            ft.addToBackStack("products");
                            //ft.add(R.id.frame,image_fragment);
                            ft.replace(R.id.frame,image_fragment);
                            ft.commit();
                            break;

                        case 1:

                            break;

                        case 2:
                            break;

                        case 3:
                            break;

                        case 4:
                            break;

                    }
*/

                }
            });

            imageView = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView)itemView.findViewById(R.id.text);

        }
    }
}
