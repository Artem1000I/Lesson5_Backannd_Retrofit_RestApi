package Lesson_6.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.messages.types.Product;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GetCategoryResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("products")
    private List<Product> products = new ArrayList<>();


}
