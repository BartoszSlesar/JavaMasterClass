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
            ListItem parentLeft = item;
            ListItem leftMin = parentLeft.next();
            while (leftMin.previous() != null) {
                parentLeft = leftMin;
                leftMin = leftMin.previous();
            }

            item.setValue(leftMin.getValue());

            if (parentLeft == item) {
                item.setNext(leftMin.next());
            } else {
                parentLeft.setPrevious(leftMin.next());
            }


        } else if (item.next() != null && item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                this.root = parent.next();
            }

        } else if (item.previous() != null && item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                this.root = item.previous();
            }
        } else {

            if (parent.next() == item) {
                parent.setNext(null);
            } else if (parent.previous() == item) {
                parent.setPrevious(null);
            } else {
                this.root = null;
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
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
