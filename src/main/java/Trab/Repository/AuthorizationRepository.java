package Trab.Repository;

import Trab.Model.TblAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<TblAuthorization, Integer> {

}
