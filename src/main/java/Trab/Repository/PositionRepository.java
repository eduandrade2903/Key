package Trab.Repository;

import Trab.Model.TblPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository <TblPosition, InternalError> {
}
