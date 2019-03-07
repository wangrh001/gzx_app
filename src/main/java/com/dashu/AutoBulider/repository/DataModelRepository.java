package com.dashu.AutoBulider.repository;

import com.dashu.AutoBulider.entity.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataModelRepository extends JpaRepository<DataModel, Long> {
    public List<DataModel> findDataModelsByTableNamesEquals(String tableName);
}
