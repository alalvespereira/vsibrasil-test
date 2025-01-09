package com.alapsystems.com.vsibrasil_test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private String code;
    private String name;
    private String isin; // ISIN (International Securities Identification Number) identificador único de valores mobiliários

    @Override
    public boolean equals(Object obj) {

        if (this == obj) // Se os objetos forem iguais, já retorna verdadeiro
            return true;

        if (obj == null || getClass() != obj.getClass()) // Se o objeto for nulo ou de classe diferente, retorna falso
            return false;

        // Se o obj for da mesma classe e não nulo, faz o cast do obj e compara o isin para verificar se é o mesmo asset
        Asset asset = (Asset) obj;
        return Objects.equals(isin, asset.isin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isin);
    }

}
