package Lesson_5.HomeWork_5.api;

import Lesson_5.HomeWork_5.dto.Products;
import io.cucumber.messages.types.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProdService {
    //Тут реализуем методы которые планируем тестировать

    @POST("products")
    Call<Products> createProduct(@Body Products createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @PUT("products")
    Call<Products> modifyProduct(@Body Products modifyProductRequest);

    @GET("products/{id}") //Для описания любого запроса нужно //аннатация которая определяет метод(@GET("products/{id}"))
    Call<Products> getProductById(@Path("id") int id);  //определение параметров (@Path("id") int id);
    //Возвращаемое значение Call<Product>

    @GET("products")
    Call<ResponseBody> getProducts();
}
