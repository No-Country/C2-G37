package com.NoCruelty.NoCruelty.repositories;

import com.NoCruelty.NoCruelty.models.Zone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    @Query("SELECT c FROM Zone c WHERE c.province = :province AND c.country = :country")
    public Zone searchForProvinceCountry(@Param("province") String province, @Param("country") String country);

    @Query("SELECT c FROM Zone c WHERE c.province = :province")
    public List<Zone> searchForProvince(@Param("province") String province);

}
