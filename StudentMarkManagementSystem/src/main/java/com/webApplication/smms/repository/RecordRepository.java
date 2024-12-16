package com.webApplication.smms.repository;

import com.webApplication.smms.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Records, Long> {
}
