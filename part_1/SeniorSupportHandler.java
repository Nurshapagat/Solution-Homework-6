package com.example.part_1;

import java.util.logging.Logger;

public class SeniorSupportHandler extends SupportHandler {
    private static final Logger logger = Logger.getLogger(SeniorSupportHandler.class.getName());

    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        logger.info("SeniorSupport received issue: " + issue);
        if (issue.equals("account_ban") || issue.equals("data_loss")) {
            System.out.println("[SeniorSupport] Handled " + issue);
        } else {
            System.out.println("[SeniorSupport] Cannot handle " + issue + " — escalate manually");
        }
    }
}
