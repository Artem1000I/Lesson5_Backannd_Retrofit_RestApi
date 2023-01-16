import Lesson_6.api.CategoryService;
import Lesson_6.dto.GetCategoryResponse;
import Lesson_6.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryTest {

    static CategoryService categoryService;
    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);// получаем обьект ретрофит и сообщаем что хотим
    }

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();//получаем обьект типа респонс у которого внутрии в качество боди содерэится обьект GetCategoryResponse

        assertThat(response.isSuccessful(), CoreMatchers.is(true)); // проверяем  успешный ли он
        assertThat(response.body().getId(), equalTo(1)); // проверяем значение боди
        assertThat(response.body().getTitle(), equalTo("Food"));
       // response.body().getProducts().forEach(product -> assertThat(product.getCategoryTitle(), equalTo("Food")));


    }

}