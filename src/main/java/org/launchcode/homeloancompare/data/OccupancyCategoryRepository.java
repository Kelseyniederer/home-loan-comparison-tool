
package org.launchcode.homeloancompare.data;
import org.launchcode.homeloancompare.models.OccupancyCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OccupancyCategoryRepository extends CrudRepository<OccupancyCategory, Integer> {
}