package org.choongang.orderDetails.controllers;

import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.choongang.product.entities.Product;

@Data
public class RequestQna {

    private Long seq;

    private Long productSeq;

    private String content;
}
