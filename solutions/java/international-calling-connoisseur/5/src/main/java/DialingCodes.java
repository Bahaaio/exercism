import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    private final Map<Integer, String> codes = new HashMap<>();
    private final Map<String, Integer> reversedCodes = new HashMap<>();
    // O(1) solution XD

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        reversedCodes.remove(getCountry(code));
        codes.put(code, country);
        reversedCodes.put(country, code);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!codes.containsKey(code) && !reversedCodes.containsKey(country)) {
            setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        return reversedCodes.get(country);
    }

    public void updateCountryDialingCode(Integer code, String country) {
        if (reversedCodes.containsKey(country)) {
            codes.remove(findDialingCode(country));
            setDialingCode(code, country);
        }
    }
}
