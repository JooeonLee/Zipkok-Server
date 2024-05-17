package com.project.zipkok.repository;

import com.project.zipkok.model.Kok;
import com.project.zipkok.model.RealEstate;
import com.project.zipkok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KokRepository extends JpaRepository<Kok, Long> {
    Kok findFirstByUserAndRealEstate(User user, RealEstate realEstateId);

    @Query(nativeQuery = true,
            value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM Kok " +
                    "WHERE user_id = :userId AND realestate_id = :realEstateId " +
                    "LIMIT 1 ")
    Long existsByUserIdAndRealEstateId(@Param("userId") Long userId, @Param("realEstateId") Long realEstateId);

    Kok findByKokId(long kokId);
}
