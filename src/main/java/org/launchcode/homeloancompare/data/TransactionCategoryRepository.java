package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.TransactionCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionCategoryRepository extends CrudRepository<TransactionCategory, Integer> {
}
