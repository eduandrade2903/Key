package Trab.Service;

import Trab.Model.TblKey;
import Trab.Repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class KeyService {

    @Autowired
    private KeyRepository keyRepository;

    //Create a new key in database
    public TblKey createNewKey (TblKey key) { return keyRepository.save(key); }

    //Search key by id
    public Optional<TblKey> serchKeyById(Integer idKey) { return keyRepository.findById(idKey); }

    //Create a description for the key
    public TblKey createDescription(TblKey description) { return  keyRepository.save(description); }





}


