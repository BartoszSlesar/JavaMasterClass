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
    ListItem setPrevious(ListItem leftLink) {
        this.leftLink = leftLink;
        return leftLink;
    }

    @Override
    int compareTo(ListItem listItem) {
        int result = 0;
        if (listItem == null) {
            return 0;
        }

        String val = (String) this.value;
        int compare = val.compareTo((String) listItem.getValue());
        if (compare > 0) {
            result = 1;
        } else if (compare < 0) {
            result = -1;
        }

        return result;
    }
}
