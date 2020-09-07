package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer> {
}
