package lk.appointly.appointly.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import lk.appointly.appointly.model.CategoryModel;

public class MainRepository {

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();

    public LiveData<List<CategoryModel>> loadData() {
        final MutableLiveData<List<CategoryModel>> mutableLiveData = new MutableLiveData<>();

        DatabaseReference databaseReference = database.getReference("Category");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                List<CategoryModel> list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CategoryModel categoryModel = dataSnapshot.getValue(CategoryModel.class);

                    assert categoryModel != null;
                    list.add(categoryModel);

                }
                mutableLiveData.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return mutableLiveData;

    }

}
