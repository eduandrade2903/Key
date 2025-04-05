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

    //Enter a withdrawal date
    public TblKey setwithDrawDate ( Integer idKey, Date date) {
        Optional<TblKey> keyOptional = serchKeyById(idKey); //Retrieve the key by id
        if (keyOptional.isPresent()) { //Verify if the key exists
            TblKey key = keyOptional.get(); //Get the key object
            key.setWithDrawDate(date); //Update the withdrawal date
            return keyRepository.save(key); //Save the updated key
        }
        return null;
    }

    //enter a return date
    public TblKey setReturnDate ( Integer idKey, Date returnDate) {
        Optional<TblKey> key = serchKeyById(idKey);
        if (key.isPresent()) {
            TblKey keyReturn = key.get();
          keyReturn.setReturnDate(returnDate);
            return keyRepository.save(keyReturn);
        }
        return null;
    }

}


