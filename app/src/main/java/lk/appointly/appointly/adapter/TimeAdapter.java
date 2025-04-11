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
import lk.appointly.appointly.databinding.ViewholderTimeBinding;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {

    private final List<String> timeSlots;
    private int selectPosition = -1;
    private int lastSelectPosition = -1;

    public TimeAdapter(List<String> timeSlots) {
        this.timeSlots = timeSlots;
    }


    @NonNull
    @Override
    public TimeAdapter.TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewholderTimeBinding binding = ViewholderTimeBinding.inflate(LayoutInflater.from(
                parent.getContext()
        ), parent, false);

        return new TimeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.TimeViewHolder holder, int position) {

        holder.bind(timeSlots.get(position), position, this);

    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {

        private final ViewholderTimeBinding binding;

        public TimeViewHolder(ViewholderTimeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String time, int position, TimeAdapter adapter) {

            Context context = binding.getRoot().getContext();
            binding.timeTxt.setText(time);
            if (adapter.selectPosition == position) {
                binding.timeTxt.setBackgroundResource(R.drawable.blue_btn_bg);
                binding.timeTxt.setTextColor(ContextCompat.getColor(binding.getRoot().getContext(), R.color.white));
            } else {
                binding.timeTxt.setBackgroundResource(R.drawable.light_grey_bg);
                binding.timeTxt.setTextColor(ContextCompat.getColor(binding.getRoot().getContext(), R.color.black));
            }

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.lastSelectPosition = adapter.selectPosition;
                    adapter.selectPosition = position;
                    adapter.notifyItemChanged(adapter.lastSelectPosition);
                    adapter.notifyItemChanged(adapter.selectPosition);
                }
            });


        }
    }
}
