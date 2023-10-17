package com.example.FootballHuB.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter
@ToString
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq_generator")
    @SequenceGenerator(name = "cart_seq_generator", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    public static Cart createCart(Member member){
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }

}