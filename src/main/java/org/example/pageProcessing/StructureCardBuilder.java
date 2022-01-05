package org.example.pageProcessing;

import org.example.modules.VI.*;

import java.io.IOException;

/**
 * Файл для составления конфигурации описания
 */
public class StructureCardBuilder {
    private static String characteristics;
    private static StringBuilder advantages;
    private static StringBuilder equipment;
    private static StringBuilder weight;
    private static StringBuilder features;

    public static void setCharacteristics(String characteristics) {
        StructureCardBuilder.characteristics = characteristics;
    }
    public static void setAdvantages(StringBuilder advantages) {
        StructureCardBuilder.advantages = advantages;
    }
    public static void setEquipment(StringBuilder equipment) {
        StructureCardBuilder.equipment = equipment;
    }
    public static void setWeight(StringBuilder weight) {
        StructureCardBuilder.weight = weight;
    }
    public static void setFeatures(StringBuilder features) {
        StructureCardBuilder.features = features;
    }
    private StructureCardBuilder() {
        throw new IllegalStateException("Utility class");
    }

    //функции для заполнения ттх
    public static StringBuilder BuildDescription() throws IOException {

        StringBuilder oneProductCard = new StringBuilder();
        Features.CreateFeatures();
        Characteristics.CreateCharacteristics();
        Advantages.CreateAdvantages();
        Equipment.CreateComplectation();
        Weight.CreateWeigth();
        oneProductCard.append(features).append(characteristics).append(advantages).append(equipment).append(weight);

        return oneProductCard;
    }


}
