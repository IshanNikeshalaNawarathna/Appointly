package lk.appointly.appointly.repository;

import android.util.Log;

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
import lk.appointly.appointly.model.DoctorModel;

public class MainRepository {
private String TAG = "TEST CODE";
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
                    Log.d(TAG, String.valueOf(categoryModel));
                    if (categoryModel != null) {
                        list.add(categoryModel);
                    }

                }
                mutableLiveData.setValue(list);
                Log.d(TAG, String.valueOf(mutableLiveData));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return mutableLiveData;

    }

    public LiveData<List<DoctorModel>> loadDoctor(){

        final MutableLiveData<List<DoctorModel>> liveData = new MutableLiveData<>();
        DatabaseReference ref = database.getReference("Doctors");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                List<DoctorModel> list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DoctorModel item = dataSnapshot.getValue(DoctorModel.class);

                    if(item !=null){
                        list.add(item);
                    }

                }

                liveData.setValue(list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return liveData;

    }

}
