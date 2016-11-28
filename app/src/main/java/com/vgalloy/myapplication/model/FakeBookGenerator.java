package com.vgalloy.myapplication.model;

import com.vgalloy.myapplication.mapper.TextParser;

/**
 * @author Vincent Galloy
 *         Created by vgalloy on 28/11/16.
 */
public final class FakeBookGenerator {

    /**
     * Constructor.
     * To prevent instantiation
     */
    private FakeBookGenerator() {
        throw new AssertionError();
    }

    public static SimpleBook fakeBook() {
        String text = "Hansel et Gretel ou Jeannot et Margot1 (en allemand Hänsel und Gretel), est un conte populaire figurant parmi ceux recueillis par les frères Grimm dans le premier volume des Contes de l'enfance et du foyer (Kinder- und Hausmärchen, 1812, nº KHM 15)." +
                "Le conte, l'un des plus célèbres parmi les contes merveilleux, met en scène un frère et une sœur perdus dans la forêt par leurs parents et qui, ensuite, se retrouvent aux prises avec une sorcière anthropophage." +
                "On peut le rapprocher, pour ce qui est de son point de départ du moins, de Nennillo et Nennella, conte de l'Italien Giambattista Basile, publié dans la première moitié du xviie siècle. Le motif des enfants abandonnés dans la forêt est par ailleurs présent dans le conte de Perrault Le Petit Poucet (fin du xviie siècle), mais on trouve un épisode comparable dès le début de la seconde moitié du xvie siècle, chez Martin Montanus2.";
        return new SimpleBook(TextParser.parse(text));
    }
}
