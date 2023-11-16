package br.edu.ifg;

import br.edu.ifg.entities.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Iniciando dicionário de listas
        Map<String, List<Item>> map = new HashMap<>();

        map.put("Female", new ArrayList<>());
        map.put("Male", new ArrayList<>());
        map.put("group A", new ArrayList<>());
        map.put("group B", new ArrayList<>());
        map.put("group C", new ArrayList<>());
        map.put("group D", new ArrayList<>());
        map.put("group E", new ArrayList<>());
        map.put("bachelor's degree", new ArrayList<>());
        map.put("master's degree", new ArrayList<>());
        map.put("associate's degree", new ArrayList<>());
        map.put("high school", new ArrayList<>());
        map.put("some college", new ArrayList<>());
        map.put("standard", new ArrayList<>());
        map.put("free/reduced", new ArrayList<>());
        map.put("completed", new ArrayList<>());
        map.put("none", new ArrayList<>());
        map.put("math score", new ArrayList<>());
        map.put("reading score", new ArrayList<>());
        map.put("writing score", new ArrayList<>());
        map.put("AllData", new ArrayList<>());

        String path = "/home/eduardo/IdeaProjects/EstruturaDeDados/src/main/java/br/edu/ifg/files/StudentsPerformance.csv";

        try {
            BufferedReader sc = new BufferedReader(new FileReader(path));

            boolean firstLine = true;
            String line;
            while ((line = sc.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    String[] headers = line.replace("\"", "").split(",");
                    // Definindo todos os mapas necessários
                } else {
                    String[] fields = line.replace("\"", "").split(",");
                    String gender = fields[0];
                    String race = fields[1];
                    String parentalLevelEducation = fields[2];
                    String lunch = fields[3];
                    String testPreparation = fields[4];
                    double mathScore = Double.parseDouble(fields[5]);
                    double readScore = Double.parseDouble(fields[6]);
                    double writeScore = Double.parseDouble(fields[7]);

                    Item item = new Item(gender, race, parentalLevelEducation, lunch, testPreparation, mathScore, readScore, writeScore);

                    // Definindo Gênero
                    if ("Female".equals(gender)) {
                        map.get("Female").add(item);
                    } else {
                        map.get("Male").add(item);
                    }
                    // Definindo raça
                    if ("group A".equals(race)) {

                        map.get("group A").add(item);

                    } else if ("group B".equals(race)) {

                        map.get("group B").add(item);

                    } else if ("group C".equals(race)) {

                        map.get("group C").add(item);

                    } else if ("group D".equals(race)) {

                        map.get("group D").add(item);

                    } else {

                        map.get("group E").add(item);
                    }

                    // Definindo nível de educação parental

                    if ("bachelor's degree".equals(parentalLevelEducation)) {

                        map.get("bachelor's degree").add(item);

                    } else if ("master's degree".equals(parentalLevelEducation)) {

                        map.get("master's degree").add(item);

                    } else if ("associate's degree".equals(parentalLevelEducation)) {

                        map.get("associate's degree").add(item);

                    } else if ("high school".equals(parentalLevelEducation)) {

                        map.get("high school").add(item);

                    } else {

                        map.get("some college").add(item);

                    }

                    // Definindo lanche
                    if ("standard".equals(lunch)) {

                        map.get("standard").add(item);

                    } else {

                        map.get("free/reduced").add(item);
                    }

                    // Definindo o teste de preparação
                    if ("completed".equals(testPreparation)) {

                        map.get("completed").add(item);

                    } else {

                        map.get("none").add(item);

                    }
                    map.get("math score").add(item);
                    map.get("reading score").add(item);
                    map.get("writing score").add(item);
                    map.get("AllData").add(item);
                    map.put("mathScoreRank", mathRank(new ArrayList<>(map.get("math score"))));
                    map.put("readScoreRank", readRank(new ArrayList<>(map.get("reading score"))));
                    map.put("writeScoreRank", writeRank(new ArrayList<>(map.get("writing score"))));

                    Item Item = new Item(gender, race, parentalLevelEducation, lunch, testPreparation, mathScore, readScore, writeScore);

                    if ("Female".equals(gender)) {
                        getOrCreateList(map, "Female").add(item);
                    } else {
                        getOrCreateList(map, "Male").add(item);
                    }

// Definindo raça
                    if ("group A".equals(race)) {
                        getOrCreateList(map, "group A").add(item);
                    } else if ("group B".equals(race)) {
                        getOrCreateList(map, "group B").add(item);
                    } else if ("group C".equals(race)) {
                        getOrCreateList(map, "group C").add(item);
                    } else if ("group D".equals(race)) {
                        getOrCreateList(map, "group D").add(item);
                    } else {
                        getOrCreateList(map, "group E").add(item);
                    }

// Definindo nível de educação parental
                    if ("bachelor's degree".equals(parentalLevelEducation)) {
                        getOrCreateList(map, "bachelor's degree").add(item);
                    } else if ("master's degree".equals(parentalLevelEducation)) {
                        getOrCreateList(map, "master's degree").add(item);
                    } else if ("associate's degree".equals(parentalLevelEducation)) {
                        getOrCreateList(map, "associate's degree").add(item);
                    } else if ("high school".equals(parentalLevelEducation)) {
                        getOrCreateList(map, "high school").add(item);
                    } else {
                        getOrCreateList(map, "some college").add(item);
                    }
                }
            }

            String message = "";
            message += "0  -  Exit\n";
            message += "1  -  Math Score Rank\n";
            message += "2  -  Read Score Rank\n";
            message += "3  -  Write Score Rank\n";
            message += "4  -  Bigger and Lesser Math Score\n";
            message += "5  -  Bigger and Lesser Read Score\n";
            message += "6  -  Bigger and Lesser Write Score\n";
            message += "7  -  List Group by Race\n";
            message += "8  -  List Group by Parental Level Education\n";
            message += "9  -  List Group by Lunch\n";
            message += "10 -  List Group By Test Preparation Course\n";

            // Construindo a interface
            while (true) {
                System.out.println(message);
                int option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        // Atividade 1
                        mostraLista(map.get("mathScoreRank"));
                        break;
                    case 2:
                        // Atividade 2
                        mostraLista(map.get("readScoreRank"));
                        break;
                    case 3:
                        // Atividade 3
                        mostraLista(map.get("writeScoreRank"));
                        break;
                    case 4:
                        // Atividade 4
                        System.out.println("Menor nota de matemática: " + map.get("mathScoreRank").get(0).getMathScore());
                        System.out.println("Maior nota de matemática: " + map.get("mathScoreRank").get(map.get("mathScoreRank").size() - 1).getMathScore());
                        break;
                    case 5:
                        // Atividade 5
                        System.out.println("Menor nota de leitura: " + map.get("readScoreRank").get(0).getReadScore());
                        System.out.println("Maior nota de leitura: " + map.get("readScoreRank").get(map.get("readScoreRank").size() - 1).getReadScore());
                        break;
                    case 6:
                        // Atividade 6
                        System.out.println("Menor nota de Escrita: " + map.get("writeScoreRank").get(0).getWriteScore());
                        System.out.println("Maior nota de Escrita: " + map.get("writeScoreRank").get(map.get("writeScoreRank").size() - 1).getWriteScore());
                        break;
                    case 7:
                        System.out.println("Which group of Race? ");
                        String raceOption = scanner.next();
                        List<Item> raceItems = map.get(raceOption);
                        if (raceItems != null) {
                            mostraLista(raceItems);
                        } else {
                            System.out.println("No data available for the selected race group.");
                        }
                        break;
                    case 8:
                        System.out.println("Which group of Parental Level Education? ");
                        String pleOption = scanner.next();
                        List<Item> pleItems = map.get(pleOption);
                        if (pleItems != null) {
                            mostraLista(pleItems);
                        } else {
                            System.out.println("No data available for the selected parental level education group.");
                        }
                        break;
                    case 9:
                        System.out.println("Which group of Lunch? ");
                        String lunch = scanner.next();
                        mostraLista(map.get(lunch));
                        break;
                    case 10:
                        System.out.println("Which group of Test Preparation Course? ");
                        String tpe = scanner.next();
                        mostraLista(map.get(tpe));
                        break;
                    default:
                        System.out.println("Make a valid choice");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Função que mostra as listas
    private static void mostraLista(List<Item> items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    // Atividade 1
    private static List<Item> mathRank(List<Item> items) {
        items.sort((item1, item2) -> Double.compare(item1.getMathScore(), item2.getMathScore()));
        return items;
    }

    // Atividade 2
    private static List<Item> readRank(List<Item> items) {
        items.sort((item1, item2) -> Double.compare(item1.getReadScore(), item2.getReadScore()));
        return items;
    }

    // Atividade 3
    private static List<Item> writeRank(List<Item> items) {
        items.sort((item1, item2) -> Double.compare(item1.getWriteScore(), item2.getWriteScore()));
        return items;
    }


    // Resolvendo erro de lista vazia
    private static List<Item> getOrCreateList(Map<String, List<Item>> map, String key) {
        return map.computeIfAbsent(key, k -> new ArrayList<>());
    }
}
