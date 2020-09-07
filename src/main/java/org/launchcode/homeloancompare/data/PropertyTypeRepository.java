package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.PropertyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends CrudRepository<PropertyType, Integer> {
}
