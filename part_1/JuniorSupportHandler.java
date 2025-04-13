package com.example.part_1;

import java.util.logging.Logger;

public class JuniorSupportHandler extends SupportHandler {
    private static final Logger logger = Logger.getLogger(JuniorSupportHandler.class.getName());

    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        logger.info("JuniorSupport received issue: " + issue);
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            throw new UnresolvedIssueException(issue);
        }
    }
}
