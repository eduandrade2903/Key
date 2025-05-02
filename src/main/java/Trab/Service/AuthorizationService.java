package Trab.Service;

import Trab.Repository.EmployeeRepository;
import Trab.Repository.SectorRepository;
import jakarta.jws.WebParam;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {


    private EmployeeRepository employeeRepository;
    private SectorRepository sectorRepository;
    private ModelMapper   modelMapper;


}
