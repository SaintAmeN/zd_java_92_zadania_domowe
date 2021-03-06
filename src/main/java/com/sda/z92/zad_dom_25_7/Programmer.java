package com.sda.z92.zad_dom_25_7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programmer {
    private Person person;
    private List<String> languages;
}
