package com.rac.suculentas.repository;

import com.rac.suculentas.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,String> {
}
