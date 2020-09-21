package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.PropertyCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyCategoryRepository extends CrudRepository<PropertyCategory, Integer> {
}