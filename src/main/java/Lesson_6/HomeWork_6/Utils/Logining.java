package Lesson_6.HomeWork_6.Utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Logining implements Interceptor { //свой собственный написанный перехватчик
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();//Получили обьект запроса

        long t1 = System.nanoTime();

        System.out.println(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers())); //Сохранили информацию о времени нашего запроса

        Response response = chain.proceed(request); //Выполнили наш запрос получили респонс

        long t2 = System.nanoTime();

        System.out.println(String.format("Received response for %s in %.1fms%n%s", //залогировали респонс
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;// вернули респонс
    }
}
