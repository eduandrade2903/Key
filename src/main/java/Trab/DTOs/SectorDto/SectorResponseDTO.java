package Trab.DTOs.SectorDto;

import lombok.Data;

@Data
public class SectorResponseDTO {
    private Integer id;
    private String name;

    public SectorResponseDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
