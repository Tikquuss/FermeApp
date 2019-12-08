/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.jfoenix.controls.JFXDatePicker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.UnaryOperator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

/**
 *
 * @author Notsawo
 */
public class utillForComponent {
    public static void initDateAchatPicker(JFXDatePicker dateAchatPicker){
        //pour afficher/masquer une colonne indiquant les numéros de semaine. 
        dateAchatPicker.setShowWeekNumbers(false);
        //La date dans le champ de texte est automatiquement convertie au format local(dans mon cas, dd.MM.yyyy ). 
        //En définissant un StringConverter nous pouvons changer ceci, par exemple, en yyyy-MM-dd
        String pattern = "yyyy-MM-dd";
        dateAchatPicker.setPromptText(pattern.toLowerCase());
        dateAchatPicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override 
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override 
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        // Add some action (in Java 8 lambda syntax style).
        dateAchatPicker.setOnAction(event -> {
            LocalDate date = dateAchatPicker.getValue();
            System.out.println("Selected date: " + date);
        });
    }
    
    public static void initSpinner(Spinner<Integer> spinner, int min, int max, int defaut, int pas){
        SpinnerValueFactory.IntegerSpinnerValueFactory sv = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, defaut, pas);
        spinner.setValueFactory(sv);
        spinner.setEditable(true);

        // Regex pour controller l'entrée les caractères et les supprimer eventuellement
        UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change t) {
                String newText = t.getControlNewText() ;
                if(newText.matches("-?[0-9]*\\.?[0-9]*")) {
                    return t ;
                }
                return null ;
            }
        };

        // Autorisation de certains caratères
        StringConverter<Integer> converter = new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object.toString() ;
            }
            // Le point par exemple
            @Override
            public Integer fromString(String string) {
                if (string.isEmpty() /*|| ".".equals(string)*/) {
                    return 0 ;
                } else {
                    return new Integer(string);
                }
            }

        };
        
        sv.setConverter(converter);
        spinner.getEditor().setTextFormatter(new TextFormatter<>(converter, 0, filter));
    }
}
