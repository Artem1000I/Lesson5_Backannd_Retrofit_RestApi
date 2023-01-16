package Lesson_6.HomeWork_6.api;

import Lesson_6.HomeWork_6.dto.GetCategResp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
//нащ проект состоит из двух контроллеров поэтому пишем интерфейс для каждлгл клнтроллера
public interface CategorService { //описать ту часть с котороё мы будем взаимодействовать
    @GET("categories/{id}")//указываем способ взаимодействия метод который мы будем вызывать
    Call<GetCategResp> getCategory(@Path("id") int id);// имя метода(getCategory) /Указываем переменные которые будут подставляться в наш запрос
        //в Сall определяем обьект с которым будем взаимодействовать(GetCategoryResponse-это наш json)
}
