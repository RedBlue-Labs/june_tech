package com.example.jpa_11_webapplication.repository;

import com.example.jpa_11_webapplication.domain.Member;
import com.example.jpa_11_webapplication.domain.Order;
import com.example.jpa_11_webapplication.domain.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaQuery.from(Order.class);
        ArrayList<Predicate> criteria = new ArrayList<>();

        //주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = criteriaBuilder.equal(root.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }

        //회원이름 겸색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            //회원과 조인
            Join<Order, Member> memberJoin = root.join("member", JoinType.INNER);
            String pattern = "%" + orderSearch.getMemberName() + "%";
            Predicate name = criteriaBuilder.like(memberJoin.<String>get("name"), pattern);
            criteria.add(name);
        }
        criteriaQuery.where(
                criteriaBuilder.and(criteria.toArray(new Predicate[criteria.size()]))
        );
        TypedQuery<Order> orderTypedQuery = em.createQuery(criteriaQuery).setMaxResults(1000);// 최대 1000건
        return orderTypedQuery.getResultList();
    }
}
