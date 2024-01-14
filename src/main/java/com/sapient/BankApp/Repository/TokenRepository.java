package com.sapient.BankApp.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sapient.BankApp.model.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

//  @Query(value = """
//      select t from Token t inner join User u\s
//      on t.user.aadhar = u.aadhar\s
//      where u.aadhar = :id and (t.expired = false or t.revoked = false)\s
//      """)
//  List<Token> findAllValidTokenByUser(String id);

  Optional<Token> findByToken(String token);
}