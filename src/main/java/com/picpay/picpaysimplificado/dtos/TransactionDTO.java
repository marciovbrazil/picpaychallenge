package com.picpay.picpaysimplificado.dtos;

import java.math.BigDecimal;

/**
 * TransactionDTO
 */
public record TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
}