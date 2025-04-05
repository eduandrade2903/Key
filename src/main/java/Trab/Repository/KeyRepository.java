package Trab.Repository;

import Trab.Model.TblKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends JpaRepository<TblKey, Integer> {
}
