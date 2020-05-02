package easyRule;

import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule
public class WeatherRule {

    @Condition
    public boolean itRains() {
        return  Boolean.FALSE;
    }
}
