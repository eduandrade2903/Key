package Service;

import Model.TblKey;
import Repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class KeyService {

    @Autowired
    private KeyRepository keyRepository;

    //Cria uma nova chave no banco
    public TblKey createNewKey (TblKey key) { return keyRepository.save(key); }

    //Busca chave pelo id
    public TblKey serchKeyById (Integer idKey) { return keyRepository.findById(idKey).orElse(null); }

    //Cria descrição da na tabela
    public TblKey createDescription(TblKey description) { return  keyRepository.save(description); }

    //insere uma data de retirada da chave
    public TblKey setwithDrawDate ( Integer idKey, Date withDrawDate) {
       TblKey key = serchKeyById(idKey);
        if (key != null) {
            key.setWithDrawDate(withDrawDate);
            return keyRepository.save(key);
        }
        return null;
    }

    //insere uma data de devolução
    public TblKey setReturnDate ( Integer idKey, Date returnDate) {
        TblKey key = serchKeyById(idKey);
        if (key != null) {
            key.setReturnDate(returnDate);
            return keyRepository.save(key);
        }
        return null;
    }
}


