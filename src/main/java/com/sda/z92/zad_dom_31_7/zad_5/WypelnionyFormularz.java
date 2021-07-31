package com.sda.z92.zad_dom_31_7.zad_5;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WypelnionyFormularz {
    private LocalDate dataUrodzenia;
    private Gender gender;
    private boolean pali;
    private boolean chodziZestresowany;

    @Override
    public String toString() {
        return "dataUrodzenia=" + dataUrodzenia + "\n" +
                "gender=" + gender + "\n" +
                "pali=" + pali + "\n" +
                "chodziZestresowany=" + chodziZestresowany + "\n";
    }
}
