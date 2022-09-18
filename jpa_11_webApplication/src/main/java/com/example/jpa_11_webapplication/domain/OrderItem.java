package com.example.jpa_11_webapplication.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    public Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    public Order order;

    public int orderPrice; // 주문가격
    public int count; // 주문 수량

    //생성 메소드
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        item.removeStock(count);
        return OrderItem.builder()
                .item(item)
                .orderPrice(orderPrice)
                .count(count)
                .build();
    }

    //비즈니스 로직
    public void cancel() {
        this.getItem().addStock(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
