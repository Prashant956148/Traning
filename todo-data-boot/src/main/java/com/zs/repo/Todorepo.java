package com.zs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zs.entity.TODO;

public interface Todorepo extends JpaRepository<TODO, Integer> {

	@Query("FROM TODO t WHERE t.user.uid=:uid")
	List<TODO> findByuser(@Param("uid")int uid) ;
	
	@Query("FROM TODO t WHERE t.status = :status")
	List<TODO> findByStatus(@Param("status") String status);
	
//	@Query("From TODO WHERE user.")

}
