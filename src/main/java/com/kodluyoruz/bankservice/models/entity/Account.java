package com.kodluyoruz.bankservice.models.entity;


import com.kodluyoruz.bankservice.helper.AccountHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.iban4j.CountryCode;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@SuperBuilder
@SQLDelete(sql = "UPDATE accounts SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",insertable = false,nullable = false,updatable = false)
    private Customer customer;

    @Builder.Default
    private int balance = 0;

    private String currency;

    private String name;

    @Builder.Default
    private String iban = AccountHelper.createRandomIban(CountryCode.TR).toString();

    private String accountType;


}
