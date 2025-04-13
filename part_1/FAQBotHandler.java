package com.example.part_1;

import java.util.logging.Logger;

public class FAQBotHandler extends SupportHandler {
    private static final Logger logger = Logger.getLogger(FAQBotHandler.class.getName());

    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        logger.info("FAQBot received issue: " + issue);
        if (issue.equals("password_reset")) {
            System.out.println("[FAQBot] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            throw new UnresolvedIssueException(issue);
        }
    }
}
