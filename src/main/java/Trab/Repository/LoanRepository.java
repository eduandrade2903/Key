package Trab.Repository;

import Trab.Model.TblLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<TblLoan, Integer> {
}
