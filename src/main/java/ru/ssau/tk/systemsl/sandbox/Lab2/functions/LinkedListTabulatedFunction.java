package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Insertable, Removable{
    private Node head;
    private int count;

    public void addNode(double x, double y) {
        Node newNode = new Node(x, y);

        if (head == null) {
            // If empty, the new node becomes the head
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            // If not empty, add the new node to the end
            Node lastNode = head.prev;

            lastNode.next = newNode;
            newNode.prev = lastNode;
            newNode.next = head;
            head.prev = newNode;
        }
        count++;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Input arrays must have the same length and not be empty");
        }

        for (int i = 0; i < xValues.length; i++) {
            addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }

        if (count < 2) {
            throw new IllegalArgumentException("Count must be at least 2");
        }

        this.count = count;
        head = null;

        double step = (xTo - xFrom) / (count - 1);
        Node currentNode = null;

        for (int i = 0; i < count; i++) {
            double x = xFrom + i * step;
            addNode(x, source.apply(x));
            if (i == 0) {
                head = getNode(0);
            }
            currentNode = getNode(i);
        }

        if (currentNode != null) {
            currentNode.next = head;
            head.prev = currentNode;
        }
    }

    private Node getNode(int index) {
        Node currentNode;
        if (index < count / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = head.prev;
            for (int i = count - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    public int getCount() {
        return 0;
    }

    public double getX(int index) {
        return getNode(index).x;
    }

    public double getY(int index) {
        return getNode(index).y;
    }

    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    @Override
    public String toString() {
        Node node = head.next;
        String ans = head.toString();
        for (int i = 1; i < this.count; i++, node = node.next) {
            ans += " " + node.toString();
        }
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        LinkedListTabulatedFunction obj = (LinkedListTabulatedFunction) o;
        if (this.count != obj.count) return false;
        Node node1 = head;
        Node node2 = obj.head;
        for (int i = 1; i < this.count; i++, node1 = node1.next, node2 = node2.next) {
            if (!(node1.equals(node2)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        Node node = head.next;
        int result = 31 * head.hashCode();
        for (int i = 0; i < count; i++, node = node.next) {
            result = 31 * result + node.hashCode();
        }
        return result;
    }

    @Override
    public Object clone() {
        double[] CloneXValues = new double[count];
        double[] CloneYValues = new double[count];
        Node node1 = head;
        for (int i = 0; i < count; i++, node1 = node1.next) {
            CloneXValues[i] = node1.x;
            CloneYValues[i] = node1.y;
        }
        return new LinkedListTabulatedFunction(CloneXValues, CloneYValues);
    }

    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (getX(i) == x) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (getY(i) == y) {
                return i;
            }
        }
        return -1;
    }

    protected int floorIndexOfX(double x) {
        if (x < leftBound())
            return 0;
        else if (x > rightBound())
            return count;
        int i = 0;
            while (getX(i+1) < x) {
                i++;
            }
            return i;
    }

    public double leftBound() {
        return head.x;
    }

    public double rightBound() {
        return head.prev.x;
    }

    protected double interpolate(double x, int floorIndex) {
        double leftX = getX(floorIndex);
        double rightX = getX(floorIndex + 1);
        double leftY = getY(floorIndex);
        double rightY = getY(floorIndex + 1);

        return interpolate(x, leftX, rightX, leftY, rightY);
    }

    protected double interpolate(double x, Node floorNode) {
        double leftX = floorNode.x;
        double rightX = floorNode.next.x;
        double leftY = floorNode.y;
        double rightY = floorNode.next.y;

        return interpolate(x, leftX, rightX, leftY, rightY);
    }

    protected double extrapolateLeft(double x) {
        double x0 = getX(0);
        double x1 = getX(1);
        double y0 = getY(0);
        double y1 = getY(1);

        return interpolate(x, x0, x1, y0, y1);
    }

    protected double extrapolateRight(double x) {
        double xN1 = getX(count - 2);
        double xN = getX(count - 1);
        double yN1 = getY(count - 2);
        double yN = getY(count - 1);

        return interpolate(x, xN1, xN, yN1, yN);
    }

     static class Node {
        public Node next;
        public Node prev;
        public double x;
        public double y;

        @Override
        public String toString() {
            return ("("+ x + "; " + y + ")");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node oNode = (Node) o;
            return Double.compare(oNode.x, x) == 0 &&
                    Double.compare(oNode.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return 31 * 31 * Double.hashCode(x)  + Double.hashCode(y);
        }

        @Override
        protected Object clone() {

            Node cloneNode = new Node(x,y);
            cloneNode.prev = this.prev;
            cloneNode.next = this.next;
            return cloneNode;
        }

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private Node floorNodeOfX(double x) {
        Node currentNode = head;

        for (int i = 0; i < count; i++) {
            if (currentNode.x < x && currentNode.next.x > x) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null; //out of bounds
    }

    @Override
    public double apply(double x) {

        if (x < leftBound())
            return extrapolateLeft(x);

        else if (x > rightBound())
            return extrapolateRight(x);

        else if (indexOfX(x) != -1)
            return getY(indexOfX(x));
        else {
            insert(x, interpolate(x, floorNodeOfX(x)));
            return getY(indexOfX(x));
        }
    }

    public void insert(double x, double y) {
        if (this.count == 0) {
            addNode(x,y);
        }
        else {
            int i = indexOfX(x);
            if (i != -1)
                setY(i, y);
            else {
                if (x < leftBound()) {
                    addNode(x, y);
                    this.head = this.head.prev;
                } else if (x > rightBound()) {
                    addNode(x, y);
                }
                else {
                    Node pr = floorNodeOfX(x);
                    Node nt = pr.next;
                    Node nw = new Node(x, y);
                    nw.prev = pr;
                    nw.next = nt;
                    pr.next = nw;
                    nt.prev = nw;
                    count++;
                }
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        if (count == 1) {
            //only one element
            head = null;
        } else if (index == 0) {
            //removing the first element
            head = head.next;
            head.prev = head.prev.prev;
            head.prev.next = head;
        } else if (index == count - 1) {
            //removing the last element
            Node nodeToRemove = getNode(index);
            nodeToRemove.prev.next = head;
            head.prev = nodeToRemove.prev;
        } else {
            //removing an element in the middle
            Node nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        count--;
    }
}
