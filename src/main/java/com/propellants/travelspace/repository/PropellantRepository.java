package com.propellants.travelspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.propellants.travelspace.model.Propellant;

/**
 * Repository for {@link Propellant} DB operations
 * 
 * @author ahidalgo
 *
 */
@Repository
public interface PropellantRepository extends JpaRepository<Propellant, Long> {

    /**
     * Get list of {@link Propellant#getId()} and {@link Propellant#getName()} order
     * by id
     * 
     * @return lis of ids and names of {@link Propellant}
     */
    @Query("SELECT p.id, p.name FROM Propellant p ORDER by p.id ASC")
    List<Object[]> findMinimunInfo();
}
