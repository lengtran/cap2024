package entity;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "order_details")

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "qty")
    private Integer qty;

    @ManyToOne(fetch = FetchType.LAZY) // Correct
    @JoinColumn(name = "order_id") private Order order;

    @ManyToOne(fetch = FetchType.LAZY) // Correct
    @JoinColumn(name = "product_id") private Product product;



}
