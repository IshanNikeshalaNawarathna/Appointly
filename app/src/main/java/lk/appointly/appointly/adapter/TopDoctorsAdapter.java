package lk.appointly.appointly.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import lk.appointly.appointly.databinding.ViewholderTopDoctorBinding;
import lk.appointly.appointly.model.DoctorModel;

public class TopDoctorsAdapter extends RecyclerView.Adapter<TopDoctorsAdapter.ViewHolder> {

    private final List<DoctorModel> items;

    private Context context;

    public TopDoctorsAdapter(List<DoctorModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TopDoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        ViewholderTopDoctorBinding binding = ViewholderTopDoctorBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopDoctorsAdapter.ViewHolder holder, int position) {

        DoctorModel model = items.get(position);
        holder.binding.nameTxt.setText(model.getName());
        holder.binding.specialTxt.setText(model.getSpecial());
        holder.binding.ratingTxt.setText(model.getRating() + "Years");
        holder.binding.petinsTxt.setText(model.getPatiens());

        Glide.with(holder.itemView.getContext())
                .load(model.getPicture())
                .apply(new RequestOptions().transform(new CenterCrop()))
                .into(holder.binding.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewholderTopDoctorBinding binding;

        public ViewHolder(ViewholderTopDoctorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
