package order;

import client.OrderClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private final List<String> colors;
    private OrderClient orderClient;

    public CreateOrderTest(List<String> colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Тест цвета заказа: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {List.of("BLACK")},
                {List.of("GREY")},
                {Arrays.asList("BLACK", "GREY")},
                {Collections.emptyList()}
        };
    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Создание заказа с различными вариациями цветов")
    @Description("Проверка параметризации цветов: можно выбрать BLACK, GREY, оба цвета или не выбирать вовсе. Ответ должен содержать track.")
    public void createOrderWithDifferentColors() {
        Order order = new Order(colors);
        Response response = orderClient.create(order);

        response.then()
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }
}
