package com.ClinicaOdontologica.repository;

import com.ClinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
