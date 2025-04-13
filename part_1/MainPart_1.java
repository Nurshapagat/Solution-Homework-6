package com.example.part_1;

import java.util.ArrayList;
import java.util.List;

public class MainPart_1 {
    public static void main(String[] args) {
        List<SupportHandler> handlerList = new ArrayList<>();
        handlerList.add(new FAQBotHandler());
        handlerList.add(new JuniorSupportHandler());
        handlerList.add(new SeniorSupportHandler());

        SupportHandler chain = SupportChainBuilder.buildChain(handlerList);

        String[] issues = {
                "password_reset",
                "refund_request",
                "account_ban",
                "unknown_bug"
        };

        for (String issue : issues) {
            try {
                chain.handle(issue);
            } catch (UnresolvedIssueException e) {
                System.out.println("[System] ERROR: " + e.getMessage());
            }
        }
    }
}
