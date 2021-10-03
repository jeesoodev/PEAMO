package com.osds.peamo.repository;

import com.osds.peamo.model.entity.PerfumeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerfumeCategoryRepository extends JpaRepository<PerfumeCategory, Long> {

	List<PerfumeCategory> getPerfumeCategoriesByCategoryIdIn(List<Long> categoryIdList);
    List<PerfumeCategory> getPerfumeCategoriesByCategoryId(long categoryId);
    List<PerfumeCategory> getPerfumeCategoriesByPerfumeId(long perfumeId);
	
	@Query(value = "SELECT perfume_id From peamo.api_perfumecategory", nativeQuery = true)
    List<Long> getAllPerfumeId();
	
	@Query(value = "SELECT perfume_id From peamo.api_perfumecategory WHERE category_id in (:categoryIdList)", nativeQuery = true)
    List<Long> getperfumeIdByCategoryId(List<Long> categoryIdList);
    
    @Query(value = "SELECT * From peamo.api_perfumecategory WHERE perfume_id = :perfumeId", nativeQuery = true)
    List<PerfumeCategory> getpcListByPerfumeId(long perfumeId);

    @Query(value = "SELECT perfume_id From peamo.api_perfumecategory WHERE category_id = :categoryId ORDER BY rand() LIMIT 1", nativeQuery = true)
	int getRandomPerfumeIdByCategoryId(Long categoryId);

}