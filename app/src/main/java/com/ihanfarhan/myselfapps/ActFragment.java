package com.ihanfarhan.myselfapps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import list.ActData;
import list.ActDataInformation;

/*public class ActFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_act, container, false);
        return view;
    }
}*/


public class ActFragment extends Fragment
{
    private TextView mTextViewEmpty;
    private ProgressBar mProgressBarLoading;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_act, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTextViewEmpty = (TextView)view.findViewById(R.id.textViewEmpty);
        mImageViewEmpty = (ImageView)view.findViewById(R.id.imageViewEmpty);
        mProgressBarLoading = (ProgressBar)view.findViewById(R.id.progressBarLoading);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<ActData>();
        for (int i = 0; i < ActDataInformation.id.length; i++)
        {
            data.add(
                    new ActData (
                                    ActDataInformation.textArray[i],
                                    ActDataInformation.descArray[i],
                                    ActDataInformation.timeArray[i],
                                    ActDataInformation.imgArray[i]
                            ));
        }

        mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);

        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<ActData> dataList;

        public ListAdapter(ArrayList<ActData> data)
        {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewText;
            TextView textViewDesc;
            TextView textViewTime;
            ImageView imageViewImg;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewText = (TextView) itemView.findViewById(R.id.text);
                this.textViewDesc = (TextView) itemView.findViewById(R.id.desc);
                this.textViewTime = (TextView) itemView.findViewById(R.id.time);
                this.imageViewImg = (ImageView) itemView.findViewById(R.id.img);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_act, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewText.setText(dataList.get(position).getText());
            holder.textViewDesc.setText(dataList.get(position).getDesc());
            holder.textViewTime.setText(dataList.get(position).getTime());
            holder.imageViewImg.setImageResource(dataList.get(position).getImg());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }
}