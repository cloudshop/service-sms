package com.cloud.sms.repository;

import com.cloud.sms.domain.Source;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Source entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SourceRepository extends JpaRepository<Source, Long>, JpaSpecificationExecutor<Source> {

}
