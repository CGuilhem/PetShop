package sdv.b3.calonne.bo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum ProdType {

    @Enumerated(EnumType.STRING)
    FOOD, CLEANING, ACCESSORY;
}
