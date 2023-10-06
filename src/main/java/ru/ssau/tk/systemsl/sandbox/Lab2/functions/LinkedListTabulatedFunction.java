package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private Node head;
    private int count;

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length || xValues.length == 0) {
            throw new IllegalArgumentException("Input arrays must have the same length and not be empty");
        }

        count = xValues.length;
        head = new Node(xValues[0], yValues[0]);

        Node currentNode = head;

        for (int i = 1; i < xValues.length; i++) {
            currentNode.next = new Node(xValues[i], yValues[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }

        // Make the list cyclic
        currentNode.next = head;
        head.prev = currentNode;
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
        head = new Node(xFrom, source.apply(xFrom));

        double step = (xTo - xFrom) / (count - 1);
        Node currentNode = head;

        for (int i = 1; i < count; i++) {
            double x = xFrom + i * step;
            currentNode.next = new Node(x, source.apply(x));
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }

        // Make the list cyclic
        currentNode.next = head;
        head.prev = currentNode;
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

    private static class Node {
        public Node next;
        public Node prev;
        public double x;
        public double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
