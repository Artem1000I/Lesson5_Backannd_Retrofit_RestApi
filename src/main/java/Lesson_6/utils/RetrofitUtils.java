package Lesson_6.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

@UtilityClass //используется ломбок говорим что класс является утилитарным
public class RetrofitUtils {

    Properties prop = new Properties();
    private static InputStream configFile;

    static {
        try {
            configFile = new FileInputStream("src/main/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public String getBaseUrl() {
        prop.load(configFile);
        return prop.getProperty("url");
    }

//ПЕРЕХВАТЧИКИ
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    LoggingInterceptor logging2 = new LoggingInterceptor();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


/*    public Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }*/

    public Retrofit getRetrofit(){
        logging.setLevel(BODY);//определяем уровень логирования, говорим что будем возвращать например боди
        httpClient.addInterceptor(logging2); //httpClient будет использовать перехватчик который мы указали logging2
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl()) //базовый урл
                .addConverterFactory(JacksonConverterFactory.create()) //джексон конвертер
                .client(httpClient.build())
                .build();
    }

}
