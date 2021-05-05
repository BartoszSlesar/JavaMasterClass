package codingExercise49AbstrackClass;

public class Node extends ListItem {


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem rightLink) {
        this.rightLink = rightLink;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem SetPrevious(ListItem leftLink) {
        this.leftLink = leftLink;
        return leftLink;
    }

    @Override
    int compareTo(ListItem listItem) {
        if (listItem == null) {
            return 1;
        }
        String val = (String) this.value;
        return val.compareTo((String) listItem.getValue());
    }
}
