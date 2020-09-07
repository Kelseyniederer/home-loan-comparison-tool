package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.OccupancyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupancyTypeRepository extends CrudRepository<OccupancyType, Integer> {
}
