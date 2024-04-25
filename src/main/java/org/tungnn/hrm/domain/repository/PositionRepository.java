package org.tungnn.hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tungnn.hrm.domain.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
