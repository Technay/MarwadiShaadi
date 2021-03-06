package com.example.sid.marwadishaadi.Dashboard_Suggestions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sid.marwadishaadi.R;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Lawrence Dalmet on 31-05-2017.
 */

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.MyViewHolder> {


    private final Context context;
    private List<SuggestionModel> suggestionModelList;


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,cusId,highDeg,workLoc,height,company,annInc,mariSta,hometown;
        ImageView imgAdd;
        public MyViewHolder(View view)
        {
            super(view);
            name=(TextView) view.findViewById(R.id.name);
            cusId=(TextView)view.findViewById(R.id.cusId);
            imgAdd=(ImageView) view.findViewById(R.id.imgAdd);
            highDeg=(TextView) view.findViewById(R.id.highDeg);
            workLoc=(TextView) view.findViewById(R.id.workLoc);
            height=(TextView) view.findViewById(R.id.height);
            company=(TextView) view.findViewById(R.id.company);
            annInc=(TextView) view.findViewById(R.id.annInc);
            mariSta=(TextView) view.findViewById(R.id.mariSta);
            hometown=(TextView) view.findViewById(R.id.hometown);




        }
    }

    public SuggestionAdapter(Context context, List<SuggestionModel> suggestionModelList) {

        this.suggestionModelList = suggestionModelList;
        this.context=context;
    }

    @Override
    public SuggestionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.suggestions_row, parent, false);

        return new SuggestionAdapter.MyViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(SuggestionAdapter.MyViewHolder holder, final int position) {
        SuggestionModel suggest= suggestionModelList.get(position);
        String ag=suggest.getName()+", "+suggest.getAge();
        String cd=suggest.getComapany()+", "+suggest.getDesignation();
        holder.name.setText(ag);
        holder.cusId.setText(suggest.getCusId());


        Glide.with(context)
                .load(suggest.getImgAdd())
                .into(holder.imgAdd);

        holder.height.setText(suggest.getHeight());
        holder.workLoc.setText(suggest.getWorkLoc());

        holder.annInc.setText(suggest.getAnnInc());
        holder.hometown.setText(suggest.getHometown());
        holder.mariSta.setText(suggest.getMariSta());
        holder.company.setText(cd);
        holder.highDeg.setText(suggest.getHighDeg());


    }

    @Override
    public int getItemCount() {
        return suggestionModelList.size();
    }



}
