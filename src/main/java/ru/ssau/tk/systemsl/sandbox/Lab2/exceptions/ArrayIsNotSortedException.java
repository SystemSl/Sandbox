package ru.ssau.tk.systemsl.sandbox.Lab2.exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException() {}
    public ArrayIsNotSortedException(String msg) {
        super(msg);
    }
}
