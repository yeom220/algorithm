package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;


    @Test
    void 상품주문() {
        // given
        Member member = createMember();
        Item book = createBook("JPA", 10000, 10);
        int orderCount = 2;
        // when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // then
        Order order = orderRepository.findOne(orderId);
        assertThat(order.getStatus()).isEqualTo(OrderStatus.ORDER);
        assertThat(order.getOrderItems().size()).isEqualTo(1);
        assertThat(order.getTotalPrice()).isEqualTo(20000);
        assertThat(book.getStockQuantity()).isEqualTo(8);
    }

    void 상품주문_재고수량초과() {
        // given
        Member member = createMember();
        Item book = createBook("JPA", 10000, 10);
        int orderCount = 11;

        // when
        // then
        assertThatThrownBy(() -> orderService.order(member.getId(), book.getId(), orderCount)).isInstanceOf(NotEnoughStockException.class);
    }

    void 주문취소() {
        // given
        Member member = createMember();
        Item book = createBook("JPA", 10000, 10);
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order order = orderRepository.findOne(orderId);
        assertThat(book.getStockQuantity()).isEqualTo(10);
        assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL);
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("member1");
        member.setAddress(new Address("경기", "일산", "123-123"));
        em.persist(member);
        return member;
    }
}