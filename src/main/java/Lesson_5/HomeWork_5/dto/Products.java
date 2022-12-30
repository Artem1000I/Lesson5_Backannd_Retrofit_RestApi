package Lesson_5.HomeWork_5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

//обьект для продуктов
@JsonInclude(JsonInclude.Include.NON_NULL)
@With
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Products {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("categoryTitle")
    private String categoryTitle;
}
