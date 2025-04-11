package lk.appointly.appointly.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lk.appointly.appointly.adapter.DateAdapter;
import lk.appointly.appointly.adapter.TimeAdapter;
import lk.appointly.appointly.databinding.ActivityDetailBinding;
import lk.appointly.appointly.model.DoctorModel;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    private DoctorModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        item = (DoctorModel) getIntent().getSerializableExtra("object");

        setVariable();

        initDate();

        initTime();
    }

    private void initTime() {
        binding.timeView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.timeView.setAdapter(new TimeAdapter(generateTime()));
    }

    private void initDate() {
        binding.dataView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.dataView.setAdapter(new DateAdapter(generateDate()));
    }

    public static List<String> generateTime() {

        List<String> timeSlots = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        for (int i = 0; i < 24; i += 2) {
            LocalTime time = LocalTime.of(i, 0);
            timeSlots.add(time.format(formatter));
        }
        return timeSlots;
    }

    public static List<String> generateDate() {
        List<String> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE/dd/MMM");
        for (int i = 0; i < 7; i++) {
            dates.add(today.plusDays(i).format(formatter));
        }
        return dates;
    }

    private void setVariable() {

        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(item.getPicture())
                .into(binding.proImg);

        binding.addressTxt.setText(item.getAddress());
        binding.speciallTxt.setText(item.getSpecial());
        binding.nameeTxt.setText(item.getName());
        binding.patiensTxt.setText(item.getPatiens() + "");
        binding.experinceTxt.setText(item.getExpriense() + "Years");

    }
}