package com.picpay.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private BigDecimal amount;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime createTransaction;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime updateTransaction;
}
