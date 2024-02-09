package ru.isands.elreg.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pair {
    private Long productId;
    private Long modelId;

    public Pair(Long productId, Long modelId) {
        this.productId = productId;
        this.modelId = modelId;
    }
}
