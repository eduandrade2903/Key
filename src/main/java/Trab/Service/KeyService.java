package Trab.Service;

import Trab.DTOs.EmployeeDto.CreatedEmployeeDTO;
import Trab.DTOs.KeyDTOs.CreatedKeyDTO;
import Trab.Model.TblEmployee;
import Trab.Model.TblKey;
import Trab.Model.TblSector;
import Trab.Repository.EmployeeRepository;
import Trab.Repository.KeyRepository;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeyService {

    @Autowired
    private KeyRepository keyRepository;
    private final SectorRepository sectorRepository;
    private final ModelMapper modelMapper;

    //Create a new key in database
    public TblKey createNewKey (CreatedKeyDTO key) {
        Integer idSector = key.getIdSector();
        TblSector sector = sectorRepository.findById(idSector).orElseThrow(()->new RuntimeException("Setor nao encontrado"));

        TblKey _key = new TblKey();
        _key.setName(key.getName());
        _key.setAvailable(true);
        _key.setSector(sector);

        return keyRepository.save(_key);
    }

    //Search key by id
    public Optional<TblKey> serchKeyById(Integer idKey) { return keyRepository.findById(idKey); }

    //Create a description for the key
    public TblKey createDescription(TblKey description) { return  keyRepository.save(description); }




}


