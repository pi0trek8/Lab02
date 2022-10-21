package org.pwr.mapper;

import org.pwr.eto.JugEto;
import org.pwr.eto.PersonEto;
import org.pwr.models.Flavour;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper {

    protected JugEto mapToJug(String[] data) {
        return new JugEto(
                Long.parseLong(data[0].strip()),
//                new Flavour(Integer.parseInt(data[1].strip())),
                Integer.parseInt(data[1].strip()),
                Integer.parseInt(data[2].strip())

        );
    }

    protected PersonEto mapToPerson(String[] data) {
//        List<Flavour> preferences = Arrays.stream(data[1].split(","))
//                .map(element -> new Flavour(Integer.parseInt(element.strip())))
//                .collect(Collectors.toList());

        List<Integer> flavours = Arrays.stream(data[1].split(","))
                .map(element -> Integer.valueOf(element.strip()))
                .collect(Collectors.toList());

        return new PersonEto(
                Long.parseLong(data[0].strip()),
                flavours
        );
    }
}
