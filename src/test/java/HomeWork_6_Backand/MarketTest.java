package HomeWork_6_Backand;

import Lesson_6.HomeWork_6.Utils.RetrofitUt;
import Lesson_6.HomeWork_6.api.CategorService;
import Lesson_6.HomeWork_6.api.ProdService;
import Lesson_6.HomeWork_6.dto.GetCategResp;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MarketTest {
    static CategorService categoryService;

    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUt.getRetrofit().create(CategorService.class);// получаем обьект ретрофит и сообщаем что хотим
        productService = RetrofitUt.getRetrofit()
                .create(ProdService.class);
    }


    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategResp> response = categoryService.getCategory(1).execute();//получаем обьект типа респонс у которого внутрии в качество боди содерэится обьект GetCategoryResponse

        assertThat(response.isSuccessful(), CoreMatchers.is(true)); // проверяем  успешный ли он
        assert response.body() != null;
        assertThat(response.body().getId(), equalTo(1)); // проверяем значение боди
        assertThat(response.body().getTitle(), equalTo("Food"));
        //response.body().getProducts().forEach(product -> assertThat(product.getCategoryTitle(), equalTo("Food")));
        response.body().getProducts().forEach(product -> assertThat(product.toString(), equalTo("Food")));
    }

    static ProdService productService;
    io.cucumber.messages.types.Product product = null;
    Faker faker = new Faker();
    int id;

    @Test
}