package com.example.part_1;

import java.util.List;

public class SupportChainBuilder {
    public static SupportHandler buildChain(List<SupportHandler> handlers) {
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        return handlers.get(0);
    }
}

