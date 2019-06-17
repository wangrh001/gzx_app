package com.bangnd.util.repository;

import com.bangnd.util.entity.FormatInfoClientMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormatInfoClientMappingRepository extends JpaRepository<FormatInfoClientMapping, Integer> {

    @Query("select f from FormatInfoClientMapping f where f.clientKey =:clientKey and f.ocrFileType = :ocrFileType")
    public FormatInfoClientMapping findByClientKeyAndType(@Param(value = "clientKey") String clientKey,
                                                          @Param(value = "ocrFileType") int ocrFileType);
}
