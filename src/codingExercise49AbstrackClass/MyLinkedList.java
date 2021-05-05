package codingExercise49AbstrackClass;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }


    @Override
    public ListItem getRoot() {
        return null;
    }

    @Override
    public boolean addItem(ListItem item) {
        boolean result = false;
        if (this.root == null) {
            this.root = item;
            result = true;
        }
        ListItem temp = this.root;
        while (temp != null) {
            int compare = temp.compareTo(item);
            switch (compare) {
                case 0:
//                    item already exist in list
                    return false;
                case 1:
//                    item was added
                    ListItem tempPrev = temp.previous();
                    tempPrev.setNext(item).setPrevious(tempPrev);
                    item.setNext(temp).setPrevious(item);
                    return true;
                default:
//                    currentItem is less then item, so check further
                    if (temp.next() == null) {
//                        if temp is the last item in list, item was added
                        temp.setNext(item).setPrevious(temp);
                        return true;
                    } else {
                        temp = temp.next();
                    }
                    break;
            }

        }

        return result;
    }

    @Override
    public ListItem removeItem(ListItem item) {
        return null;
    }

    @Override
    public void traverse() {

    }
}
