package codingExercise49AbstrackClass;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }


    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null) {
            return false;
        }
        if (this.root == null) {
            this.root = item;
            return true;
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

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null || this.root == null) {
            return false;
        }
        ListItem temp = this.root;
        while (temp != null) {
            int compare = temp.compareTo(item);
            switch (compare) {
                case 0:
                    temp.previous().setNext(temp.next());
                    if (temp.next() != null) {
                        temp.next().setPrevious(temp.previous());
                    }
                    return true;
                case -1:
                    temp = temp.next();
                    break;
                default:
                    return false;
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
