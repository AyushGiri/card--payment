package com.ayush.cardpayment.repository;

import com.ayush.cardpayment.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

    public Card findOne(int cardId);
    public List<Card> findAll();
    public Card save(Card card);
    public void delete(int cardId);

}
