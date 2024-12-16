package com.webApplication.smms.repository;

import com.webApplication.smms.model.Entries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entries, Long> {
}
