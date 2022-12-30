package Lesson_5.HomeWork_5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.messages.types.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
//обьект для категорий
@JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class GetCategResp {//это наш JSON который мы определяем с помощью анатации jackson

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("products")
        private List<Product> products = new ArrayList<>();


    }

