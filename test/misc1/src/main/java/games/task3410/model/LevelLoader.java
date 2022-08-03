package games.task3410.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        level = level % 60;
        if (level == 0) level = 60;

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        try {
            List<String> list = Files.readAllLines(levels);
            int start = 0;
            int height = 0;
            for (String string : list) {
                if (string.contains("Maze: " + level)) {
                    start = list.indexOf(string);
                    height = Integer.parseInt(list.get(start + 3).split(":")[1].trim());
                    start += 7;
                    break;
                }
            }
            for (int i = 0; i < height; i++) {
                int y = i * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;
                String s = list.get(start + i);

                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    int x = j * Model.FIELD_CELL_SIZE + Model.FIELD_CELL_SIZE / 2;
                    char c = chars[j];
                    switch (c) {
                        case 'X':
                            walls.add(new Wall(x, y));
                            break;
                        case '*':
                            boxes.add(new Box(x, y));
                            break;
                        case '.':
                            homes.add(new Home(x, y));
                            break;
                        case '&':
                            boxes.add(new Box(x, y));
                            homes.add(new Home(x, y));
                            break;
                        case '@':
                            player = new Player(x, y);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }
/*
    public GameObjects getLevel(int level) {
        Path packagePath = Paths.get("./4.JavaCollections/src/" +
                getClass().getPackage().getName().replace('.', '/'));

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int loopLevel;
        if (level > 60) loopLevel = level % 60;
        else loopLevel = level;

        try (BufferedReader reader = new BufferedReader(new FileReader(packagePath.resolve(levels).toFile()))) {
            int readLevel = 0;
            int x;
            int y = Model.FIELD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    readLevel = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }
                if (readLevel == loopLevel) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;
                        isLevelMap = !isLevelMap;

                        if (isEnd && !isLevelMap) break;
                        continue;
                    }
                    if (isLevelMap) {
                        x = Model.FIELD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    homes.add(new Home(x, y));
                                    break;
                                case '&':
                                    boxes.add(new Box(x, y));
                                    homes.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += Model.FIELD_CELL_SIZE;
                        }
                        y += Model.FIELD_CELL_SIZE;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }
*/
/*
    public GameObjects getLevel(int level) {
        HashSet<Wall> walls = new HashSet<>();
        for (int i = 0; i < 480; i += 20) {
            int x = i + 10;
            int y = 10;
            walls.add(new Wall(x, y));
            System.out.print(i + " ");
        }
        for (int i = 0; i < 480; i += 20) {
            int x = i + 10;
            int y = 460 - 10;
            walls.add(new Wall(x, y));
            System.out.print(i + " ");
        }
        return new GameObjects(
                walls,
                new HashSet<>(Arrays.asList(
                        new Box(110, 110),
                        new Box(310, 310)
                )),
                new HashSet<>(Arrays.asList(
                        new Home(110, 310),
                        new Home(310, 110)
                )),
                new Player(210, 210));
    }
*/
}
