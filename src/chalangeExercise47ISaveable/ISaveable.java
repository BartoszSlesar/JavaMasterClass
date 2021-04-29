package chalangeExercise47ISaveable;

import java.util.List;

public interface ISaveable {
    List<String> write();

    void read(List<String> values);
}
