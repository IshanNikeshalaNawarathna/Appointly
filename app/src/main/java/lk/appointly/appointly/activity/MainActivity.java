package lk.appointly.appointly.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import lk.appointly.appointly.adapter.CategoryAdapter;
import lk.appointly.appointly.adapter.TopDoctorsAdapter;
import lk.appointly.appointly.databinding.ActivityMainBinding;
import lk.appointly.appointly.mainViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        model = new MainViewModel();
        setContentView(binding.getRoot());

        initCategory();
        initDoctor();

    }

    private void initDoctor() {
        binding.progressBarDoctor.setVisibility(View.VISIBLE);
        model.loadDoctorModel().observe(this,doctorModels -> {
            binding.doctorView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
            binding.doctorView.setAdapter(new TopDoctorsAdapter(doctorModels));
            binding.progressBarDoctor.setVisibility(View.GONE);
        });
    }

    private void initCategory() {

        binding.progressBarCart.setVisibility(View.VISIBLE);
        model.loadCategoryModel().observe(this,categoryModels -> {
            binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            binding.cartView.setAdapter(new CategoryAdapter(categoryModels));
            binding.progressBarCart.setVisibility(View.GONE);
        });

    }
}