package com.example.part_1;

public abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(String issue) throws UnresolvedIssueException;
}
