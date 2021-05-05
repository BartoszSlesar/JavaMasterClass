package codingExercise49AbstrackClass;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }


    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }
        if (item == null) {
            return false;
        }

        ListItem temp = this.root;
        while (true) {
            int compare = temp.compareTo(item);
            switch (compare) {
                case 0:
//                    item already exist in list
                    return false;
                case 1:
                    if (temp.previous() == null) {
                        temp.setPrevious(item);
                        return true;
                    }
                    temp = temp.previous();
                    break;
                default:
                    if (temp.next() == null) {
                        temp.setNext(item);
                        return true;
                    }
                    temp = temp.next();
                    break;
            }

        }

    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() != null && item.previous() != null) {
            ListItem parentLeft = item.next();
            ListItem parentLeftMin = parentLeft;
            while (parentLeftMin.previous() != null) {
                parentLeft = parentLeftMin;
                parentLeftMin = parentLeftMin.previous();
            }
            if (parent.next() == item) {
                parent.next().setValue(parentLeftMin.getValue());

            } else {
                parent.previous().setValue(parentLeftMin.getValue());

            }
            parentLeft.setPrevious(null);

        } else if (item.next() != null && item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else {
                parent.setPrevious(item.next());
            }

        } else if (item.previous() != null && item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else {
                parent.setPrevious(item.previous());
            }
        } else {
            if (parent.next() == item) {
                parent.setNext(null);
            } else {
                parent.setPrevious(null);
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {

        if (item == null) {
            return false;
        }
        boolean result = false;
        ListItem parent = this.root;
        ListItem temp = parent;
        while (temp != null) {
            int compare = temp.compareTo(item);
            switch (compare) {
                case 0:
//                    this item will be deleted
                    performRemoval(temp, parent);
                    result = true;
                case 1:
//                        check left node
                    parent = temp;
                    temp = temp.previous();
                    break;
                case -1:
//                            check right node
                    parent = temp;
                    temp = temp.next();
                    break;
            }
        }

        return result;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
