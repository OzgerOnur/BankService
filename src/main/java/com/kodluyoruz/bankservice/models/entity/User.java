package com.kodluyoruz.bankservice.models.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@SQLDelete(sql = " UPDATE user SET deleted = true WHERE id = ? ")
@Where(clause = " deleted = false ")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String mail;
    // bunu deneme olarak yaptım netleşmedi, accountların id'lerini alacak mı merak ettim
    @JoinColumn(referencedColumnName = "account_id")
    private List<Integer> accountId;

    @OneToMany(mappedBy = "user",orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Account> account;


}
