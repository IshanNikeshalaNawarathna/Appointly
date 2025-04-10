package lk.appointly.appointly.mainViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lk.appointly.appointly.model.CategoryModel;
import lk.appointly.appointly.model.DoctorModel;
import lk.appointly.appointly.repository.MainRepository;

public class MainViewModel extends ViewModel {

    private final MainRepository mainRepository;


    public MainViewModel() {
        this.mainRepository = new MainRepository();
    }

    public LiveData<List<CategoryModel>> loadCategoryModel(){
        return mainRepository.loadData();
    }

    public LiveData<List<DoctorModel>> loadDoctorModel(){
        return mainRepository.loadDoctor();
    }

}
