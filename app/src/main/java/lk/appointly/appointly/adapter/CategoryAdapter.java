package lk.appointly.appointly.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import lk.appointly.appointly.R;
import lk.appointly.appointly.databinding.ViewholderCategoryBinding;
import lk.appointly.appointly.model.CategoryModel;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryModel> item;

    public CategoryAdapter(List<CategoryModel> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewholderCategoryBinding binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

        CategoryModel items = item.get(position);
        holder.binding.titleCart.setText(items.getName());

        Glide.with(holder.itemView.getContext()).load(items.getPicture()).into(holder.binding.picCart);

        int[] background = {
                R.drawable.blue_rec_bg,
                R.drawable.blue_btn_bg,
                R.drawable.purple_rec_bg,
                R.drawable.orange_rec_bg
        };

        int backgroundRes = background[position % 4];
        holder.binding.getRoot().setBackgroundResource(backgroundRes);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderCategoryBinding binding;

        public ViewHolder(ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
