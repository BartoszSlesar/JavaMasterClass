package interfaceChallengeSaveable;

import interfaceChallengeSaveable.utils.ReadWriteObject;

import java.util.List;

public interface ISaveable {
    ReadWriteObject saveData();

    void populateObject(ReadWriteObject object);
}
