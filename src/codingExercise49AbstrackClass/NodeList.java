package codingExercise49AbstrackClass;

public interface NodeList {
    ListItem getRoot();

    boolean addItem(ListItem item);

    ListItem removeItem(ListItem item);

    void traverse();
}
