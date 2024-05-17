package com.project.zipkok.repository;
import com.project.zipkok.model.RealEstate;
import com.project.zipkok.model.User;
import com.project.zipkok.model.Zim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ZimRepository extends JpaRepository<Zim, Long> {
    Zim findFirstByUserAndRealEstate(User user, RealEstate realEstateId);

//    @Query("select count(z) > 0 from Zim z " +
//            "where z.user.userId = :userId " +
//            "and z.realEstate.realEstateId = :realEstateId"
//    )
//    Boolean existsByUserIdAndRealEstateId(Long userId, Long realEstateId);

    @Query(nativeQuery = true,
            value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM Zim " +
                    "WHERE user_id = :userId AND realestate_id = :realEstateId " +
                    "LIMIT 1 ")
    Long existsByUserIdAndRealEstateId(@Param("userId") Long userId, @Param("realEstateId") Long realEstateId);

    Zim findByUser(User user);

    List<Zim> findAllByUser(User user);
}
