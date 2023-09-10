package com.zerobase.productapi.repository;

import com.zerobase.productapi.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
  boolean existsByUsrRegNumber(String regNumber);

  Optional<UserInfo> findByUsrKey(String usrKey);
}
