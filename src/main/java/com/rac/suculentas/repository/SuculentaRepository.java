package com.rac.suculentas.repository;

import com.rac.suculentas.model.Suculenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuculentaRepository extends JpaRepository<Suculenta,String> {
}
