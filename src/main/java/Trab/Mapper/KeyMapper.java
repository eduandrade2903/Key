package Trab.Mapper;

import Trab.DTOs.KeyDTOs.KeyResponseDTO;
import Trab.Model.TblKey;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class KeyMapper {

    private final ModelMapper modelMapper;

    public KeyResponseDTO toTDO(TblKey key) {

        return modelMapper.map(this, KeyResponseDTO.class);
    }

    public TblKey toEntity(KeyResponseDTO dto) {
        return modelMapper.map(dto, TblKey.class);
    }
}
