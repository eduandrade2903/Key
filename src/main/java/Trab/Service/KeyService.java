package Trab.Service;

import Trab.Model.TblKey;
import Trab.Repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class KeyService {

    @Autowired
    private KeyRepository keyRepository;

    //Cria uma nova chave no banco
    public TblKey createNewKey (TblKey key) { return keyRepository.save(key); }

    //Busca chave pelo id
    public Optional<TblKey> serchKeyById(Integer idKey) { return keyRepository.findById(idKey); }

    //Cria descrição da na tabela
    public TblKey createDescription(TblKey description) { return  keyRepository.save(description); }

    //insere uma data de retirada da chave
    public TblKey setwithDrawDate ( Integer idKey, Date date) {
        Optional<TblKey> keyOptional = serchKeyById(idKey); //recupera o objeto TblKey baseado no id
        if (keyOptional.isPresent()) { //verifica se o objeto foi recuperado
            TblKey key = keyOptional.get(); //peva o objeto TblKey
            key.setWithDrawDate(date); //atualiza a data de retirada
            return keyRepository.save(key); // salva o ojetco atualizado
        }
        return null;
    }

    //insere uma data de devolução
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


