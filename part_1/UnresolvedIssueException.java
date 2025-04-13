package com.example.part_1;

public class UnresolvedIssueException extends Exception {
    public UnresolvedIssueException(String issue) {
        super("Issue unresolved: " + issue);
    }
}
