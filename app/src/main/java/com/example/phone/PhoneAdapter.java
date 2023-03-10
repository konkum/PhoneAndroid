package com.example.phone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    private Context context;
    ArrayList<Phone> listPhone = new ArrayList<>();
    private ActionInterface action;

    public PhoneAdapter(Context context, ArrayList<Phone> listPhone) {
        this.context = context;
        this.listPhone = listPhone;
    }

    public void setListPhone(ArrayList<Phone> list){
        listPhone=list;
    }
    public void setAction(ActionInterface action){
        this.action=action;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phone phone = listPhone.get(position);
        holder.phoneNameText.setText(phone.getPhoneName());
        holder.phoneCostView.setText(phone.getPhoneCost() + " đ");

        switch (phone.getIcon()){
            case 0:
                holder.iconImageView.setImageResource(R.drawable.android);
                break;
            case 1:
                holder.iconImageView.setImageResource(R.drawable.apple);
                break;
            case 2:
                holder.iconImageView.setImageResource(R.drawable.asus);
                break;
            case 3:
                holder.iconImageView.setImageResource(R.drawable.samsing);
                break;
        }

        holder.removeBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPhone.remove(position);
                action.Invoke();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPhone.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iconImageView;
        private TextView phoneNameText;
        private TextView phoneCostView;
        private Button removeBtnView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iconImageView=(ImageView) itemView.findViewById(R.id.phone_image);
            phoneNameText=(TextView) itemView.findViewById(R.id.phone_name);
            phoneCostView=(TextView) itemView.findViewById(R.id.phone_cost);
            removeBtnView=(Button) itemView.findViewById(R.id.remove_btn);
        }
    }
}
