package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;

    public Order(List<String> color) {
        this.firstName = "Nadezhda";
        this.lastName = "Leusenko";
        this.address = "Moskow, Lenina, 2";
        this.metroStation = "Lubyanka";
        this.phone = "+791 23 123 123";
        this.rentTime = 5;
        this.deliveryDate = "2026-12-12";
        this.comment = "Pozvonit za 1 chas do dostavki";
        this.color = color;
    }
}
