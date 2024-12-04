package frontend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {
    VISA("Visa"),
    RU_PAY("RuPay"),
    MASTERCARD("MasterCard");

    private final String displayName;
}
