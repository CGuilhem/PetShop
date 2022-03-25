package sdv.b3.calonne.bo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum FishLivEnv {

    @Enumerated(EnumType.STRING)
    FRESH_WATER, SEA_WATER;
}