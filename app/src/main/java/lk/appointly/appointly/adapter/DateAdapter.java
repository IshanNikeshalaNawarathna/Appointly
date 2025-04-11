package lk.appointly.appointly.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.appointly.appointly.R;
import lk.appointly.appointly.databinding.ViewholderDateBinding;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.TimeViewHolder> {

    private final List<String> timeSlots;
    private int selectPosition = -1;
    private int lastSelectPosition =-1;
    public DateAdapter(List<String> timeSlots) {
        this.timeSlots = timeSlots;
    }




    @NonNull
    @Override
    public DateAdapter.TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       ViewholderDateBinding binding = ViewholderDateBinding.inflate(LayoutInflater.from(
                parent.getContext()
        ), parent, false);

        return new TimeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DateAdapter.TimeViewHolder holder, int position) {

        holder.bind(timeSlots.get(position),position,this);

    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {

        private final ViewholderDateBinding binding;

        public TimeViewHolder(ViewholderDateBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String date, int position,DateAdapter adapter){

            Context context = binding.getRoot().getContext();

            String[] dateParts = date.split("/");
            if(dateParts.length == 3){
                binding.datTxt.setText(dateParts[0]);
                binding.dateMonthTxt.setText(dateParts[1]+" "+dateParts[2]);

                if(adapter.selectPosition == position){
                    binding.mainLayout.setBackgroundResource(R.drawable.blue_btn_bg);
                    binding.datTxt.setTextColor(ContextCompat.getColor(context,R.color.white));
                    binding.dateMonthTxt.setTextColor(ContextCompat.getColor(context,R.color.white));
                }else{
                    binding.mainLayout.setBackgroundResource(R.drawable.light_grey_bg);
                    binding.datTxt.setTextColor(ContextCompat.getColor(context,R.color.black));
                    binding.dateMonthTxt.setTextColor(ContextCompat.getColor(context,R.color.black));
                }

                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapter.lastSelectPosition = adapter.selectPosition;
                        adapter.selectPosition =position;
                        adapter.notifyItemChanged(adapter.lastSelectPosition);
                        adapter.notifyItemChanged(adapter.selectPosition);
                    }
                });

            }
        }
    }
}
