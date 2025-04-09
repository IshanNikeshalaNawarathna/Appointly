package lk.appointly.appointly.mainViewModel;

import androidx.lifecycle.LiveData;

import java.util.List;

import lk.appointly.appointly.model.CategoryModel;
import lk.appointly.appointly.repository.MainRepository;

public class MainViewModel {

    private final MainRepository mainRepository;


    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public LiveData<List<CategoryModel>> loadCategoryModel(){
        return mainRepository.loadData();
    }

}
