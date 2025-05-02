package Trab.Service;

import Trab.DTOs.KeyDTOs.CreatedKeyDTO;
import Trab.Model.TblKey;
import Trab.Model.TblSector;
import Trab.Repository.KeyRepository;
import Trab.Repository.SectorRepository;
import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KeyService {


    private KeyRepository keyRepository;
    private final SectorRepository sectorRepository;
  //  private final ModelMapper modelMapper;

    //Create a new key in database
    public TblKey createNewKey (CreatedKeyDTO key) {
        Integer idSector = key.getIdSector();
        TblSector sector = sectorRepository.findById(idSector).orElseThrow(()->new RuntimeException("Setor nao encontrado"));

        TblKey _key = new TblKey();
        _key.setName(key.getName());
        _key.setAvailable(1);
        _key.setSector(sector);

        return keyRepository.save(_key);
    }

    //Search key by id
    public Optional<TblKey> serchKeyById(Integer idKey) {
        return keyRepository.findById(idKey);
    }

    public List<TblKey> getAllKeys() {
        return keyRepository.findAll();
    }

    //Update key by id
    public TblKey updateKey(Integer id) {
        TblKey existingKey = keyRepository.findById(id).orElseThrow(() -> new RuntimeException("Key not found"));
        //existingKey.setName(key.getName());
        Integer valor = existingKey.getAvailable();
        if (valor == 1) {
            existingKey.setAvailable(0);
        } else {
            existingKey.setAvailable(1);
        }
        return keyRepository.save(existingKey);
    }

    //Lógica de consulta disponibilidade da chave
    public TblKey avaiable() {
        List<TblKey> keys = keyRepository.findAll();
        for (TblKey key : keys) {
            if (key.getAvailable() == 1) {
                return key;
            }
        }
        return ;
    }
    public void deleteKeyById(Integer id) {
        keyRepository.deleteById(id);
    }


}


