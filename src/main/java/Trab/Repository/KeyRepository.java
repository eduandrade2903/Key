package Trab.Repository;

import Trab.Model.TblKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<TblKey, Integer> {
}
