package utils;

import java.util.Random;

public class RandomUtils {
  public static String getRandomResidentialComplex() {
    String[] complexes = {"ЖК «Новое Внуково»", "ЖК «Заречье Парк»", "ЖК «Мытищи Парк»", "МФК «Новоданиловская 8»",
            "Квартал «Спутник»", "ЖК «Алхимово»", "ЖК «Томилино Парк»", "ЖК «Остафьево»", "ЖК «Большое Путилково»",
            "ЖК «Люберцы»", "ЖК «Пригород Лесное»", "ЖК «Квартал Некрасовка»"};
    StringBuilder complex = new StringBuilder();
    int complexIndex = getRandomInt(0, complexes.length - 1);
    complex.append(complexes[complexIndex]);

    return complex.toString();
  }

  public static int getRandomInt(int min, int max) {
    Random r = new Random();

    return r.nextInt((max - min) + 1) + min;
  }
}
