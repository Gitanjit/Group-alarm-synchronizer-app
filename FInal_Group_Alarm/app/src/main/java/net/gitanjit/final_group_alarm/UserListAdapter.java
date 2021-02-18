package net.gitanjit.final_group_alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private OnItemClickListener mListener;

    private Context context;
    private ArrayList<UserHelperClass> users;

    public UserListAdapter(Context c, ArrayList<UserHelperClass> u)
    {
        context = c;
        users = u;
    }

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,phone;

        Button addbtn;
        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.Fname);
            phone = itemView.findViewById(R.id.phone);
            addbtn = itemView.findViewById(R.id.adduser);

            addbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.userlistcard,parent,false);
        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(users.get(position).getFullName());
        holder.phone.setText(users.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}