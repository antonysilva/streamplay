package br.com.streamplaydata.categories.clients;

import java.util.List;

import br.com.streamplaydata.base.RetrofitBase;
import br.com.streamplaydata.models.CategoryModel;
import br.com.streamplaydata.models.mappers.CategoryModelMapper;
import br.com.streamplaydata.services.CategoryService;
import br.com.streamplaydata.categories.callbacks.GetAllCategoryCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllCategoryClient extends RetrofitBase{

    private static GetAllCategoryClient instance;

    public static GetAllCategoryClient getInstance() {
        if(instance == null)
            instance = new GetAllCategoryClient();

        return instance;
    }

    public GetAllCategoryClient(){
    }

    public void execute(final GetAllCategoryCallback callback){
        try{
            CategoryService service = (CategoryService) getService(CategoryService.class);
            Call<List<CategoryModel>> call = service.getAll();

            call.enqueue(new Callback<List<CategoryModel>>() {
                @Override
                public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {
                    if(response.isSuccessful()){
                        callback.onSuccess(CategoryModelMapper.getInstance().convert(response.body()));
                    }
                }

                @Override
                public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                    callback.onError();
                }
            });
        }catch (Exception ex){

        }
    }

}
