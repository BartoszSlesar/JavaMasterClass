package interfaceChallengeSaveable.utils;

import java.util.List;

public class ReadWriteObject {
    private String className;
    private List<String> values;

    public ReadWriteObject(String className, List<String> values) {
        this.className = className;
        this.values = values;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getValues() {
        return values;
    }
}
