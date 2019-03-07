package com.bangnd.cs.repository;

import com.bangnd.cs.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeQuestionTypeRepository extends JpaRepository<KnowledgeQuestionType, Integer> {
}